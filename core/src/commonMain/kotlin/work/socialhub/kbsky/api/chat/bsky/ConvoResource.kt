package work.socialhub.kbsky.api.chat.bsky

import work.socialhub.kbsky.api.entity.chat.bsky.convo.*
import work.socialhub.kbsky.api.entity.share.Response

/**
 * Chat/Bluesky/Convo
 *
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/chat/bsky/convo)
 */
interface ConvoResource {

    /**
     * chat.bsky.convo.getConvo
     */
    fun getConvo(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse>

    /**
     * chat.bsky.convo.getConvoForMembers
     */
    fun getConvoForMembers(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse>

    /**
     * chat.bsky.convo.getLog
     */
    fun getLog(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse>

    /**
     * chat.bsky.convo.getMessages
     */
    fun getMessages(
        request: ConvoGetMessagesRequest
    ): Response<ConvoGetMessagesResponse>

    /**
     * chat.bsky.convo.listConvos
     */
    fun getListConvos(
        request: ConvoGetListConvosRequest
    ): Response<ConvoGetListConvosResponse>

    /**
     * chat.bsky.convo.sendMessage
     */
    fun sendMessage(
        request: ConvoSendMessageRequest
    ): Response<ConvoSendMessageResponse>

    /**
     * chat.bsky.convo.updateRead
     */
    fun updateRead(
        request: ConvoUpdateReadRequest
    ): Response<ConvoUpdateReadResponse>

    /**
     * chat.bsky.convo.muteConvo
     */
    fun muteConvo(
        request: ConvoMuteConvoRequest
    ): Response<ConvoMuteConvoResponse>

    /**
     * chat.bsky.convo.unmuteConvo
     */
    fun unmuteConvo(
        request: ConvoUnmuteConvoRequest
    ): Response<ConvoUnmuteConvoResponse>

    /**
     * chat.bsky.convo.deleteMessageForSelf
     */
    fun deleteMessageForSelf(
        request: ConvoDeleteMessageForSelfRequest
    ): Response<ConvoDeleteMessageForSelfResponse>

    /**
     * chat.bsky.convo.leaveConvo
     */
    fun leaveConvo(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse>

}
