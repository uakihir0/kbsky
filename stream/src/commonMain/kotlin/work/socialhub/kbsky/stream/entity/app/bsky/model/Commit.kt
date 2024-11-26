package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class Commit {

    lateinit var rev: String
    lateinit var operation: String
    lateinit var collection: String
    lateinit var rkey: String

    var record: RecordUnion? = null
    var cid: String? = null
}