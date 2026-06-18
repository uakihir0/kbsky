package work.socialhub.kbsky.internal.chat.bsky

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.api.chat.bsky.GroupResource
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupAddMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupAddMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupApproveJoinRequestRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupApproveJoinRequestResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateGroupRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateGroupResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupDisableJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupDisableJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditGroupRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditGroupResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEnableJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEnableJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupGetJoinLinkPreviewsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupGetJoinLinkPreviewsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListJoinRequestsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListJoinRequestsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListMutualGroupsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListMutualGroupsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRejectJoinRequestRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRemoveMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRemoveMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRequestJoinRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRequestJoinResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupUpdateJoinRequestsReadRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupWithdrawJoinRequestRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class GroupResourceImpl(
    private val config: ATProtocolConfig
) : GroupResource {

    override suspend fun createGroup(
        request: GroupCreateGroupRequest
    ): Response<GroupCreateGroupResponse> {

        return proceedPost(
            BlueskyTypes.GroupCreateGroup,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun createGroupBlocking(request: GroupCreateGroupRequest): Response<GroupCreateGroupResponse> =
        toBlocking { createGroup(request) }

    override suspend fun addMembers(
        request: GroupAddMembersRequest
    ): Response<GroupAddMembersResponse> {

        return proceedPost(
            BlueskyTypes.GroupAddMembers,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun addMembersBlocking(request: GroupAddMembersRequest): Response<GroupAddMembersResponse> =
        toBlocking { addMembers(request) }

    override suspend fun removeMembers(
        request: GroupRemoveMembersRequest
    ): Response<GroupRemoveMembersResponse> {

        return proceedPost(
            BlueskyTypes.GroupRemoveMembers,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun removeMembersBlocking(request: GroupRemoveMembersRequest): Response<GroupRemoveMembersResponse> =
        toBlocking { removeMembers(request) }

    override suspend fun editGroup(
        request: GroupEditGroupRequest
    ): Response<GroupEditGroupResponse> {

        return proceedPost(
            BlueskyTypes.GroupEditGroup,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun editGroupBlocking(request: GroupEditGroupRequest): Response<GroupEditGroupResponse> =
        toBlocking { editGroup(request) }

    override suspend fun requestJoin(
        request: GroupRequestJoinRequest
    ): Response<GroupRequestJoinResponse> {

        return proceedPost(
            BlueskyTypes.GroupRequestJoin,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun requestJoinBlocking(request: GroupRequestJoinRequest): Response<GroupRequestJoinResponse> =
        toBlocking { requestJoin(request) }

    override suspend fun withdrawJoinRequest(
        request: GroupWithdrawJoinRequestRequest
    ): ResponseUnit {

        return proceedPostUnit(
            BlueskyTypes.GroupWithdrawJoinRequest,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun withdrawJoinRequestBlocking(request: GroupWithdrawJoinRequestRequest): ResponseUnit =
        toBlocking { withdrawJoinRequest(request) }

    override suspend fun listJoinRequests(
        request: GroupListJoinRequestsRequest
    ): Response<GroupListJoinRequestsResponse> {

        return proceedGet(
            BlueskyTypes.GroupListJoinRequests,
            request.toMap(),
            request.auth,
        )
    }

    override fun listJoinRequestsBlocking(request: GroupListJoinRequestsRequest): Response<GroupListJoinRequestsResponse> =
        toBlocking { listJoinRequests(request) }

    override suspend fun approveJoinRequest(
        request: GroupApproveJoinRequestRequest
    ): Response<GroupApproveJoinRequestResponse> {

        return proceedPost(
            BlueskyTypes.GroupApproveJoinRequest,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun approveJoinRequestBlocking(request: GroupApproveJoinRequestRequest): Response<GroupApproveJoinRequestResponse> =
        toBlocking { approveJoinRequest(request) }

    override suspend fun rejectJoinRequest(
        request: GroupRejectJoinRequestRequest
    ): ResponseUnit {

        return proceedPostUnit(
            BlueskyTypes.GroupRejectJoinRequest,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun rejectJoinRequestBlocking(request: GroupRejectJoinRequestRequest): ResponseUnit =
        toBlocking { rejectJoinRequest(request) }

    override suspend fun updateJoinRequestsRead(
        request: GroupUpdateJoinRequestsReadRequest
    ): ResponseUnit {

        return proceedPostUnit(
            BlueskyTypes.GroupUpdateJoinRequestsRead,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun updateJoinRequestsReadBlocking(request: GroupUpdateJoinRequestsReadRequest): ResponseUnit =
        toBlocking { updateJoinRequestsRead(request) }

    override suspend fun createJoinLink(
        request: GroupCreateJoinLinkRequest
    ): Response<GroupCreateJoinLinkResponse> {

        return proceedPost(
            BlueskyTypes.GroupCreateJoinLink,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun createJoinLinkBlocking(request: GroupCreateJoinLinkRequest): Response<GroupCreateJoinLinkResponse> =
        toBlocking { createJoinLink(request) }

    override suspend fun editJoinLink(
        request: GroupEditJoinLinkRequest
    ): Response<GroupEditJoinLinkResponse> {

        return proceedPost(
            BlueskyTypes.GroupEditJoinLink,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun editJoinLinkBlocking(request: GroupEditJoinLinkRequest): Response<GroupEditJoinLinkResponse> =
        toBlocking { editJoinLink(request) }

    override suspend fun enableJoinLink(
        request: GroupEnableJoinLinkRequest
    ): Response<GroupEnableJoinLinkResponse> {

        return proceedPost(
            BlueskyTypes.GroupEnableJoinLink,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun enableJoinLinkBlocking(request: GroupEnableJoinLinkRequest): Response<GroupEnableJoinLinkResponse> =
        toBlocking { enableJoinLink(request) }

    override suspend fun disableJoinLink(
        request: GroupDisableJoinLinkRequest
    ): Response<GroupDisableJoinLinkResponse> {

        return proceedPost(
            BlueskyTypes.GroupDisableJoinLink,
            request.toMappedJson(),
            request.auth,
        )
    }

    override fun disableJoinLinkBlocking(request: GroupDisableJoinLinkRequest): Response<GroupDisableJoinLinkResponse> =
        toBlocking { disableJoinLink(request) }

    override suspend fun getJoinLinkPreviews(
        request: GroupGetJoinLinkPreviewsRequest
    ): Response<GroupGetJoinLinkPreviewsResponse> {

        // `codes` is an array parameter and must be expanded as codes=v1&codes=v2.
        // khttpclient's queries(Map) calls toString() on List values, producing "[v1,v2]",
        // so we take a dedicated path that calls query() for each element.
        return proceed {
            val req = httpRequest(config)
                .url(xrpc(config, BlueskyTypes.GroupGetJoinLinkPreviews))
                .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                .accept(MediaType.JSON)
            request.codes.forEach { req.query("codes", it) }
            req.getWithAuth(request.auth)
        }
    }

    override fun getJoinLinkPreviewsBlocking(request: GroupGetJoinLinkPreviewsRequest): Response<GroupGetJoinLinkPreviewsResponse> =
        toBlocking { getJoinLinkPreviews(request) }

    override suspend fun listMutualGroups(
        request: GroupListMutualGroupsRequest
    ): Response<GroupListMutualGroupsResponse> {

        return proceedGet(
            BlueskyTypes.GroupListMutualGroups,
            request.toMap(),
            request.auth,
        )
    }

    override fun listMutualGroupsBlocking(request: GroupListMutualGroupsRequest): Response<GroupListMutualGroupsResponse> =
        toBlocking { listMutualGroups(request) }

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

    private suspend fun proceedPostUnit(
        id: String,
        requestJson: String,
        auth: AuthProvider,
    ): ResponseUnit {
        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, id))
                .header("Atproto-Proxy", "did:web:api.bsky.chat#bsky_chat")
                .accept(MediaType.JSON)
                .json(requestJson)
                .postWithAuth(auth)
        }
    }
}
