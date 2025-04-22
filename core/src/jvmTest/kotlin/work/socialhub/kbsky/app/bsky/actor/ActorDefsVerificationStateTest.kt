package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsVerificationState
import kotlin.test.Test
import kotlin.test.assertEquals

class ActorDefsVerificationStateTest : AbstractTest() {

    @Test
    fun testVerificationStateParsing1() {
        // verification state of @bsky.app (verifier)
        val jsonString = """
        {
            "verifications": [],
            "verifiedStatus": "none",
            "trustedVerifierStatus": "valid"
        }
        """.trimIndent()

        // JSONからパース
        val verificationState = json.decodeFromString<ActorDefsVerificationState>(jsonString)

        // 検証
        assertEquals(0, verificationState.verifications.size)
        assertEquals(
            ActorDefsVerificationState.STATUS_NONE,
            verificationState.verifiedStatus
        )
        assertEquals(
            ActorDefsVerificationState.STATUS_VALID,
            verificationState.trustedVerifierStatus
        )
    }

    @Test
    fun testVerificationStateParsing2() {
        // verification state of @nikkei.com (verified by bsky)
        val jsonString = """
        {
            "verifications": [
                {
                    "issuer": "did:plc:z72i7hdynmk6r22z27h6tvur",
                    "uri": "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.graph.verification/3lndpu2lols2z",
                    "isValid": true,
                    "createdAt": "2025-04-21T10:46:52.295Z"
                }
            ],
            "verifiedStatus": "valid",
            "trustedVerifierStatus": "none"
        }
        """.trimIndent()

        // JSONからパース
        val verificationState = json.decodeFromString<ActorDefsVerificationState>(jsonString)

        // 検証
        assertEquals(1, verificationState.verifications.size)
        val verification = verificationState.verifications[0]
        assertEquals("did:plc:z72i7hdynmk6r22z27h6tvur", verification.issuer)
        assertEquals(
            "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.graph.verification/3lndpu2lols2z",
            verification.uri
        )
        assertEquals(true, verification.isValid)
        assertEquals("2025-04-21T10:46:52.295Z", verification.createdAt)
        assertEquals(
            ActorDefsVerificationState.STATUS_VALID,
            verificationState.verifiedStatus
        )
        assertEquals(
            ActorDefsVerificationState.STATUS_NONE,
            verificationState.trustedVerifierStatus
        )
    }

    @Test
    fun testVerificationStateConstants() {
        // 定数の検証
        assertEquals("valid", ActorDefsVerificationState.STATUS_VALID)
        assertEquals("invalid", ActorDefsVerificationState.STATUS_INVALID)
        assertEquals("none", ActorDefsVerificationState.STATUS_NONE)
    }
}