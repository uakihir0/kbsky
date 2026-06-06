package work.socialhub.kbsky.stream.internal.app.bsky

import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.path
import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.stream.BlueskyStreamConfig
import work.socialhub.kbsky.stream.api.app.bsky.JetStreamResource
import work.socialhub.kbsky.stream.api.entity.app.bsky.JetStreamSubscribeRequest
import work.socialhub.kbsky.stream.entity.app.bsky.DeferredOptionsUpdate
import work.socialhub.kbsky.stream.entity.app.bsky.JetStreamClient

class JetStreamResourceImpl(
    private val bluesky: Bluesky,
    private val config: BlueskyStreamConfig
) : JetStreamResource {

    companion object {
        const val MAX_URL_DIDS = 50
    }

    override fun subscribe(
        request: JetStreamSubscribeRequest
    ): JetStreamClient {

        val useOptionsUpdate = request.wantedDids.size > MAX_URL_DIDS

        val builder = URLBuilder().also { b ->

            b.protocol = URLProtocol.WSS
            b.host = request.host ?: config.jetStreamHost
                    ?: BlueskyStreamConfig.defaultJetStreamHosts.random()

            if (request.wantedCollections.isNotEmpty()) {
                for (wantedCollection in request.wantedCollections) {
                    b.parameters.append("wantedCollections", wantedCollection)
                }
            }
            if (!useOptionsUpdate && request.wantedDids.isNotEmpty()) {
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
            if (useOptionsUpdate) {
                b.parameters.append("requireHello", "true")
            } else {
                request.requireHello?.let {
                    b.parameters.append("requireHello", it.toString())
                }
            }
            b.path("subscribe")
        }

        val client = JetStreamClient(builder.buildString())

        if (useOptionsUpdate) {
            client.deferredOptionsUpdate = DeferredOptionsUpdate(
                wantedCollections = request.wantedCollections,
                wantedDids = request.wantedDids,
                maxMessageSizeBytes = request.maxMessageSizeBytes,
            )
        }

        return client
    }
}