# kbsky

<!-- ![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo.repsy.io%2Fmvn%2Fuakihir0%2Fpublic%2Fwork%2Fsocialhub%2Fkbsky%2Fcore%2Fmaven-metadata.xml) -->
![Maven Central Version](https://img.shields.io/maven-central/v/work.socialhub.kbsky/all)

![badge][badge-js]
![badge][badge-jvm]
![badge][badge-ios]
![badge][badge-mac]

**このライブラリは [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) に対応した Bluesky/ATProtocol クライアントライブラリです。**
[khttpclient] を依存関係に持っており、 内部で Ktor Client を使用しています。
そのため、本ライブラリは、Kotlin Multiplatform かつ Ktor Client がサポートしているプラットフォームであれば利用可能です。
各プラットフォームでどのような挙動をするのかについては、[khttpclient] に依存します。

## 使い方

以下は対応するプラットフォームにおいて Gradle を用いて Kotlin で使用する際の使い方になります。
**Apple プラットフォームで使用する場合は、 [kbsky-cocoapods](https://github.com/uakihir0/kbsky-cocoapods) を参照してください。**
また、テストコードも合わせて確認してください。

### Stable (Maven Central)

```kotlin:build.gradle.kts
repositories {
    mavenCentral()
}

dependencies {
+   implementation("work.socialhub.kbsky:core:0.1.0")
+   implementation("work.socialhub.kbsky:stream:0.1.0")
}
```

### Snapshot

```kotlin:build.gradle.kts
repositories {
+   maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
}

dependencies {
+   implementation("work.socialhub.kbsky:core:0.2.0-SNAPSHOT")
+   implementation("work.socialhub.kbsky:stream:0.2.0-SNAPSHOT")
}
```

### CreateSession

```kotlin
val response = BlueskyFactory
    .instance(BSKY_SOCIAL.uri)
    .server()
    .createSession(
        ServerCreateSessionRequest().also {
            it.identifier = HANDLE
            it.password = PASSWORD
        }
    )

println(response.data.accessJwt)
```

### SendFeed

```kotlin
BlueskyFactory
    .instance(BSKY_SOCIAL.uri)
    .feed()
    .post(
        FeedPostRequest(accessJwt).also {
            it.text = "Hello World!"
        }
    )
```

### PLC Directory

```kotlin
val response = PLCDirectoryFactory
    .instance()
    .DIDDetails(did)

println(checkNotNull(response.data.alsoKnownAs)[0])
```

### SubscribeRepos (stream)

```kotlin
val stream = ATProtocolStreamFactory
    .instance(
        apiUri = BSKY_SOCIAL.uri,
        streamUri = BSKY_NETWORK.uri
    )
    .sync()
    .subscribeRepos(
        SyncSubscribeReposRequest().also {
            it.filter = listOf(
                "app.bsky.feed.post"
            )
        }
    )

stream.eventCallback(
    object : EventCallback {
        override fun onEvent(
            cid: String?,
            uri: String?,
            record: RecordUnion
        ) {
            print(record)
        }
    })
```

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)

[khttpclient]: https://github.com/uakihir0/khttpclient
[badge-android]: http://img.shields.io/badge/-android-6EDB8D.svg
[badge-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg
[badge-wearos]: http://img.shields.io/badge/-wearos-8ECDA0.svg
[badge-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg
[badge-js]: http://img.shields.io/badge/-js-F8DB5D.svg
[badge-js-ir]: https://img.shields.io/badge/support-[IR]-AAC4E0.svg
[badge-nodejs]: https://img.shields.io/badge/-nodejs-68a063.svg
[badge-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg
[badge-windows]: http://img.shields.io/badge/-windows-4D76CD.svg
[badge-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg
[badge-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg
[badge-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg
[badge-mac]: http://img.shields.io/badge/-macos-111111.svg
[badge-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg
[badge-tvos]: http://img.shields.io/badge/-tvos-808080.svg