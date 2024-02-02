package work.socialhub.kbsky

import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewDetailed
import work.socialhub.kbsky.model.bsky.embed.EmbedImagesView
import work.socialhub.kbsky.model.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.share.RecordUnion
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import kotlin.test.BeforeTest

open class AbstractTest {
    protected lateinit var handle: String
    protected lateinit var password: String
    protected lateinit var accessJwt: String
    protected lateinit var refreshJwt: String

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

            record.facets?.forEach { r ->
                println("FACET> " + r.type)
                r.features?.forEach { f ->
                    println("FEATURE> " + f.type)
                    f.tag()?.let { t ->
                        println("TAG> " + t.tag)
                    }
                }
            }
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
    private fun readFile(file: String): String? {
        return try {
            File(file).readText()
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Save File
     */
    private fun saveFile(str: String?, file: String) {
        try {
            File(file).writeText(str!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
