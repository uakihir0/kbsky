package work.socialhub.kbsky.stream.api.app.bsky

import work.socialhub.kbsky.stream.api.entity.app.bsky.JetStreamSubscribeRequest
import work.socialhub.kbsky.stream.entity.app.bsky.JetStreamClient

/**
 * https://docs.bsky.app/blog/jetstream
 */
interface JetStreamResource {

    fun subscribe(
        request: JetStreamSubscribeRequest
    ): JetStreamClient
}