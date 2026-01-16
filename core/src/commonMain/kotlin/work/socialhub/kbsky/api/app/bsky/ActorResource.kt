package work.socialhub.kbsky.api.app.bsky


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
import work.socialhub.kbsky.api.entity.share.Response
import kotlin.js.JsExport

@JsExport
interface ActorResource {

    /**
     * Find actors matching search criteria.
     */
    suspend fun searchActors(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse>

    @JsExport.Ignore
    fun searchActorsBlocking(
        request: ActorSearchActorsRequest
    ): Response<ActorSearchActorsResponse>

    /**
     * Find actor suggestions for a prefix search term.
     */
    suspend fun searchActorsTypeahead(
        request: ActorSearchActorsTypeaheadRequest
    ): Response<ActorSearchActorsTypeaheadResponse>

    @JsExport.Ignore
    fun searchActorsTypeaheadBlocking(
        request: ActorSearchActorsTypeaheadRequest
    ): Response<ActorSearchActorsTypeaheadResponse>

    /**
     * Get detailed profile view of an actor.
     */
    suspend fun getProfile(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse>

    @JsExport.Ignore
    fun getProfileBlocking(
        request: ActorGetProfileRequest
    ): Response<ActorGetProfileResponse>

    /**
     * Update the profile of the actor.
     */
    suspend fun updateProfile(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse>

    @JsExport.Ignore
    fun updateProfileBlocking(
        request: ActorUpdateProfileRequest
    ): Response<ActorUpdateProfileResponse>

    /**
     * Get detailed profile views of multiple actors.
     */
    suspend fun getProfiles(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse>

    @JsExport.Ignore
    fun getProfilesBlocking(
        request: ActorGetProfilesRequest
    ): Response<ActorGetProfilesResponse>

    /**
     * Get private preferences attached to the account.
     */
    suspend fun getPreferences(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse>

    @JsExport.Ignore
    fun getPreferencesBlocking(
        request: ActorGetPreferencesRequest
    ): Response<ActorGetPreferencesResponse>
}
