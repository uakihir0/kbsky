package work.socialhub.kbsky.internal.app.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.BlueskyTypes.ActorGetPreferences
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfile
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfiles
import work.socialhub.kbsky.BlueskyTypes.ActorSearchActors
import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.entity.app.bsky.actor.*
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.com.atproto._RepoResource
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
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

    override fun updateProfile(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse> {

        return runBlocking {

            val repoResource = _RepoResource(uri)

            val original = repoResource.getRecord(
                RepoGetRecordRequest(
                    repo = request.did!!,
                    collection = BlueskyTypes.ActorProfile,
                    rkey = "self"
                )
            )

            val originalActorProfile = original.data.value.asActorProfile
                ?: throw IllegalStateException("response data is not ActorProfile(type=${original.data.value.type}")

            val modifiedActorProfileRecord = ActorProfile().also {
                it.displayName = request.displayName ?: originalActorProfile.displayName
                it.description = request.description ?: originalActorProfile.description
                it.avatar = request.avatar ?: originalActorProfile.avatar

                if (request.clearBanner) {
                    it.banner = null
                } else {
                    it.banner = request.banner ?: originalActorProfile.banner
                }
            }

            val r = repoResource.putRecord(
                RepoPutRecordRequest(
                    collection = BlueskyTypes.ActorProfile,
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    rkey = "self",
                    record = modifiedActorProfileRecord
                )
            )

            Response(ActorUpdateProfileResponse().also {
                it.uri = r.data.uri
                it.cid = r.data.cid
            }, r.json)
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
