package work.socialhub.kbsky

import work.socialhub.kbsky.stream.ATProtocolStreamFactory

class BskyFactory {

    fun stream(
        apiUri: String,
        streamUri: String
    ) = ATProtocolStreamFactory.instance(apiUri, streamUri)

    fun bluesky(
        apiUri: String
    ) = BlueskyFactory.instance(apiUri)

    fun atproto(
        apiUri: String,
    ) = ATProtocolFactory.instance(apiUri)

    companion object {

        /**
         * 参照を行わないとフレームワーク内でオミットされるため。
         * Because it is omitted in the framework if no reference is made.
         */
        val references = listOf<Any>(
            ATProtocolStreamFactory::class,
            ATProtocolFactory::class,
            ATProtocolTypes::class,
            BlueskyFactory::class,
            BlueskyTypes::class,
            PLCDirectoryFactory::class,
            PLCDirectory::class,
        )
    }
}