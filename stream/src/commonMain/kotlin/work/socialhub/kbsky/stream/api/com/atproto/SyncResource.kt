package work.socialhub.kbsky.stream.api.com.atproto

import work.socialhub.kbsky.stream.api.entity.com.atproto.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.entity.com.atproto.SyncStreamClient

/**
 * ATProtocol/Sync
 * [Reference](https://atproto.com/lexicons/com-atproto-sync#comatprotosyncsubscriberepos)
 */
interface SyncResource {
    /**
     * [WIP]
     * Subscribe to repo updates
     */
    fun subscribeRepos(
        request: SyncSubscribeReposRequest
    ): SyncStreamClient
}
