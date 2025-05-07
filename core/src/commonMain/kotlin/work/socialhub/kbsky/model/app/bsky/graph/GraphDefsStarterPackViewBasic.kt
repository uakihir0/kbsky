package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class GraphDefsStarterPackViewBasic(
    override var type: String = TYPE,
    val uri: String,
    val cid: String,
    val record: RecordUnion,
    val creator: ActorDefsProfileViewBasic,
    val listItemCount: Int? = null,
    val joinedWeekCount: Int? = null,
    val joinedAllTimeCount: Int? = null,
    val labels: List<LabelDefsLabel>? = null,
    val indexedAt: String
) : EmbedRecordViewUnion() {
    companion object {
        const val TYPE = "app.bsky.graph.defs#starterPackViewBasic"
    }
}