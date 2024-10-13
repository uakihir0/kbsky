package work.socialhub.kbsky.auth.domain

enum class OAuthScopes(
    val value: String
) {
    ATProto("atproto"),
    TransitionGeneric("transition:generic"),
    TransitionChatBsky("transition:chat.bsky"),
}