package work.socialhub.kbsky.internal.app.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.BlueskyTypes.GraphBlock
import work.socialhub.kbsky.BlueskyTypes.GraphFollow
import work.socialhub.kbsky.BlueskyTypes.GraphGetBlocks
import work.socialhub.kbsky.BlueskyTypes.GraphGetFollowers
import work.socialhub.kbsky.BlueskyTypes.GraphGetFollows
import work.socialhub.kbsky.BlueskyTypes.GraphGetList
import work.socialhub.kbsky.BlueskyTypes.GraphGetLists
import work.socialhub.kbsky.BlueskyTypes.GraphGetMutes
import work.socialhub.kbsky.BlueskyTypes.GraphList
import work.socialhub.kbsky.BlueskyTypes.GraphListItem
import work.socialhub.kbsky.BlueskyTypes.GraphMuteActor
import work.socialhub.kbsky.BlueskyTypes.GraphUnmuteActor
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.*
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.com.atproto._RepoResource
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _GraphResource(
    private val uri: String
) : GraphResource {

    override fun follow(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphFollow,
                    record = request.toFollow(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun deleteFollow(
        request: GraphDeleteFollowRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphFollow,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun getFollowers(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetFollowers))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getFollows(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetFollows))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getMutes(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetMutes))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun muteActor(
        request: GraphMuteActorRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphMuteActor))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
    }

    override fun unmuteActor(
        request: GraphUnmuteActorRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphUnmuteActor))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
    }

    override fun block(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphBlock,
                    record = request.toBlock(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun deleteBlock(
        request: GraphDeleteBlockRequest
    ): Response<Unit> {

        return proceed {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphBlock,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun getBlocks(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetBlocks))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun createList(request: GraphCreateListRequest): Response<GraphCreateListResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphList,
                    record = request.toRecord(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun editList(request: GraphEditListRequest): Response<GraphEditListResponse> {

        return runBlocking {
            val listUri = request.listUri

            val repoResource = _RepoResource(uri)

            val original = repoResource.getRecord(
                RepoGetRecordRequest(
                    repo = request.did!!,
                    collection = GraphList,
                    rkey = ATUriParser.getRKey(listUri)
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
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphList,
                    rkey = ATUriParser.getRKey(listUri),
                    record = modifiedListRecord
                )
            )

            Response(GraphEditListResponse().also {
                it.uri = r.data.uri
                it.cid = r.data.cid
            }, r.json)
        }
    }

    override fun deleteList(accessJwt: String, listUri: String): Response<Unit> {

        return runBlocking {
            val did = ATUriParser.getDid(listUri)
            val rkey = ATUriParser.getRKey(listUri)

            val record = RepoDeleteRecordRequest(
                accessJwt = accessJwt,
                repo = did,
                collection = GraphList,
                rkey = rkey,
            )

            _RepoResource(uri).deleteRecord(record)
        }
    }

    override fun getList(request: GraphGetListRequest): Response<GraphGetListResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetList))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getLists(request: GraphGetListsRequest): Response<GraphGetListsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, GraphGetLists))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun addUserToList(request: GraphAddUserToListRequest): Response<GraphAddUserToListResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphListItem,
                    record = request.toListItem(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun removeUserFromList(request: GraphRemoveUserFromListRequest): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = GraphListItem,
                    rkey = request.rkey!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }
}
