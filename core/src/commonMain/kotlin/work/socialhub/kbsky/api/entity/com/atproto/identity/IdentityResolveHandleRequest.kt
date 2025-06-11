package work.socialhub.kbsky.api.entity.com.atproto.identity

import work.socialhub.kbsky.api.entity.share.MapRequest

data class IdentityResolveHandleRequest(
    /** The handle to resolve. If not supplied, will resolve the host's own handle. */
    var handle: String? = null
) : MapRequest {

    override fun toMap() =
        mutableMapOf<String, Any>().also {
            it.addParam("handle", handle)
        }

    fun handle(handle: String) = also { this.handle = handle }
}
