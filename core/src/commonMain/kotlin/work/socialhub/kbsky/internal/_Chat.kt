package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Chat
import work.socialhub.kbsky.internal.chat._ChatConvoResource

class _Chat(private val uri: String) : _ATProtocol(uri), Chat {

    /**
     * {@inheritDoc}
     */
    override fun convo() = _ChatConvoResource(uri)

}
