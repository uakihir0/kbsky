package work.socialhub.kbsky.stream.internal.com.atproto

import io.ktor.http.Url
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.ATProtocolTypes.SyncSubscribeRepos
import work.socialhub.kbsky.stream.ATProtocolStreamConfig
import work.socialhub.kbsky.stream.api.com.atproto.SyncResource
import work.socialhub.kbsky.stream.api.entity.com.atproto.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.entity.com.atproto.SyncStreamClient

class _SyncResource(
    private val atproto: ATProtocol,
    private val config: ATProtocolStreamConfig,
) : SyncResource {

    override fun subscribeRepos(
        request: SyncSubscribeReposRequest
    ): SyncStreamClient {
        val url = ("wss://" + Url(config.firehoseUri).host
                + "/xrpc/" + SyncSubscribeRepos)
        return SyncStreamClient(atproto, url, request.filter)
    }
}
