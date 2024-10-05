package work.socialhub.kbsky.auth.api.entity.wellknown

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WellKnownOAuthProtectedResourceResponse {

    @SerialName("resource")
    lateinit var resource: String

    @SerialName("authorization_servers")
    lateinit var authorizationServers: List<String>

    @SerialName("scopes_supported")
    lateinit var scopesSupported: List<String>

    @SerialName("bearer_methods_supported")
    lateinit var bearerMethodsSupported: List<String>

    @SerialName("resource_documentation")
    lateinit var resourceDocumentation: String
}