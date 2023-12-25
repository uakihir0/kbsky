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
                    .url(xrpc(uri, ActorSearchActors))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
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
                    .url(xrpc(uri, ActorGetProfile))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
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
                    .url(xrpc(uri, ActorGetProfiles))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .also {
                        request.actors?.forEach { actor ->
                            it.query("actors", actor)
                        }
                    }
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
                    .url(xrpc(uri, ActorGetPreferences))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }
}
