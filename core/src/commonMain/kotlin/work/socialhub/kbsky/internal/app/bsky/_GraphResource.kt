package work.socialhub.kbsky.internal.app.bsky

import kotlinx.coroutines.runBlocking
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
import work.socialhub.kbsky.internal.com.atproto._RepoResource
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser.getDid
import work.socialhub.kbsky.util.ATUriParser.getRKey
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _GraphResource(
    private val config: BlueskyConfig
) : GraphResource {

    override fun follow(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphFollow,
                    record = request.toFollow(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteFollow(
        request: GraphDeleteFollowRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphFollow,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun getFollowers(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetFollowers))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getFollows(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetFollows))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getKnownFollowers(
        request: GraphGetKnownFollowersRequest
    ): Response<GraphGetKnownFollowersResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetKnownFollowers))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getMutes(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetMutes))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun muteActor(
        request: GraphMuteActorRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphMuteActor))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun unmuteActor(
        request: GraphUnmuteActorRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphUnmuteActor))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun block(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphBlock,
                    record = request.toBlock(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteBlock(
        request: GraphDeleteBlockRequest
    ): Response<Unit> {

        return proceed {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphBlock,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun getBlocks(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetBlocks))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun createList(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphList,
                    record = request.toRecord(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun editList(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse> {

        return runBlocking {
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

            Response(GraphEditListResponse().also {
                it.uri = r.data.uri
                it.cid = r.data.cid
            }, r.json)
        }
    }

    override fun deleteList(
        request: GraphDeleteListRequest
    ): Response<Unit> {

        return runBlocking {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = getDid(request.listUri),
                collection = GraphList,
                rkey = getRKey(request.listUri),
            )

            _RepoResource(config).deleteRecord(record)
        }
    }

    override fun getList(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetList))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getLists(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetLists))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun addUserToList(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphListItem,
                    record = request.toListItem(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun removeUserFromList(request: GraphRemoveUserFromListRequest): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = GraphListItem,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun getStarterPack(request: GraphGetStarterPackRequest): Response<GraphGetStarterPackResponse> {
        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, GraphGetStarterPack))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getStarterPacks(request: GraphGetStarterPacksRequest): Response<GraphGetStarterPacksResponse> {
        return proceed {
            runBlocking {
                HttpRequest()
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
    }
}
