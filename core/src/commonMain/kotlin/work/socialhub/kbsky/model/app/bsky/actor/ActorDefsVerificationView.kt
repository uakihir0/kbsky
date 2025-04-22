package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

/**
 * An individual verification for an associated subject.
 */
@Serializable
data class ActorDefsVerificationView(
    /**
     * The user who issued this verification.
     * Format: did
     */
    val issuer: String,

    /**
     * The AT-URI of the verification record.
     * Format: at-uri
     */
    val uri: String,

    /**
     * True if the verification passes validation, otherwise false.
     */
    val isValid: Boolean,

    /**
     * Timestamp when the verification was created.
     * Format: datetime
     */
    val createdAt: String
) 