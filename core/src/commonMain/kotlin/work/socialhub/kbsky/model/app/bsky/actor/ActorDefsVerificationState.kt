package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

/**
 * Represents the verification information about the user this object is attached to.
 */
@Serializable
data class ActorDefsVerificationState(
    /**
     * All verifications issued by trusted verifiers on behalf of this user.
     * Verifications by untrusted verifiers are not included.
     */
    val verifications: List<ActorDefsVerificationView>,

    /**
     * The user's status as a verified account.
     * Known values: "valid", "invalid", "none"
     */
    val verifiedStatus: String,

    /**
     * The user's status as a trusted verifier.
     * Known values: "valid", "invalid", "none"
     */
    val trustedVerifierStatus: String
) {
    companion object {
        const val STATUS_VALID = "valid"
        const val STATUS_INVALID = "invalid"
        const val STATUS_NONE = "none"
    }
} 