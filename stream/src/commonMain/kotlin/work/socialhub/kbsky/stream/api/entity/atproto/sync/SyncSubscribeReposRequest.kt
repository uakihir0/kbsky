package work.socialhub.kbsky.stream.api.entity.atproto.sync

import work.socialhub.kbsky.api.entity.share.MapRequest

class SyncSubscribeReposRequest : MapRequest {

    var cursor: String? = null
    var filter: List<String> = listOf()

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("cursor", cursor)
        }
    }
}
