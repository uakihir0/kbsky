package work.socialhub.kbsky

import work.socialhub.kbsky.internal._Chat

object ChatFactory {
    fun instance(uri: String): Chat {
        return _Chat(uri)
    }
}
