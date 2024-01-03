package work.socialhub.kbsky.api.bsky

import work.socialhub.kbsky.api.entity.bsky.actor.*
import work.socialhub.kbsky.api.entity.share.Response

interface ActorResource {

    /**
     * Find actors matching search criteria.
     */
    fun searchActors(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse>

    /**
     * Get detailed profile view of an actor.
     */
    fun getProfile(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse>

    /**
     * Get detailed profile views of multiple actors.
     */
    fun getProfiles(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse>

    /**
     * Get private preferences attached to the account.
     */
    fun getPreferences(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse>
}
