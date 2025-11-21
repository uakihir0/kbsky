package work.socialhub.kbsky

import work.socialhub.kbsky.internal._ATProtocol

object ATProtocolFactory {
    fun instance(uri: String): ATProtocol {
        return _ATProtocol(ATProtocolConfig()
            .also { it.pdsUri = uri })
    }

    fun instance(config: ATProtocolConfig): ATProtocol {
        return _ATProtocol(config)
    }
}
