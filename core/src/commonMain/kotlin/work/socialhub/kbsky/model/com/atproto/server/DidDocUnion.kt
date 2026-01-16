package work.socialhub.kbsky.model.com.atproto.server


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.util.json.DidDocPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see DIDDetails
 */
@JsExport
@Serializable(with = DidDocPolymorphicSerializer::class)
abstract class DidDocUnion {

    val asDIDDetails get() = this as? DIDDetails
}
