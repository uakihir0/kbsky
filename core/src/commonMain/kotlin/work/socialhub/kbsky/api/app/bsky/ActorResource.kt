package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.actor.*
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
        request: work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileRequest
    ): Response<ActorGetProfileResponse>

    /**
     * Update the profile of the actor.
     */
    fun updateProfile(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse>

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
        request: work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesRequest
    ): Response<work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesResponse>
}
