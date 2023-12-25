package kbsky.stream.internal.atproto;

import kbsky.ATProtocol;
import kbsky.ATProtocolException;
import kbsky.ATProtocolTypes;
import kbsky.stream.api.atproto.SyncResource;
import kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest;
import kbsky.stream.util.StreamClient;

import java.net.URL;

public class _SyncResource implements SyncResource {

    private final ATProtocol atproto;
    private final String uri;

    _SyncResource(
            ATProtocol atproto,
            String uri
    ) {
        this.atproto = atproto;
        this.uri = uri;
    }

    @Override
    public StreamClient subscribeRepos(
            SyncSubscribeReposRequest request
    ) {
        try {
            String url = "wss://" + new URL(this.uri).getHost()
                    + "/xrpc/" + ATProtocolTypes.SyncSubscribeRepos;
            return new StreamClient(atproto, url);

        } catch (Exception e) {
            throw new ATProtocolException(e);
        }
    }
}
