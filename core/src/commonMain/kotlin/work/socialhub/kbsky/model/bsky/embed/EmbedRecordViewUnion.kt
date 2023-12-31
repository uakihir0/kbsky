package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.util.json.EmbedRecordViewPolymorphicSerializer

/**
 * @see EmbedRecordViewRecord
 * @see EmbedRecordViewNotFound
 * @see EmbedRecordViewBlocked
 * @see FeedDefsGeneratorView
 */
@Serializable(with = EmbedRecordViewPolymorphicSerializer::class)
abstract class EmbedRecordViewUnion {
    @SerialName("\$type")
    abstract var type: String

    fun record() = this as? EmbedRecordViewRecord
    fun notFound() = this as? EmbedRecordViewNotFound
    fun blocked() = this as? EmbedRecordViewBlocked
    fun generatorView() = this as? FeedDefsGeneratorView
}
