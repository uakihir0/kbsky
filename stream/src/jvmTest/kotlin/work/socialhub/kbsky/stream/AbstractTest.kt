package work.socialhub.kbsky.stream

import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed
import work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesView
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.share.RecordUnion
import java.io.ByteArrayOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStream
import kotlin.test.BeforeTest

open class AbstractTest {

    @Synchronized
    fun print(record: RecordUnion) {
        println("TYPE> " + record.type)

        if (record is FeedPost) {
            println("TEXT> " + record.text)
        }
    }

    fun print(post: FeedDefsPostView) {

        println("|POST|-----------------------------------------")
        println("URI> " + post.uri)
        println("CID> " + post.cid)

        if (post.embed != null) {
            val embed = post.embed
            if (embed is EmbedImagesView) {
                println("ImageURL> " + embed.images!![0].fullsize)
            }
        }

        val record = post.record
        if (record is FeedPost) {
            println("TEXT> " + record.text)
        }
    }

    fun print(user: ActorDefsProfileView) {
        println("|USER|-----------------------------------------")
        println("DID> " + user.did)
        println("HANDLE> " + user.handle)
        println("NAME> " + user.displayName)
    }

    fun print(user: ActorDefsProfileViewDetailed) {
        println("|USER|-----------------------------------------")
        println("DID> " + user.did)
        println("HANDLE> " + user.handle)
        println("NAME> " + user.displayName)
        println("FOLLOWS COUNT> " + user.followsCount)
        println("FOLLOWERS COUNT> " + user.followersCount)
    }

    /**
     * Read File
     */
    private fun readFile(file: String): String {
        return FileReader(file).readText()
    }

    /**
     * Save File
     */
    private fun saveFile(str: String?, fileName: String) {
        try {
            val fw = FileWriter(fileName)
            fw.write(str!!)
            fw.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        /**
         * File to ImageBytes
         */
        fun convertFile(stream: InputStream): ByteArray {
            try {
                ByteArrayOutputStream().use { bout ->
                    var len: Int
                    val buffer = ByteArray(1024)

                    while ((stream.read(buffer).also { len = it }) != -1) {
                        bout.write(buffer, 0, len)
                    }
                    return bout.toByteArray()
                }
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }
}

