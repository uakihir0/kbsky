package kbsky.stream.util;

import kbsky.ATProtocol;
import kbsky.ATProtocolException;
import kbsky.api.entity.atproto.repo.RepoGetRecordRequest;
import kbsky.api.entity.atproto.repo.RepoGetRecordResponse;
import kbsky.stream.util.callback.ClosedCallback;
import kbsky.stream.util.callback.ErrorCallback;
import kbsky.stream.util.callback.EventCallback;
import kbsky.stream.util.callback.OpenedCallback;
import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import net.socialhub.logger.Logger;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StreamClient implements WebSocketListener {

    private static final Logger logger = Logger.getLogger(StreamClient.class);

    private final Timer timer = new Timer(false);

    private final ExecutorService pool;
    private final ATProtocol atproto;
    private final WebSocketClient client;

    private boolean isOpen = false;

    private EventCallback eventCallback;
    private OpenedCallback openedCallback;
    private ClosedCallback closedCallback;
    private ErrorCallback errorCallback;

    public StreamClient(
            ATProtocol atproto,
            String uri
    ) {
        try {
            this.atproto = atproto;
            this.pool = Executors.newCachedThreadPool();
            this.client = new WebSocketClient(new URI(uri), this);

        } catch (Exception e) {
            throw new ATProtocolException(e);
        }
    }

    public void connect() {
        client.connect();
    }

    public void close() {
        client.disconnect();
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void onConnect() {
        logger.debug("[Connection Opened]");

        this.isOpen = true;
        if (openedCallback != null) {
            openedCallback.onOpened();
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!isOpen) {
                    timer.cancel();
                    return;
                }
                client.sendPing();
            }
        };

        timer.schedule(task, 10, 10000);
    }

    @Override
    public void onMessage(String message) {
        // ATProtocol always use binary message.
    }

    @Override
    public void onMessage(byte[] data) {

        try {
            ByteArrayInputStream b = new ByteArrayInputStream(data);
            List<DataItem> dataItems = new CborDecoder(b).decode();
            for (DataItem dataItem : dataItems) {
                Object object = flatting(dataItem);

                if (object instanceof java.util.Map) {

                    @SuppressWarnings("unchecked")
                    java.util.Map<String, Object> map = (java.util.Map<String, Object>) object;

                    // {"op":"1","t":"#commit"}
                    // 上記のような形式のデータは使い方が分からないので無視
                    if (map.containsKey("t")) {
                        continue;
                    }

                    @SuppressWarnings("unchecked")
                    List<java.util.Map<String, Object>> list = (List<java.util.Map<String, Object>>) map.get("ops");
                    for (java.util.Map<String, Object> op : list) {

                        // FIXME: 作成イベントのみ対象
                        String action = (String) op.get("action");
                        if (!action.equals("create")) {
                            continue;
                        }

                        String repo = (String) map.get("repo");
                        String path = (String) op.get("path");
                        String[] elements = path.split("/");

                        pool.submit(() -> {
                            try {
                                RepoGetRecordResponse response = atproto.repo()
                                        .getRecord(RepoGetRecordRequest.builder()
                                                .collection(elements[0])
                                                .rkey(elements[1])
                                                .repo(repo)
                                                .build())
                                        .get();

                                if (eventCallback != null) {
                                    eventCallback.onEvent(
                                            response.getCid(),
                                            response.getUri(),
                                            response.getValue()
                                    );
                                }

                            } catch (Exception e) {
                                logger.debug("[Record Deleted?]"
                                        + " repo: " + repo
                                        + " path: " + path);
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisconnect(int code, String reason) {
        logger.debug("[Connection Closed]" +
                " code: " + code +
                " reason: " + reason);

        this.isOpen = false;
        if (closedCallback != null) {
            closedCallback.onClosed(false);
        }
    }

    @Override
    public void onError(Exception error) {
        if (error != null) {
            logger.debug("[Connection Error]"
                    + " exception: " + error.getClass().getName()
                    + " message: " + error.getMessage()
                    + " trace: ", error);
        }
        if (errorCallback != null) {
            errorCallback.onError(error);
        }
    }

    private Object flatting(DataItem item) {

        if (item instanceof Map) {
            Map map = (Map) item;
            java.util.Map<String, Object> result = new HashMap<>();

            map.getKeys().forEach(key -> {
                result.put(key.toString(), flatting(map.get(key)));
            });
            return result;
        }

        if (item instanceof Array) {
            Array array = (Array) item;
            java.util.List<Object> result = new java.util.ArrayList<>();

            array.getDataItems().forEach(dataItem -> {
                result.add(flatting(dataItem));
            });
            return result;
        }

        if (item instanceof ByteString) {
            // FIXME
            // CAR is encoded in the above, so decode it
            // but no Java library supports it.
            return item;
        }

        return item.toString();
    }

    // region
    public void setEventCallback(EventCallback eventCallback) {
        this.eventCallback = eventCallback;
    }

    public void setOpenedCallback(OpenedCallback openedCallback) {
        this.openedCallback = openedCallback;
    }

    public void setClosedCallback(ClosedCallback closedCallback) {
        this.closedCallback = closedCallback;
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.errorCallback = errorCallback;
    }
    // endregion
}
