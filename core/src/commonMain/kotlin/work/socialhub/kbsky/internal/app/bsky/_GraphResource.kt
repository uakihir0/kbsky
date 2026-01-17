package work.socialhub.kbsky.internal.app.bsky

import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.GraphBlock
import work.socialhub.kbsky.BlueskyTypes.GraphFollow
import work.socialhub.kbsky.BlueskyTypes.GraphGetBlocks
import work.socialhub.kbsky.BlueskyTypes.GraphGetFollowers
import work.socialhub.kbsky.BlueskyTypes.GraphGetFollows
import work.socialhub.kbsky.BlueskyTypes.GraphGetKnownFollowers
import work.socialhub.kbsky.BlueskyTypes.GraphGetList
import work.socialhub.kbsky.BlueskyTypes.GraphGetLists
import work.socialhub.kbsky.BlueskyTypes.GraphGetMutes
import work.socialhub.kbsky.BlueskyTypes.GraphGetStarterPack
import work.socialhub.kbsky.BlueskyTypes.GraphGetStarterPacks
import work.socialhub.kbsky.BlueskyTypes.GraphList
import work.socialhub.kbsky.BlueskyTypes.GraphListItem
import work.socialhub.kbsky.BlueskyTypes.GraphMuteActor
import work.socialhub.kbsky.BlueskyTypes.GraphUnmuteActor
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphAddUserToListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphAddUserToListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphCreateListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphCreateListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphEditListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphEditListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetBlocksRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetBlocksResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowersRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowersResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetKnownFollowersRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetKnownFollowersResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListsRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListsResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetMutesRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetMutesResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPackRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPackResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphMuteActorRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphRemoveUserFromListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphUnmuteActorRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import work.socialhub.kbsky.internal.com.atproto._RepoResource
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser.getDid
import work.socialhub.kbsky.util.ATUriParser.getRKey
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _GraphResource(
    private val config: BlueskyConfig
) : GraphResource {

    override suspend fun follow(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphFollow,
                record = request.toFollow(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun followBlocking(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse> = toBlocking { follow(request) }

    override suspend fun deleteFollow(
        request: GraphDeleteFollowRequest
    ): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphFollow,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deleteFollowBlocking(
        request: GraphDeleteFollowRequest
    ): ResponseUnit = toBlocking { deleteFollow(request) }

    override suspend fun getFollowers(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetFollowers))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getFollowersBlocking(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse> = toBlocking { getFollowers(request) }

    override suspend fun getFollows(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetFollows))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getFollowsBlocking(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse> = toBlocking { getFollows(request) }

    override suspend fun getKnownFollowers(
        request: GraphGetKnownFollowersRequest
    ): Response<GraphGetKnownFollowersResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetKnownFollowers))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getKnownFollowersBlocking(
        request: GraphGetKnownFollowersRequest
    ): Response<GraphGetKnownFollowersResponse> = toBlocking { getKnownFollowers(request) }

    override suspend fun getMutes(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetMutes))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getMutesBlocking(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse> = toBlocking { getMutes(request) }

    override suspend fun muteActor(
        request: GraphMuteActorRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, GraphMuteActor))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun muteActorBlocking(
        request: GraphMuteActorRequest
    ): ResponseUnit = toBlocking { muteActor(request) }

    override suspend fun unmuteActor(
        request: GraphUnmuteActorRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, GraphUnmuteActor))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun unmuteActorBlocking(
        request: GraphUnmuteActorRequest
    ): ResponseUnit = toBlocking { unmuteActor(request) }

    override suspend fun block(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphBlock,
                record = request.toBlock(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun blockBlocking(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse> = toBlocking { block(request) }

    override suspend fun deleteBlock(
        request: GraphDeleteBlockRequest
    ): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphBlock,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deleteBlockBlocking(
        request: GraphDeleteBlockRequest
    ): ResponseUnit = toBlocking { deleteBlock(request) }

    override suspend fun getBlocks(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetBlocks))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getBlocksBlocking(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse> = toBlocking { getBlocks(request) }

    override suspend fun createList(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphList,
                record = request.toRecord(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun createListBlocking(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse> = toBlocking { createList(request) }

    override suspend fun editList(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse> {

        val listUri = request.listUri

        val repoResource = _RepoResource(config)
        val original = repoResource.getRecord(
            RepoGetRecordRequest(
                repo = request.auth.did,
                collection = GraphList,
                rkey = getRKey(listUri)
            )
        )

        val originalListRecord = original.data.value.asGraphList
            ?: throw IllegalStateException("response data is not GraphList(type=${original.data.value.type}")

        val modifiedListRecord = originalListRecord.copy(
            // keep purpose, createdAt
            name = request.name,
            description = request.description,
            descriptionFacets = request.descriptionFacets,
            avatar = request.avatar,
            labels = request.labels
        )

        val r = repoResource.putRecord(
            RepoPutRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphList,
                rkey = getRKey(listUri),
                record = modifiedListRecord,
            )
        )

        return Response(GraphEditListResponse().also {
            it.uri = r.data.uri
            it.cid = r.data.cid
        }, r.json)
    }

    override fun editListBlocking(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse> = toBlocking { editList(request) }

    override suspend fun deleteList(
        request: GraphDeleteListRequest
    ): ResponseUnit {

        val record = RepoDeleteRecordRequest(
            auth = request.auth,
            repo = getDid(request.listUri),
            collection = GraphList,
            rkey = getRKey(request.listUri),
        )

        return _RepoResource(config).deleteRecord(record)
    }

    override fun deleteListBlocking(
        request: GraphDeleteListRequest
    ): ResponseUnit = toBlocking { deleteList(request) }

    override suspend fun getList(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetList))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getListBlocking(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse> = toBlocking { getList(request) }

    override suspend fun getLists(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetLists))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getListsBlocking(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse> = toBlocking { getLists(request) }

    override suspend fun addUserToList(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphListItem,
                record = request.toListItem(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun addUserToListBlocking(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse> = toBlocking { addUserToList(request) }

    override suspend fun removeUserFromList(request: GraphRemoveUserFromListRequest): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = GraphListItem,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun removeUserFromListBlocking(request: GraphRemoveUserFromListRequest): ResponseUnit =
        toBlocking { removeUserFromList(request) }

    override suspend fun getStarterPack(request: GraphGetStarterPackRequest): Response<GraphGetStarterPackResponse> {
        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetStarterPack))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getStarterPackBlocking(request: GraphGetStarterPackRequest): Response<GraphGetStarterPackResponse> =
        toBlocking { getStarterPack(request) }

    override suspend fun getStarterPacks(request: GraphGetStarterPacksRequest): Response<GraphGetStarterPacksResponse> {
        return proceed {
            httpRequest(config)
                .url(xrpc(config, GraphGetStarterPacks))
                .accept(MediaType.JSON)
                .also {
                    request.uris?.forEach { uri ->
                        it.query("uris", uri)
                    }
                }
                .getWithAuth(request.auth)
        }
    }

    override fun getStarterPacksBlocking(request: GraphGetStarterPacksRequest): Response<GraphGetStarterPacksResponse> =
        toBlocking { getStarterPacks(request) }
}
