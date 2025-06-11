package work.socialhub.kbsky.auth.api.entity.oauth

data class BuildAuthorizationUrlRequest(
    var requestUri: String = "",
    var clientId: String = "",
)
