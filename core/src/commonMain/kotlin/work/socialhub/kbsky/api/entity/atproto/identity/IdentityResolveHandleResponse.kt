package work.socialhub.kbsky.api.entity.atproto.identity

import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@Serializable
@OptIn(ExperimentalObjCName::class)
@ObjCName(
    name = "KBskyIdentityResolveHandleResponse",
    swiftName = "KBskyIdentityResolveHandleResponse",
    exact = true
)
class IdentityResolveHandleResponse {
    var did: String? = null
}
