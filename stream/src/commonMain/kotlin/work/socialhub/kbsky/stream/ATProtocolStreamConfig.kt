package work.socialhub.kbsky.stream

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.domain.Service

data class ATProtocolStreamConfig(
    /**
     * URI of the FireHose.
     */
    var firehoseUri: String = Service.BSKY_NETWORK.uri,
) : ATProtocolConfig() {
}