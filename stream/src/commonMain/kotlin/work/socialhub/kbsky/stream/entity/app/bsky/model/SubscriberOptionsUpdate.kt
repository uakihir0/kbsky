package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable

@Serializable
data class SubscriberOptionsUpdate(
    val type: String = "options_update",
    val payload: SubscriberOptionsPayload,
)

@Serializable
data class SubscriberOptionsPayload(
    val wantedCollections: List<String> = listOf(),
    val wantedDids: List<String> = listOf(),
    val maxMessageSizeBytes: Long? = null,
)
