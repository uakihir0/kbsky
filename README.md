> [日本語](./docs/README_ja.md)

# kbsky

![badge][badge-js]
![badge][badge-jvm]
![badge][badge-ios]
![badge][badge-mac]

**This library is a Bluesky/ATProtocol client library compatible with [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html).**
It depends on [khttpclient] and internally uses Ktor Client.
Therefore, this library is available on platforms supported by Kotlin Multiplatform and Ktor Client.
The behavior on each platform depends on [khttpclient].

## Usage

The following is how to use Gradle with Kotlin on supported platforms.
**For Apple platform, please refer to [kbsky-cocoapods](https://github.com/uakihir0/kbsky-cocoapods).**

```kotlin:build.gradle.kts
repositories {
    mavenCentral()
+   maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
}

dependencies {
+   implementation("work.socialhub.kbsky:core:0.0.1-SNAPSHOT")
+   implementation("work.socialhub.kbsky:stream:0.0.1-SNAPSHOT")
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

## License

MIT License

## Author

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
