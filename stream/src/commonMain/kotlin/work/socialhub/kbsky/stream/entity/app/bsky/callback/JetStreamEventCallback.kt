package work.socialhub.kbsky.stream.entity.app.bsky.callback

import work.socialhub.kbsky.stream.entity.app.bsky.model.Event

interface JetStreamEventCallback {

    fun onEvent(event: Event)
}