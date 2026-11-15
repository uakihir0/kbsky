package work.socialhub.kbsky.api.entity.com.atproto.repo


import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import work.socialhub.kbsky.model.share.RecordUnion
import work.socialhub.kbsky.util.json.RecordJsonUtil
import kotlin.js.JsExport

/**
 * An operation of com.atproto.repo.applyWrites.
 * @see RepoApplyWritesCreate
 * @see RepoApplyWritesUpdate
 * @see RepoApplyWritesDelete
 */
@JsExport
sealed class RepoApplyWritesWrite {
    abstract val type: String

    /** The NSID of the record collection. */
    abstract val collection: String

    fun toJsonObject(): JsonObject {
        return buildJsonObject {
            put("\$type", JsonPrimitive(type))
            put("collection", JsonPrimitive(collection))
            appendFields(this)
        }
    }

    internal abstract fun appendFields(builder: JsonObjectBuilder)
}

/**
 * Operation which creates a new record.
 */
@JsExport
data class RepoApplyWritesCreate(
    override val collection: String,
    /** The record to create (with `$type`). */
    val value: JsonObject,
    /** NOTE: maxLength is 512 */
    val rkey: String? = null,
) : RepoApplyWritesWrite() {

    override val type: String = TYPE

    override fun appendFields(builder: JsonObjectBuilder) {
        rkey?.let { builder.put("rkey", JsonPrimitive(it)) }
        builder.put("value", value)
    }

    companion object {
        const val TYPE = "com.atproto.repo.applyWrites#create"

        /**
         * Create from a record model.
         * The value is encoded in the same way as createRecord.
         */
        @JsExport.Ignore
        fun fromRecord(
            collection: String,
            record: RecordUnion,
            rkey: String? = null,
        ) = RepoApplyWritesCreate(
            collection = collection,
            value = RecordJsonUtil.toJsonObject(record),
            rkey = rkey,
        )
    }
}

/**
 * Operation which updates an existing record.
 */
@JsExport
data class RepoApplyWritesUpdate(
    override val collection: String,
    val rkey: String,
    /** The record to write (with `$type`). */
    val value: JsonObject,
) : RepoApplyWritesWrite() {

    override val type: String = TYPE

    override fun appendFields(builder: JsonObjectBuilder) {
        builder.put("rkey", JsonPrimitive(rkey))
        builder.put("value", value)
    }

    companion object {
        const val TYPE = "com.atproto.repo.applyWrites#update"

        /**
         * Create from a record model.
         * The value is encoded in the same way as putRecord.
         */
        @JsExport.Ignore
        fun fromRecord(
            collection: String,
            rkey: String,
            record: RecordUnion,
        ) = RepoApplyWritesUpdate(
            collection = collection,
            rkey = rkey,
            value = RecordJsonUtil.toJsonObject(record),
        )
    }
}

/**
 * Operation which deletes an existing record.
 */
@JsExport
data class RepoApplyWritesDelete(
    override val collection: String,
    val rkey: String,
) : RepoApplyWritesWrite() {

    override val type: String = TYPE

    override fun appendFields(builder: JsonObjectBuilder) {
        builder.put("rkey", JsonPrimitive(rkey))
    }

    companion object {
        const val TYPE = "com.atproto.repo.applyWrites#delete"
    }
}
