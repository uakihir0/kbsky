package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataAddMember
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataCreateJoinLink
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataDisableJoinLink
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataEditGroup
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataEditJoinLink
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataEnableJoinLink
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataLockConvo
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataLockConvoPermanently
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataMemberJoin
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataMemberLeave
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataRemoveMember
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsSystemMessageDataUnlockConvo
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsSystemMessageDataUnionSerializer :
    JsonContentPolymorphicSerializer<ConvoDefsSystemMessageDataUnion>(
        ConvoDefsSystemMessageDataUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ConvoDefsSystemMessageDataUnion> {
        return when (val type = element.type()) {
            ConvoDefsSystemMessageDataAddMember.TYPE -> ConvoDefsSystemMessageDataAddMember.serializer()
            ConvoDefsSystemMessageDataRemoveMember.TYPE -> ConvoDefsSystemMessageDataRemoveMember.serializer()
            ConvoDefsSystemMessageDataMemberJoin.TYPE -> ConvoDefsSystemMessageDataMemberJoin.serializer()
            ConvoDefsSystemMessageDataMemberLeave.TYPE -> ConvoDefsSystemMessageDataMemberLeave.serializer()
            ConvoDefsSystemMessageDataLockConvo.TYPE -> ConvoDefsSystemMessageDataLockConvo.serializer()
            ConvoDefsSystemMessageDataUnlockConvo.TYPE -> ConvoDefsSystemMessageDataUnlockConvo.serializer()
            ConvoDefsSystemMessageDataLockConvoPermanently.TYPE -> ConvoDefsSystemMessageDataLockConvoPermanently.serializer()
            ConvoDefsSystemMessageDataEditGroup.TYPE -> ConvoDefsSystemMessageDataEditGroup.serializer()
            ConvoDefsSystemMessageDataCreateJoinLink.TYPE -> ConvoDefsSystemMessageDataCreateJoinLink.serializer()
            ConvoDefsSystemMessageDataEditJoinLink.TYPE -> ConvoDefsSystemMessageDataEditJoinLink.serializer()
            ConvoDefsSystemMessageDataEnableJoinLink.TYPE -> ConvoDefsSystemMessageDataEnableJoinLink.serializer()
            ConvoDefsSystemMessageDataDisableJoinLink.TYPE -> ConvoDefsSystemMessageDataDisableJoinLink.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsSystemMessageDataUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ConvoDefsSystemMessageDataUnion() {
        override var type: String = "unknown"
    }
}
