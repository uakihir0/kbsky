package work.socialhub.kbsky.stream.internal.atproto

import io.ktor.http.*
import kbsky.stream.api.atproto.SyncResource
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.ATProtocolTypes.SyncSubscribeRepos
import work.socialhub.kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.util.StreamClient

class _SyncResource internal constructor(
    private val atproto: ATProtocol,
    private val uri: String
) : SyncResource {

    override fun subscribeRepos(
        request: SyncSubscribeReposRequest
    ): StreamClient {
        val url = ("wss://" + Url(this.uri).host
                + "/xrpc/" + SyncSubscribeRepos)
        println(url)
        return StreamClient(atproto, url)
    }
}
