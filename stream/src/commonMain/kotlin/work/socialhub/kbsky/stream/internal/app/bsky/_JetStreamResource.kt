package work.socialhub.kbsky.stream.internal.app.bsky

import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.path
import work.socialhub.kbsky.ATProtocolTypes.SyncSubscribeRepos
import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.stream.BlueskyStreamConfig
import work.socialhub.kbsky.stream.api.app.bsky.JetStreamResource
import work.socialhub.kbsky.stream.api.entity.app.bsky.JetStreamSubscribeRequest
import work.socialhub.kbsky.stream.entity.app.bsky.JetStreamClient

class _JetStreamResource(
    private val bluesky: Bluesky,
    private val config: BlueskyStreamConfig
) : JetStreamResource {

    override fun subscribe(
        request: JetStreamSubscribeRequest
    ): JetStreamClient {

        val builder = URLBuilder().also { b ->

            b.protocol = URLProtocol.WSS
            b.host = request.host ?: config.jetStreamHosts.random()

            if (request.wantedCollections.isNotEmpty()) {
                for (wantedCollection in request.wantedCollections) {
                    b.parameters.append("wantedCollections", wantedCollection)
                }
            }
            if (request.wantedDids.isNotEmpty()) {
                for (wantedDid in request.wantedDids) {
                    b.parameters.append("wantedDids", wantedDid)
                }
            }
            request.cursor?.let {
                b.parameters.append("cursor", it.toString())
            }
            request.maxMessageSizeBytes?.let {
                b.parameters.append("maxMessageSizeBytes", it.toString())
            }
            request.requireHello?.let {
                b.parameters.append("requireHello", it.toString())
            }
            b.path("subscribe")
        }

        return JetStreamClient(builder.buildString())
    }
}