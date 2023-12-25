package kbsky.stream.api.atproto;

import kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest;
import kbsky.stream.util.StreamClient;


/**
 * ATProtocol/Sync
 * <a href="https://atproto.com/lexicons/com-atproto-sync#comatprotosyncsubscriberepos">Reference</a>
 */
public interface SyncResource {

    /**
     * [WIP]
     * Subscribe to repo updates
     */
    StreamClient subscribeRepos(SyncSubscribeReposRequest request);
}
