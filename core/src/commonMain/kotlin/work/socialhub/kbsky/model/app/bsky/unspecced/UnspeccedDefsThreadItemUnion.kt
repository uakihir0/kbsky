package work.socialhub.kbsky.model.app.bsky.unspecced


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.UnspeccedDefsThreadItemPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see UnspeccedDefsThreadItemPost
 * @see UnspeccedDefsThreadItemNoUnauthenticated
 * @see UnspeccedDefsThreadItemNotFound
 * @see UnspeccedDefsThreadItemBlocked
 */
@Serializable(with = UnspeccedDefsThreadItemPolymorphicSerializer::class)
@JsExport
abstract class UnspeccedDefsThreadItemUnion {
    @SerialName("\$type")
    abstract var type: String

    val asPost get() = this as? UnspeccedDefsThreadItemPost
    val asNoUnauthenticated get() = this as? UnspeccedDefsThreadItemNoUnauthenticated
    val asNotFound get() = this as? UnspeccedDefsThreadItemNotFound
    val asBlocked get() = this as? UnspeccedDefsThreadItemBlocked
}
