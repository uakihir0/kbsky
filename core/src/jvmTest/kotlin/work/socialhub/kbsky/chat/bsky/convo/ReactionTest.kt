package work.socialhub.kbsky.chat.bsky.convo

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import kotlin.test.Test

class ReactionTest : AbstractTest() {

    @Test
    fun testAddReaction() = runTest {
        // TODO Specify the convoId and messageId of the message you want to add a reaction to
//        val convoId = "3kt574hlxf72q"
//        val messageId = "3lmij5ilmwq2c"
//        val value = "🙌"
//
//        val message = BlueskyFactory
//            .instance().also {
//                it.server()
//                    .getSession(
//                        AuthRequest(auth())
//                    )
//            }
//            .convo()
//            .addReaction(
//                ConvoAddReactionRequest(
//                    auth = auth(),
//                    convoId = convoId,
//                    messageId = messageId,
//                    value = value,
//                )
//            )
//
//        dump(message.data.message)
    }

    @Test
    fun testRemoveReaction() = runTest {
        // TODO Specify the convoId and messageId of the message you want to remove a reaction from
//        val convoId = "3kt574hlxf72q"
//        val messageId = "3lmij5ilmwq2c"
//        val value = "🙌"
//
//        val message = BlueskyFactory
//            .instance().also {
//                it.server()
//                    .getSession(
//                        AuthRequest(auth())
//                    )
//            }
//            .convo()
//            .removeReaction(
//                ConvoRemoveReactionRequest(
//                    auth = auth(),
//                    convoId = convoId,
//                    messageId = messageId,
//                    value = value,
//                )
//            )
//
//        dump(message.data.message)
    }
}