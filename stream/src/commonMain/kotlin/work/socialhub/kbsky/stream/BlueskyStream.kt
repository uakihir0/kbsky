package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.api.app.bsky.JetStreamResource

interface BlueskyStream {

    fun jetStream(): JetStreamResource
}