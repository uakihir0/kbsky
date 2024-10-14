package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfilesRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfilesResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsResponse
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorUpdateProfileRequest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorUpdateProfileResponse
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
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse>
}
