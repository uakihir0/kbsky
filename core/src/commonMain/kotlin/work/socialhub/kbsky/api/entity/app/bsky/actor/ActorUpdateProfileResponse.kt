package work.socialhub.kbsky.api.entity.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordResponse
import kotlin.js.JsExport

@Serializable
@JsExport
class ActorUpdateProfileResponse : RepoPutRecordResponse()
