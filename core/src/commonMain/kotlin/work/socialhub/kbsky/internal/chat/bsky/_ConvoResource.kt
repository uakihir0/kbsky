package work.socialhub.kbsky.internal.chat.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.api.chat.bsky.ConvoResource
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
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoSendMessageRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoSendMessageResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUnmuteConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUnmuteConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUpdateReadRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoUpdateReadResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _ConvoResource(
    private val config: ATProtocolConfig
) : ConvoResource {

    override fun getConvo(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetConvo,
            request.toMap(),
            request.bearerToken,
        )
    }

    override fun getConvoForMembers(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetConvoForMembers,
            request.toMap(),
            request.bearerToken,
        )
    }

    override fun getLog(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetLog,
            request.toMap(),
            request.bearerToken
        )
    }

    override fun getMessages(
        request: ConvoGetMessagesRequest
    ): Response<ConvoGetMessagesResponse> {

        return proceedGet(
            BlueskyTypes.ConvoGetMessages,
            request.toMap(),
            request.bearerToken,
        )
    }

    override fun getListConvos(
        request: ConvoGetListConvosRequest
    ): Response<ConvoGetListConvosResponse> {

        return proceedGet(
            BlueskyTypes.ConvoListConvos,
            request.toMap(),
            request.bearerToken,
        )
    }

    override fun sendMessage(
        request: ConvoSendMessageRequest
    ): Response<ConvoSendMessageResponse> {

        return proceedPost(
            BlueskyTypes.ConvoSendMessage,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    override fun updateRead(
        request: ConvoUpdateReadRequest
    ): Response<ConvoUpdateReadResponse> {

        return proceedPost(
            BlueskyTypes.ConvoUpdateRead,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    override fun muteConvo(
        request: ConvoMuteConvoRequest
    ): Response<ConvoMuteConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoMuteConvo,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    override fun unmuteConvo(
        request: ConvoUnmuteConvoRequest
    ): Response<ConvoUnmuteConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoUnmuteConvo,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    override fun deleteMessageForSelf(
        request: ConvoDeleteMessageForSelfRequest
    ): Response<ConvoDeleteMessageForSelfResponse> {

        return proceedPost(
            BlueskyTypes.ConvoDeleteMessageForSelf,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    override fun leaveConvo(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse> {

        return proceedPost(
            BlueskyTypes.ConvoLeaveConvo,
            request.toMappedJson(),
            request.bearerToken,
        )
    }

    private inline fun <reified T> proceedGet(
        id: String,
        requestMap: Map<String, Any>,
        bearerToken: String,
    ): Response<T> {
        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, id))
                    .header("Authorization", bearerToken)
                    .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                    .accept(MediaType.JSON)
                    .queries(requestMap)
                    .get()
            }
        }
    }

    private inline fun <reified T> proceedPost(
        id: String,
        requestMappedJson: String,
        bearerToken: String
    ): Response<T> {
        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, id))
                    .header("Authorization", bearerToken)
                    .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                    .accept(MediaType.JSON)
                    .json(requestMappedJson)
                    .post()
            }
        }
    }
}
