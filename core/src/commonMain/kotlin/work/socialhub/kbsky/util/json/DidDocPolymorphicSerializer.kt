package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.atproto.server.DidDocUnion
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
        return DidDocUnion.serializer()
    }
}