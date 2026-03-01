package work.socialhub.kbsky.internal.app.bsky

import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.ActorGetPreferences
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfile
import work.socialhub.kbsky.BlueskyTypes.ActorGetProfiles
import work.socialhub.kbsky.BlueskyTypes.ActorProfile
import work.socialhub.kbsky.BlueskyTypes.ActorSearchActors
import work.socialhub.kbsky.BlueskyTypes.ActorSearchActorsTypeahead
import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfilesRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfilesResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsTypeaheadRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsTypeaheadResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorUpdateProfileRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorUpdateProfileResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.com.atproto.RepoResourceImpl
import work.socialhub.kbsky.internal.share.InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class ActorResourceImpl(
    private val config: BlueskyConfig
) : ActorResource {

    override suspend fun searchActors(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, ActorSearchActors))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun searchActorsBlocking(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse> {
        return toBlocking {
            searchActors(request)
        }
    }

    override suspend fun searchActorsTypeahead(
        request: ActorSearchActorsTypeaheadRequest
    ): Response<ActorSearchActorsTypeaheadResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, ActorSearchActorsTypeahead))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun searchActorsTypeaheadBlocking(
        request: ActorSearchActorsTypeaheadRequest
    ): Response<ActorSearchActorsTypeaheadResponse> {
        return toBlocking {
            searchActorsTypeahead(request)
        }
    }

    override suspend fun getProfile(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, ActorGetProfile))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getProfileBlocking(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse> {
        return toBlocking {
            getProfile(request)
        }
    }

    override suspend fun updateProfile(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse> {

        val repoResource = RepoResourceImpl(config)
        val original = repoResource.getRecord(
            RepoGetRecordRequest(
                repo = request.auth.did,
                collection = ActorProfile,
                rkey = "self"
            )
        )

        val originalActorProfile = original.data.value.asActorProfile
            ?: throw IllegalStateException("response data is not ActorProfile(type=${original.data.value.type}")

        val modifiedActorProfileRecord = ActorProfile().also {
            it.displayName = request.displayName ?: originalActorProfile.displayName
            it.description = request.description ?: originalActorProfile.description
            it.avatar = request.avatar ?: originalActorProfile.avatar

            it.banner = if (request.clearBanner) null
            else request.banner ?: originalActorProfile.banner

            it.pinnedPost = if (request.clearPinnedPost) null
            else request.pinnedPost ?: originalActorProfile.pinnedPost
        }

        val r = repoResource.putRecord(
            RepoPutRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                rkey = "self",
                collection = ActorProfile,
                record = modifiedActorProfileRecord
            )
        )

        return Response(ActorUpdateProfileResponse().also {
            it.uri = r.data.uri
            it.cid = r.data.cid
        }, r.json)
    }

    override fun updateProfileBlocking(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse> {
        return toBlocking {
            updateProfile(request)
        }
    }

    override suspend fun getProfiles(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, ActorGetProfiles))
                .accept(MediaType.JSON)
                .also {
                    request.actors?.forEach { actor ->
                        it.query("actors", actor)
                    }
                }
                .getWithAuth(request.auth)
        }
    }

    override fun getProfilesBlocking(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse> {
        return toBlocking {
            getProfiles(request)
        }
    }

    override suspend fun getPreferences(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, ActorGetPreferences))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getPreferencesBlocking(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse> {
        return toBlocking {
            getPreferences(request)
        }
    }
}
