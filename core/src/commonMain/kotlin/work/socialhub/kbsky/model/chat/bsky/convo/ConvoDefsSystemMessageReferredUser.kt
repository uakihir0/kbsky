package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageReferredUser
 *
 * Lightweight user reference (did only). Profiles are resolved via relatedProfiles in the log.
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageReferredUser(
    val did: String,
)
