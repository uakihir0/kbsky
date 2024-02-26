package work.socialhub.kbsky.model.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.util.json.DidDocPolymorphicSerializer

/**
 * @see DIDDetails
 */
@Serializable(with = DidDocPolymorphicSerializer::class)
abstract class DidDocUnion {

    val asDIDDetails get() = this as? DIDDetails
}