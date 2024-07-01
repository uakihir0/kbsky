package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion
import work.socialhub.kbsky.model.plc.DIDDetails

object DidDocPolymorphicSerializer :
    JsonContentPolymorphicSerializer<DidDocUnion>(
        DidDocUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<DidDocUnion> {
        val did = element.jsonObject["id"]?.jsonPrimitive?.content
        if (did?.startsWith("did:plc:") == true) {
            return DIDDetails.serializer()
        }

        println("[Warning] Unknown Item type (DidDocPolymorphicSerializer)")
        return Unknown.serializer()
    }

    @Serializable
    class Unknown : DidDocUnion()
}