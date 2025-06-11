package work.socialhub.kbsky.auth.api.entity.wellknown

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WellKnownOAuthProtectedResourceResponse(
    @SerialName("resource")
    var resource: String = "",

    @SerialName("authorization_servers")
    var authorizationServers: List<String> = emptyList(),

    @SerialName("scopes_supported")
    var scopesSupported: List<String> = emptyList(),

    @SerialName("bearer_methods_supported")
    var bearerMethodsSupported: List<String> = emptyList(),

    @SerialName("resource_documentation")
    var resourceDocumentation: String = "",
)
