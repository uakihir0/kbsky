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
}