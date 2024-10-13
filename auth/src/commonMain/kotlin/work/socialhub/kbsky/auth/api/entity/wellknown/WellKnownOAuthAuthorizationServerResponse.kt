package work.socialhub.kbsky.auth.api.entity.wellknown

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WellKnownOAuthAuthorizationServerResponse {

    @SerialName("issuer")
    lateinit var issuer: String

    @SerialName("scopes_supported")
    lateinit var scopesSupported: List<String>

    @SerialName("subject_types_supported")
    lateinit var subjectTypesSupported: List<String>

    @SerialName("response_types_supported")
    lateinit var responseTypesSupported: List<String>

    @SerialName("response_modes_supported")
    lateinit var responseModesSupported: List<String>

    @SerialName("grant_types_supported")
    lateinit var grantTypesSupported: List<String>

    @SerialName("code_challenge_methods_supported")
    lateinit var codeChallengeMethodsSupported: List<String>

    @SerialName("ui_locales_supported")
    lateinit var uiLocalesSupported: List<String>

    @SerialName("display_values_supported")
    lateinit var displayValuesSupported: List<String>

    @SerialName("authorization_response_iss_parameter_supported")
    var authorizationResponseIssParameterSupported: Boolean = false

    @SerialName("request_object_signing_alg_values_supported")
    lateinit var requestObjectSigningAlgValuesSupported: List<String>

    @SerialName("request_object_encryption_alg_values_supported")
    lateinit var requestObjectEncryptionAlgValuesSupported: List<String>

    @SerialName("request_object_encryption_enc_values_supported")
    lateinit var requestObjectEncryptionEncValuesSupported: List<String>

    @SerialName("request_parameter_supported")
    var requestParameterSupported: Boolean = false

    @SerialName("request_uri_parameter_supported")
    var requestUriParameterSupported: Boolean = false

    @SerialName("require_request_uri_registration")
    var requireRequestUriRegistration: Boolean = false

    @SerialName("jwks_uri")
    lateinit var jwksUri: String

    @SerialName("authorization_endpoint")
    lateinit var authorizationEndpoint: String

    @SerialName("token_endpoint")
    lateinit var tokenEndpoint: String

    @SerialName("token_endpoint_auth_methods_supported")
    lateinit var tokenEndpointAuthMethodsSupported: List<String>

    @SerialName("token_endpoint_auth_signing_alg_values_supported")
    lateinit var tokenEndpointAuthSigningAlgValuesSupported: List<String>

    @SerialName("revocation_endpoint")
    lateinit var revocationEndpoint: String

    @SerialName("introspection_endpoint")
    lateinit var introspectionEndpoint: String

    @SerialName("pushed_authorization_request_endpoint")
    lateinit var pushedAuthorizationRequestEndpoint: String

    @SerialName("require_pushed_authorization_requests")
    var requirePushedAuthorizationRequests: Boolean = false

    @SerialName("dpop_signing_alg_values_supported")
    lateinit var dpopSigningAlgValuesSupported: List<String>

    @SerialName("client_id_metadata_document_supported")
    var clientIdMetadataDocumentSupported: Boolean = false
}