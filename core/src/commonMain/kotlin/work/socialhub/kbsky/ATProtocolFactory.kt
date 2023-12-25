package work.socialhub.kbsky

import work.socialhub.kbsky.internal._ATProtocol

object ATProtocolFactory {
    fun instance(uri: String): ATProtocol {
        return _ATProtocol(uri)
    }
}
