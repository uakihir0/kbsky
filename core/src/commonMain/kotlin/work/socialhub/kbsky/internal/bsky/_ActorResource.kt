package work.socialhub.kbsky.internal.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.BlueskyTypes.ActorGetPreferences
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfile
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfiles
import work.socialhub.kbsky.BlueskyTypes.ActorSearchActors
import work.socialhub.kbsky.api.bsky.ActorResource
import work.socialhub.kbsky.api.entity.bsky.actor.*
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _ActorResource(
    private val uri: String
) : ActorResource {

    override fun searchActors(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ActorSearchActors)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getProfile(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ActorGetProfile)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getProfiles(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ActorGetProfiles)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    // TODO: implement
                    // request.getActors().forEach(java.util.function.Consumer<String> { actor: String? -> builder.param("actors", actor) })
                    .get()
            }
        }
    }

    override fun getPreferences(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ActorGetPreferences)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .queries(request.toMap())
                    .get()
            }
        }
    }
}
