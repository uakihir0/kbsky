package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.model.bsky.graph.GraphDefsListView
import work.socialhub.kbsky.util.json.EmbedRecordViewPolymorphicSerializer

/**
 * @see EmbedRecordViewRecord
 * @see EmbedRecordViewNotFound
 * @see EmbedRecordViewBlocked
 * @see FeedDefsGeneratorView
 * @see GraphDefsListView
 */
@Serializable(with = EmbedRecordViewPolymorphicSerializer::class)
abstract class EmbedRecordViewUnion {
    @SerialName("\$type")
    abstract var type: String

    val asRecord get() = this as? EmbedRecordViewRecord
    val asNotFound get() = this as? EmbedRecordViewNotFound
    val asBlocked get() = this as? EmbedRecordViewBlocked
    val asGeneratorView get() = this as? FeedDefsGeneratorView
    val asListView get() = this as? GraphDefsListView
}
