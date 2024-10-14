# Authentication via OAuth

## Introduction

The OAuth procedure outlined below is an example using kbsky. For more detailed information, refer to the [official Bluesky documentation](https://docs.bsky.app/docs/advanced-guides/oauth-client).

## Procedure

First, access the endpoint to retrieve meta information in order to obtain the various endpoints.

```kotlin
val auth = AuthFactory
    .instance(BSKY_SOCIAL.uri)
    .wellKnown()
    .oAuthProtectedResource()

auth.wellKnown()
    .oAuthAuthorizationServer()
```

Next, call the PAR (Pushed Authorization Request) endpoint. At this time, create an `OAuthContext` and fill in `clientId` and `redirectUri`. For `clientId`, provide the full path to the `client-metadata.json` containing the client’s meta information. For `redirectUri`, specify one of the URIs listed in the `redirect_uris` field of the meta information. Refer to [this example](https://www.uakihir0.com/socialhub/oauth/client-metadata.json) for the `client-metadata.json`. Below is the code to make a PAR request and generate a URL for the authentication page using the `requestUri` obtained from the request.

```kotlin
val context = OAuthContext().also {
    it.clientId = "{{client-metadata.json URL}}"
    it.redirectUri = "{{CALLBACK URI}}"
}

auth.oauth()
    .pushedAuthorizationRequest(context,
        OAuthPushedAuthorizationRequest().also {
            it.loginHint = "{{HANDLE}}"
        }
    )

auth.oauth()
    .buildAuthorizationUrl(context,
        BuildAuthorizationUrlRequest().also {
            it.requestUri = response.data.requestUri
        })

println(authorizeUrl)
```

After completing authentication on the authentication screen, you will be redirected to the callback URL with an authorization code. Use this code to obtain an access token as shown below.

```kotlin
val callback = "{{CALLBACK URI}}"

val code = Url(callback).parameters["code"].also { println(it) }

auth.oauth()
    .tokenRequest(oAuthContext,
        OAuthTokenRequest().also {
            it.code = code!!
        }
    )

println(response.data.accessToken)
println(response.data.refreshToken)
```

## Persisting Information

After obtaining the access token, save the `clientId`, `accessToken`, `refreshToken`, as well as `publicKey` and `privateKey` from the `OAuthContext` to access various resources.

## Resource Execution

Execute various resources as shown below. If any missing information during authentication can be resolved by retrying, the system will automatically retry.

```kotlin
val oAuthSession = OAuthSession().also {
    it.clientId = "{{CLIENT ID}}"
    it.publicKey = "{{PUBLIC KEY}}"
    it.privateKey = "{{PRIVATE KEY}}"
}

val oAuthProvider = OAuthProvider(
    accessTokenJwt = "{{ACCESS TOKEN}}",
    session = oAuthSession
)

BlueskyFactory
    .instance("{{PDS URL}}")
    .feed()
    .post(
        FeedPostRequest(oAuthProvider).also {
            it.text = "TEST"
        }
    )
```