package work.socialhub.kbsky.internal.chat.bsky

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.api.chat.bsky.ConvoResource
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
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class ConvoResourceImpl(
    private val config: ATProtocolConfig
) : ConvoResource {

    override suspend fun getConvo(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetConvo,
            request.toMap(),
            request.auth,
        )
    }

    override fun getConvoBlocking(request: ConvoGetConvoRequest): Response<ConvoGetConvoResponse> =
        toBlocking { getConvo(request) }

    override suspend fun getConvoForMembers(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetConvoForMembers,
            request.toMap(),
            request.auth,
        )
    }

    override fun getConvoForMembersBlocking(request: ConvoGetConvoForMembersRequest): Response<ConvoGetConvoForMembersResponse> =
        toBlocking { getConvoForMembers(request) }

    override suspend fun getLog(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetLog,
            request.toMap(),
            request.auth
        )
    }

    override fun getLogBlocking(request: ConvoGetLogRequest): Response<ConvoGetLogResponse> =
        toBlocking { getLog(request) }

    override suspend fun getMessages(
        request: ConvoGetMessagesRequest
    ): Response<ConvoGetMessagesResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetMessages,
            request.toMap(),
            request.auth,
        )
    }

    override fun getMessagesBlocking(request: ConvoGetMessagesRequest): Response<ConvoGetMessagesResponse> =
        toBlocking { getMessages(request) }

    override suspend fun getListConvos(
        request: ConvoGetListConvosRequest
    ): Response<ConvoGetListConvosResponse> {

        return proceedGet(
            BlueskyTypes.ConvoListConvos,
            request.toMap(),
            request.auth,
        )
    }

    override fun getListConvosBlocking(request: ConvoGetListConvosRequest): Response<ConvoGetListConvosResponse> =
        toBlocking { getListConvos(request) }

    override suspend fun sendMessage(
        request: ConvoSendMessageRequest
    ): Response<ConvoSendMessageResponse> {

        return proceedPost(
            BlueskyTypes.ConvoSendMessage,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun sendMessageBlocking(request: ConvoSendMessageRequest): Response<ConvoSendMessageResponse> =
        toBlocking { sendMessage(request) }

    override suspend fun updateRead(
        request: ConvoUpdateReadRequest
    ): Response<ConvoUpdateReadResponse> {

        return proceedPost(
            BlueskyTypes.ConvoUpdateRead,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun updateReadBlocking(request: ConvoUpdateReadRequest): Response<ConvoUpdateReadResponse> =
        toBlocking { updateRead(request) }

    override suspend fun muteConvo(
        request: ConvoMuteConvoRequest
    ): Response<ConvoMuteConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoMuteConvo,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun muteConvoBlocking(request: ConvoMuteConvoRequest): Response<ConvoMuteConvoResponse> =
        toBlocking { muteConvo(request) }

    override suspend fun unmuteConvo(
        request: ConvoUnmuteConvoRequest
    ): Response<ConvoUnmuteConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoUnmuteConvo,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun unmuteConvoBlocking(request: ConvoUnmuteConvoRequest): Response<ConvoUnmuteConvoResponse> =
        toBlocking { unmuteConvo(request) }

    override suspend fun deleteMessageForSelf(
        request: ConvoDeleteMessageForSelfRequest
    ): Response<ConvoDeleteMessageForSelfResponse> {

        return proceedPost(
            BlueskyTypes.ConvoDeleteMessageForSelf,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun deleteMessageForSelfBlocking(request: ConvoDeleteMessageForSelfRequest): Response<ConvoDeleteMessageForSelfResponse> =
        toBlocking { deleteMessageForSelf(request) }

    override suspend fun leaveConvo(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoLeaveConvo,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun leaveConvoBlocking(request: ConvoLeaveConvoRequest): Response<ConvoLeaveConvoResponse> =
        toBlocking { leaveConvo(request) }

    override suspend fun addReaction(
        request: ConvoAddReactionRequest
    ): Response<ConvoAddReactionResponse> {

        return proceedPost(
            BlueskyTypes.ConvoAddReaction,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun addReactionBlocking(request: ConvoAddReactionRequest): Response<ConvoAddReactionResponse> =
        toBlocking { addReaction(request) }

    override suspend fun removeReaction(
        request: ConvoRemoveReactionRequest
    ): Response<ConvoRemoveReactionResponse> {

        return proceedPost(
            BlueskyTypes.ConvoRemoveReaction,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun removeReactionBlocking(request: ConvoRemoveReactionRequest): Response<ConvoRemoveReactionResponse> =
        toBlocking { removeReaction(request) }

    private suspend inline fun <reified T> proceedGet(
        id: String,
        queries: Map<String, Any>,
        auth: AuthProvider,
    ): Response<T> {
        return proceed {
            httpRequest(config)
                .url(xrpc(config, id))
                .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                .accept(MediaType.JSON)
                .queries(queries)
                .getWithAuth(auth)
        }
    }

    private suspend inline fun <reified T> proceedPost(
        id: String,
        requestJson: String,
        auth: AuthProvider,
    ): Response<T> {
        return proceed {
            httpRequest(config)
                .url(xrpc(config, id))
                .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                .accept(MediaType.JSON)
                .json(requestJson)
                .postWithAuth(auth)
        }
    }
}
