package work.socialhub.kbsky

import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed
import work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesView
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsConvoView
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsReactionView
import work.socialhub.kbsky.model.share.RecordUnion

object Printer {

    fun AbstractTest.dump(record: RecordUnion, sp: String = "") {
        println("{$sp}TYPE> ${record.type}")

        if (record is FeedPost) {
            println("{$sp}TEXT> ${record.text}")
        }
    }

    fun AbstractTest.dump(post: FeedDefsPostView, sp: String = "") {
        println("${sp}|POST|-----------------------------------------")
        println("${sp}URI> ${post.uri}")
        println("${sp}CID> ${post.cid}")

        if (post.embed != null) {
            val embed = post.embed
            if (embed is EmbedImagesView) {
                println("${sp}ImageURL> ${embed.images!![0].fullsize}")
            }
        }

        val record = post.record
        if (record is FeedPost) {
            println("${sp}TEXT> ${record.text}")

            record.facets?.forEach { r ->
                println("${sp}FACET> ${r.type}")
                r.features?.forEach { f ->
                    println("${sp}FEATURE> ${f.type}")
                    f.asTag?.let { t ->
                        println("${sp}TAG> ${t.tag}")
                    }
                }
            }
        }
    }

    fun AbstractTest.dump(user: ActorDefsProfileView, sp: String = "") {
        println("${sp}|USER|-----------------------------------------")
        println("${sp}DID> ${user.did}")
        println("${sp}HANDLE> ${user.handle}")
        println("${sp}NAME> ${user.displayName}")
    }

    fun AbstractTest.dump(user: ActorDefsProfileViewDetailed, sp: String = "") {
        println("${sp}|USER|-----------------------------------------")
        println("${sp}DID> ${user.did}")
        println("${sp}HANDLE> ${user.handle}")
        println("${sp}NAME> ${user.displayName}")
        println("${sp}FOLLOWS COUNT> ${user.followsCount}")
        println("${sp}FOLLOWERS COUNT> ${user.followersCount}")
    }

    fun AbstractTest.dump(convo: ConvoDefsConvoView, sp: String = "") {
        println("${sp}|CONVO|-----------------------------------------")
        println("${sp}ID> ${convo.id}")
        println("${sp}REV> ${convo.rev}")
        println("${sp}UNREAD COUNT> ${convo.unreadCount}")

        convo.lastMessage?.asMessageView?.let {
            dump(it, "$sp  ")
        }
        convo.lastReaction?.reaction?.let {
            println("${sp}LAST REACTION> ${it.value}")
        }
        println("${sp}MEMBERS> ${convo.members.size}")
        convo.members.forEach {
            dump(it, "$sp  ")
        }
    }

    fun AbstractTest.dump(messageUnion: ConvoDefsMessageUnion, sp: String = "") {
        messageUnion.asMessageView?.let { message ->
            println("${sp}|CONVO MESSAGE|-----------------------------------------")
            println("${sp}ID> ${message.id}")
            println("${sp}TEXT> ${message.text}")
            message.reactions.forEach {
                dump(it, "$sp  ")
            }
        }
        messageUnion.asDeletedMessageView?.let { message ->
            println("${sp}|CONVO DELETED MESSAGE|-----------------------------------------")
            println("${sp}ID> ${message.id}")
        }
    }

    fun AbstractTest.dump(reaction: ConvoDefsReactionView, sp: String = "") {
        println("${sp}|CONVO REACTION|-----------------------------------------")
        println("${sp}VALUE> ${reaction.value}")
        println("${sp}SENDER DID> ${reaction.sender.did}")
    }

    fun AbstractTest.dump(actor: ActorDefsProfileViewBasic, sp: String = "") {
        println("${sp}|CONVO ACTOR|-----------------------------------------")
        println("${sp}DID> ${actor.did}")
        println("${sp}DISPLAY NAME> ${actor.displayName}")
    }

    fun AbstractTest.dump(log: ConvoDefsLogUnion, sp: String = "") {
        println("${sp}|CONVO LOG|-----------------------------------------")
        println("${sp}TYPE> ${log.type}")

        log.asBeginConvo?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
        }
        log.asLeaveConvo?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
        }
        log.asCreateMessage?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
            dump(it.message, "$sp  ")
        }
        log.asDeleteMessage?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
            dump(it.message, "$sp  ")
        }
        log.asReadMessage?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
            dump(it.message, "$sp  ")
        }
        log.asAddReaction?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
            dump(it.message, "$sp  ")
            dump(it.reaction, "$sp  ")
        }
        log.asRemoveReaction?.let {
            println("${sp}CONVERSATION ID> ${it.convoId}")
            dump(it.message, "$sp  ")
            dump(it.reaction, "$sp  ")
        }
    }
}