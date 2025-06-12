package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordResponse

@Serializable
data class GraphEditListResponse(
    val dummy: Unit = Unit,
) : RepoPutRecordResponse()
