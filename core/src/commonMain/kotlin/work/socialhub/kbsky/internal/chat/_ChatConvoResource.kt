package work.socialhub.kbsky.internal.chat

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ChatTypes
import work.socialhub.kbsky.api.chat.ChatConvoResource
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
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest


class _ChatConvoResource(
    private val uri: String
) : ChatConvoResource {

    override fun getConvo(
        request: ChatConvoGetConvoRequest
    ): Response<ChatConvoGetConvoResponse> {

        return proceedGet(ChatTypes.GetConvo, request.toMap(), request.bearerToken)
    }

    override fun getConvoForMembers(
        request: ChatConvoGetConvoForMembersRequest
    ): Response<ChatConvoGetConvoForMembersResponse> {

        return proceedGet(ChatTypes.GetConvoForMembers, request.toMap(), request.bearerToken)
    }

    override fun getLog(request: ChatConvoGetLogRequest): Response<ChatConvoGetLogResponse> {

        return proceedGet(ChatTypes.GetLog, request.toMap(), request.bearerToken)
    }

    override fun getMessages(
        request: ChatConvoGetMessagesRequest
    ): Response<ChatConvoGetMessagesResponse> {

        return proceedGet(ChatTypes.GetMessages, request.toMap(), request.bearerToken)
    }

    override fun getListConvos(
        request: ChatConvoGetListConvosRequest
    ): Response<ChatConvoGetListConvosResponse> {

        return proceedGet(ChatTypes.ListConvos, request.toMap(), request.bearerToken)
    }

    override fun sendMessage(
        request: ChatConvoSendMessageRequest
    ): Response<ChatConvoSendMessageResponse> {

        return proceedPost(ChatTypes.SendMessage, request.toMappedJson(), request.bearerToken)
    }

    override fun updateRead(
        request: ChatConvoUpdateReadRequest
    ): Response<ChatConvoUpdateReadResponse> {

        return proceedPost(ChatTypes.UpdateRead, request.toMappedJson(), request.bearerToken)
    }

    override fun muteConvo(
        request: ChatConvoMuteConvoRequest
    ): Response<ChatConvoMuteConvoResponse> {

        return proceedPost(ChatTypes.MuteConvo, request.toMappedJson(), request.bearerToken)
    }

    override fun unmuteConvo(
        request: ChatConvoUnmuteConvoRequest
    ): Response<ChatConvoUnmuteConvoResponse> {

        return proceedPost(ChatTypes.UnmuteConvo, request.toMappedJson(), request.bearerToken)
    }

    override fun deleteMessageForSelf(
        request: ChatConvoDeleteMessageForSelfRequest
    ): Response<ChatConvoDeleteMessageForSelfResponse> {

        return proceedPost(ChatTypes.DeleteMessageForSelf, request.toMappedJson(), request.bearerToken)
    }

    override fun leaveConvo(request: ChatConvoLeaveConvoRequest): Response<ChatConvoLeaveConvoResponse> {

        return proceedPost(ChatTypes.LeaveConvo, request.toMappedJson(), request.bearerToken)
    }

    private inline fun <reified T> proceedGet(id: String, requestMap: Map<String, Any>, bearerToken: String): Response<T> {
        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, id))
                    .header("Authorization", bearerToken)
                    .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                    .accept(MediaType.JSON)
                    .queries(requestMap)
                    .get()
            }
        }
    }

    private inline fun <reified T> proceedPost(id: String, requestMappedJson: String, bearerToken: String): Response<T> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, id))
                    .header("Authorization", bearerToken)
                    .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                    .accept(MediaType.JSON)
                    .json(requestMappedJson)
                    .post()
            }
        }
    }
}
