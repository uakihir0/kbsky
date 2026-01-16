package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsStarterPackViewBasic
import work.socialhub.kbsky.util.json.EmbedRecordViewPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see EmbedRecordViewRecord
 * @see EmbedRecordViewNotFound
 * @see EmbedRecordViewBlocked
 * @see EmbedRecordViewDetached
 * @see FeedDefsGeneratorView
 * @see GraphDefsListView
 * @see GraphDefsStarterPackViewBasic
 */
@Serializable(with = EmbedRecordViewPolymorphicSerializer::class)
@JsExport
abstract class EmbedRecordViewUnion {
    @SerialName("\$type")
    abstract var type: String

    val asRecord get() = this as? EmbedRecordViewRecord
    val asNotFound get() = this as? EmbedRecordViewNotFound
    val asBlocked get() = this as? EmbedRecordViewBlocked
    val asDetached get() = this as? EmbedRecordViewDetached
    val asGeneratorView get() = this as? FeedDefsGeneratorView
    val asListView get() = this as? GraphDefsListView
    val asStarterPackView get() = this as? GraphDefsStarterPackViewBasic
}
