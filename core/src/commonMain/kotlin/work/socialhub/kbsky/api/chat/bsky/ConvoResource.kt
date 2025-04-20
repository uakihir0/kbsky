package work.socialhub.kbsky.api.chat.bsky

import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoAddReactionRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoAddReactionResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoDeleteMessageForSelfRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoDeleteMessageForSelfResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoForMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoForMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetListConvosRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetListConvosResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetLogRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetLogResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetMessagesRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetMessagesResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoLeaveConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoLeaveConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoMuteConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoMuteConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoRemoveReactionRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoRemoveReactionResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoSendMessageRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoSendMessageResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUnmuteConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUnmuteConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUpdateReadRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUpdateReadResponse
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

    /**
     * chat.bsky.convo.addReaction
     */
    fun addReaction(
        request: ConvoAddReactionRequest
    ): Response<ConvoAddReactionResponse>

    /**
     * chat.bsky.convo.removeReaction
     */
    fun removeReaction(
        request: ConvoRemoveReactionRequest
    ): Response<ConvoRemoveReactionResponse>
}
