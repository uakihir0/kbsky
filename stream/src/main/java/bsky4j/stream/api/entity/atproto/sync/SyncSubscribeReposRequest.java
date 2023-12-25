package kbsky.stream.api.entity.atproto.sync;

import kbsky.api.entity.share.MapRequest;

import java.util.HashMap;
import java.util.Map;

public class SyncSubscribeReposRequest implements MapRequest {

    private String cursor;

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        addParam(map, "cursor", getCursor());
        return map;
    }

    // region
    public static SyncSubscribeReposRequestBuilder builder() {
        return new SyncSubscribeReposRequestBuilder();
    }

    public String getCursor() {
        return cursor;
    }

    public static final class SyncSubscribeReposRequestBuilder {
        private String cursor;

        private SyncSubscribeReposRequestBuilder() {
        }

        public SyncSubscribeReposRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public SyncSubscribeReposRequest build() {
            SyncSubscribeReposRequest syncSubscribeReposRequest = new SyncSubscribeReposRequest();
            syncSubscribeReposRequest.cursor = this.cursor;
            return syncSubscribeReposRequest;
        }
    }
    // endregion
}
