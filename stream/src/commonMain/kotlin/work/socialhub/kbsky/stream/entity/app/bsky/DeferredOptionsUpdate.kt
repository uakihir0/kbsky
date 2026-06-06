package work.socialhub.kbsky.stream.entity.app.bsky

data class DeferredOptionsUpdate(
    val wantedCollections: List<String> = listOf(),
    val wantedDids: List<String> = listOf(),
    val maxMessageSizeBytes: Long? = null,
)
