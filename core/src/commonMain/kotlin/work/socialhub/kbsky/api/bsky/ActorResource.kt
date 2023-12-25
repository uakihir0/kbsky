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
     *
     */
    fun getProfile(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse>

    /**
     *
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
