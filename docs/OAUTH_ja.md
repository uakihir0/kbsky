# OAuth による認証

## はじめに

以下に載せる OAuth の手順は kbsky を用いた一例です。細かい内容については Bluesky
の[公式ドキュメント](https://docs.bsky.app/docs/advanced-guides/oauth-client)を参照してください。

## 手順

初めに各種エンドポイントを取得するために、メタ情報を取得するエンドポイントにアクセスします。

```kotlin
val auth = AuthFactory
    .instance(BSKY_SOCIAL.uri)
    .wellKnown()
    .oAuthProtectedResource()

auth.wellKnown()
    .oAuthAuthorizationServer()
```

次に、PAR のエンドポイントを呼びます。この時、`OAuthContext` を作成して、その中の `clientId` と `redirectUri` を埋めます。
`clientId` には、クライアントの各種メタ情報が入った `client-metadata.json` へのフルパスを記述します。
`redirectUri` にはそのメタ情報で指定した `redirect_uris` のどれかの URI を指定します。`client-metadata.json`
は[こちら](https://www.uakihir0.com/socialhub/oauth/client-metadata.json)などを参考にしてください。 以下は PAR
リクエストと、そのリクエストから得られた `requestUri` から、認証ページの URL を生成するコードです。

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

認証画面にて、認証を終えると、認証コードが付与されたコールバック URL にリダイレクトされます。そのコードを使って、アクセストークンを以下のように取得します。

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

## 永続化情報

アクセストークンを取得した後に、各種リソースにアクセスするために、`clientId`、`accessToken`、`refreshToken` と共に
`OAuthContext` から `publicKey` と `privateKey` を保存してください。

## リソース実行

各種リソースの実行には以下のように実行します。この時、認証において足りない情報があり、リトライで解決できる場合は自動的にリトライします。

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