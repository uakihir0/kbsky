package kbsky.stream.util.callback;

import kbsky.model.share.RecordUnion;

public interface EventCallback {

    void onEvent(String cid, String uri, RecordUnion record);
}
