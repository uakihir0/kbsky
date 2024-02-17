package work.socialhub.kbsky.internal.bsky

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
import work.socialhub.kbsky.BlueskyTypes.GraphMuteActor
import work.socialhub.kbsky.BlueskyTypes.GraphUnmuteActor
import work.socialhub.kbsky.api.bsky.GraphResource
import work.socialhub.kbsky.api.entity.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.bsky.graph.*
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
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
}
