package work.socialhub.kbsky.api.entity.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed
import kotlin.js.JsExport

@Serializable
@JsExport
class ActorGetProfileResponse : ActorDefsProfileViewDetailed()
