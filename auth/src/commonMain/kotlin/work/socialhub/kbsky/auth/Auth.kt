package work.socialhub.kbsky.auth

import work.socialhub.kbsky.auth.api.OAuthResource
import work.socialhub.kbsky.auth.api.WellKnownResource

interface Auth {

    fun wellKnown(): WellKnownResource
    fun oauth(): OAuthResource
}