package work.socialhub.kbsky.api.chat

import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoDeleteMessageForSelfRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoDeleteMessageForSelfResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetConvoForMembersRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetConvoForMembersResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetConvoRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetConvoResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetListConvosRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetListConvosResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetLogRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetLogResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetMessagesRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoGetMessagesResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoLeaveConvoRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoLeaveConvoResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoMuteConvoRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoMuteConvoResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoSendMessageRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoSendMessageResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoUnmuteConvoRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoUnmuteConvoResponse
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoUpdateReadRequest
import work.socialhub.kbsky.api.entity.chat.convo.ChatConvoUpdateReadResponse
import work.socialhub.kbsky.api.entity.share.Response

/**
 * Chat/Bluesky/Convo
 *
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/chat/bsky/convo)
 */
interface ChatConvoResource {

    /**
     * chat.bsky.convo.getConvo
     */
    fun getConvo(
        request: ChatConvoGetConvoRequest
    ): Response<ChatConvoGetConvoResponse>

    /**
     * chat.bsky.convo.getConvoForMembers
     */
    fun getConvoForMembers(
        request: ChatConvoGetConvoForMembersRequest
    ): Response<ChatConvoGetConvoForMembersResponse>

    /**
     * chat.bsky.convo.getLog
     */
    fun getLog(
        request: ChatConvoGetLogRequest
    ): Response<ChatConvoGetLogResponse>

    /**
     * chat.bsky.convo.getMessages
     */
    fun getMessages(
        request: ChatConvoGetMessagesRequest
    ): Response<ChatConvoGetMessagesResponse>

    /**
     * chat.bsky.convo.listConvos
     */
    fun getListConvos(
        request: ChatConvoGetListConvosRequest
    ): Response<ChatConvoGetListConvosResponse>

    /**
     * chat.bsky.convo.sendMessage
     */
    fun sendMessage(
        request: ChatConvoSendMessageRequest
    ): Response<ChatConvoSendMessageResponse>

    /**
     * chat.bsky.convo.updateRead
     */
    fun updateRead(
        request: ChatConvoUpdateReadRequest
    ): Response<ChatConvoUpdateReadResponse>

    /**
     * chat.bsky.convo.muteConvo
     */
    fun muteConvo(
        request: ChatConvoMuteConvoRequest
    ): Response<ChatConvoMuteConvoResponse>

    /**
     * chat.bsky.convo.unmuteConvo
     */
    fun unmuteConvo(
        request: ChatConvoUnmuteConvoRequest
    ): Response<ChatConvoUnmuteConvoResponse>

    /**
     * chat.bsky.convo.deleteMessageForSelf
     */
    fun deleteMessageForSelf(
        request: ChatConvoDeleteMessageForSelfRequest
    ): Response<ChatConvoDeleteMessageForSelfResponse>

    /**
     * chat.bsky.convo.leaveConvo
     */
    fun leaveConvo(
        request: ChatConvoLeaveConvoRequest
    ): Response<ChatConvoLeaveConvoResponse>

}
