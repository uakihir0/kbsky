package work.socialhub.kbsky

import work.socialhub.kbsky.api.chat.ChatConvoResource

/**
 * Representation of "chat/bsky" lexicon
 */
interface Chat : ATProtocol {
    fun convo(): ChatConvoResource
}
