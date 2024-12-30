package work.socialhub.kbsky.domain

enum class Service(
    val uri: String
) {
    //
    BSKY_SOCIAL("https://bsky.social"),
    BSKY_NETWORK("https://bsky.network"),
    BSKY_APP_PUBLIC("https://public.api.bsky.app"),

    OYSTER_US_EAST("https://oyster.us-east.host.bsky.network"),
}
