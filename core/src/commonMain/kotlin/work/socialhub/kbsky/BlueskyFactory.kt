package work.socialhub.kbsky

import work.socialhub.kbsky.internal._Bluesky

object BlueskyFactory {
    fun instance(uri: String): Bluesky {
        return _Bluesky(uri)
    }
}
