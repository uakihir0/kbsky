package work.socialhub.kbsky.stream

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.domain.Service

class ATProtocolStreamConfig : ATProtocolConfig() {

    /**
     * URI of the FireHose.
     */
    var firehoseUri: String = Service.BSKY_NETWORK.uri
}