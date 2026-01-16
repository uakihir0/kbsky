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
import kotlin.js.JsExport

/**
 * Chat/Bluesky/Convo
 *
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/chat/bsky/convo)
 */
@JsExport
interface ConvoResource {

    /**
     * chat.bsky.convo.getConvo
     */
    suspend fun getConvo(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse>

    @JsExport.Ignore
    fun getConvoBlocking(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse>

    /**
     * chat.bsky.convo.getConvoForMembers
     */
    suspend fun getConvoForMembers(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse>

    @JsExport.Ignore
    fun getConvoForMembersBlocking(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse>

    /**
     * chat.bsky.convo.getLog
     */
    suspend fun getLog(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse>

    @JsExport.Ignore
    fun getLogBlocking(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse>

    /**
     * chat.bsky.convo.getMessages
     */
    suspend fun getMessages(
        request: ConvoGetMessagesRequest
    ): Response<ConvoGetMessagesResponse>

    @JsExport.Ignore
    fun getMessagesBlocking(
        request: ConvoGetMessagesRequest
    ): Response<ConvoGetMessagesResponse>

    /**
     * chat.bsky.convo.listConvos
     */
    suspend fun getListConvos(
        request: ConvoGetListConvosRequest
    ): Response<ConvoGetListConvosResponse>

    @JsExport.Ignore
    fun getListConvosBlocking(
        request: ConvoGetListConvosRequest
    ): Response<ConvoGetListConvosResponse>

    /**
     * chat.bsky.convo.sendMessage
     */
    suspend fun sendMessage(
        request: ConvoSendMessageRequest
    ): Response<ConvoSendMessageResponse>

    @JsExport.Ignore
    fun sendMessageBlocking(
        request: ConvoSendMessageRequest
    ): Response<ConvoSendMessageResponse>

    /**
     * chat.bsky.convo.updateRead
     */
    suspend fun updateRead(
        request: ConvoUpdateReadRequest
    ): Response<ConvoUpdateReadResponse>

    @JsExport.Ignore
    fun updateReadBlocking(
        request: ConvoUpdateReadRequest
    ): Response<ConvoUpdateReadResponse>

    /**
     * chat.bsky.convo.muteConvo
     */
    suspend fun muteConvo(
        request: ConvoMuteConvoRequest
    ): Response<ConvoMuteConvoResponse>

    @JsExport.Ignore
    fun muteConvoBlocking(
        request: ConvoMuteConvoRequest
    ): Response<ConvoMuteConvoResponse>

    /**
     * chat.bsky.convo.unmuteConvo
     */
    suspend fun unmuteConvo(
        request: ConvoUnmuteConvoRequest
    ): Response<ConvoUnmuteConvoResponse>

    @JsExport.Ignore
    fun unmuteConvoBlocking(
        request: ConvoUnmuteConvoRequest
    ): Response<ConvoUnmuteConvoResponse>

    /**
     * chat.bsky.convo.deleteMessageForSelf
     */
    suspend fun deleteMessageForSelf(
        request: ConvoDeleteMessageForSelfRequest
    ): Response<ConvoDeleteMessageForSelfResponse>

    @JsExport.Ignore
    fun deleteMessageForSelfBlocking(
        request: ConvoDeleteMessageForSelfRequest
    ): Response<ConvoDeleteMessageForSelfResponse>

    /**
     * chat.bsky.convo.leaveConvo
     */
    suspend fun leaveConvo(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse>

    @JsExport.Ignore
    fun leaveConvoBlocking(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse>

    /**
     * chat.bsky.convo.addReaction
     */
    suspend fun addReaction(
        request: ConvoAddReactionRequest
    ): Response<ConvoAddReactionResponse>

    @JsExport.Ignore
    fun addReactionBlocking(
        request: ConvoAddReactionRequest
    ): Response<ConvoAddReactionResponse>

    /**
     * chat.bsky.convo.removeReaction
     */
    suspend fun removeReaction(
        request: ConvoRemoveReactionRequest
    ): Response<ConvoRemoveReactionResponse>

    @JsExport.Ignore
    fun removeReactionBlocking(
        request: ConvoRemoveReactionRequest
    ): Response<ConvoRemoveReactionResponse>
}
