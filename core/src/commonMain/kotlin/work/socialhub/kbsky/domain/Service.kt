package work.socialhub.kbsky.domain

enum class Service(
    val uri: String
) {
    BSKY_SOCIAL("https://bsky.social/"),
    BSKY_NETWORK("https://bsky.network/"),
}
