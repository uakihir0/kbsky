package work.socialhub.kbsky

import work.socialhub.kbsky.domain.Service

open class ATProtocolConfig {

    /**
     * URI of the PDS.
     */
    var pdsUri: String = Service.BSKY_SOCIAL.uri

    /**
     * Change the URI to the PDS to which you belong when requesting a session-based API?
     * (If you use the Chat feature, you will need to change the URI to the PDS you belong to if you turn it off)
     */
    var updatePdsUri: Boolean = true
}