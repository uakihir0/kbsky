package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsDisabledJoinLinkPreviewView
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsInvalidJoinLinkPreviewView
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsJoinLinkPreviewUnion
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsJoinLinkPreviewView
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatGroupDefsJoinLinkPreviewUnionSerializer :
    JsonContentPolymorphicSerializer<GroupDefsJoinLinkPreviewUnion>(
        GroupDefsJoinLinkPreviewUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<GroupDefsJoinLinkPreviewUnion> {
        return when (val type = element.type()) {
            GroupDefsJoinLinkPreviewView.TYPE -> GroupDefsJoinLinkPreviewView.serializer()
            GroupDefsDisabledJoinLinkPreviewView.TYPE -> GroupDefsDisabledJoinLinkPreviewView.serializer()
            GroupDefsInvalidJoinLinkPreviewView.TYPE -> GroupDefsInvalidJoinLinkPreviewView.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatGroupDefsJoinLinkPreviewUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : GroupDefsJoinLinkPreviewUnion() {
        override var type: String = "unknown"
    }
}
