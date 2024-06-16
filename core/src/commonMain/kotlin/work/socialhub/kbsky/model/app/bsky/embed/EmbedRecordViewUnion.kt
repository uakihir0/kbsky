package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
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

    val asRecord get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewRecord
    val asNotFound get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewNotFound
    val asBlocked get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewBlocked
    val asGeneratorView get() = this as? work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
    val asListView get() = this as? work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
}
