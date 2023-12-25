package work.socialhub.kbsky

import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewDetailed
import work.socialhub.kbsky.model.bsky.embed.EmbedImagesView
import work.socialhub.kbsky.model.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.share.RecordUnion
import java.io.*
import kotlin.test.BeforeTest

open class AbstractTest {
    protected lateinit var handle: String
    protected lateinit var password: String
    protected lateinit var accessJwt: String

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val json = readFile("../secrets.json")
            val props = fromJson<Map<String, String>>(json!!)

            handle = checkNotNull(props["handle"]) { "missing handle." }
            password = checkNotNull(props["password"]) { "missing password." }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        // restore session.
        readAccessJwt()
    }

    /**
     * Read Access JWT
     */
    fun readAccessJwt() {
        val jwt = readFile("../jwt.txt")
        if (jwt != null) {
            accessJwt = jwt
        }
    }

    /**
     * Save Access JWT
     */
    fun saveAccessJwt() {
        saveFile(accessJwt, "../jwt.txt")
    }

    fun print(record: RecordUnion) {
        println("TYPE> " + record.type)
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
    private fun readFile(fileName: String): String? {
        try {
            val fr = FileReader(fileName)
            val br = BufferedReader(fr)
            val b = StringBuilder()

            var line: String?
            val ls = System.lineSeparator()
            while ((br.readLine().also { line = it }) != null) {
                b.append(line)
                b.append(ls)
            }

            b.deleteCharAt(b.length - 1)
            br.close()

            return b.toString()
        } catch (e: Exception) {
            return null
        }
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
