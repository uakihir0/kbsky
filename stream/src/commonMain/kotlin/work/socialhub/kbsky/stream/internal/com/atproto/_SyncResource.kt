package work.socialhub.kbsky.stream.internal.com.atproto

import io.ktor.http.*
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.ATProtocolTypes.SyncSubscribeRepos
import work.socialhub.kbsky.stream.ATProtocolStreamConfig
import work.socialhub.kbsky.stream.api.com.atproto.SyncResource
import work.socialhub.kbsky.stream.api.entity.com.atproto.sync.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.util.StreamClient

class _SyncResource(
    private val atproto: ATProtocol,
    private val config: ATProtocolStreamConfig,
) : SyncResource {

    override fun subscribeRepos(
        request: SyncSubscribeReposRequest
    ): StreamClient {
        val url = ("wss://" + Url(config.firehoseUri).host
                + "/xrpc/" + SyncSubscribeRepos)
        return StreamClient(atproto, url, request.filter)
    }
}
