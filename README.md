> [日本語](./docs/README_ja.md)

# kbsky

<!-- ![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo.repsy.io%2Fmvn%2Fuakihir0%2Fpublic%2Fwork%2Fsocialhub%2Fkbsky%2Fcore%2Fmaven-metadata.xml) -->
![Maven Central Version](https://img.shields.io/maven-central/v/work.socialhub.kbsky/all)

![badge][badge-jvm]
![badge][badge-ios]
![badge][badge-mac]

**This library is a Bluesky/ATProtocol client library compatible
with [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html).**
It depends on [khttpclient] and uses Ktor Client internally. Therefore, this library can be used on any platform
supported by Kotlin Multiplatform and Ktor Client. The behavior on each platform depends on [khttpclient].

## Usage

Below is how to use it with Kotlin on the supported platforms using Gradle.  
**If you are using it on an Apple platform, please refer
to [kbsky-cocoapods](https://github.com/uakihir0/kbsky-cocoapods).**  
Additionally, please check the test code as well.

### Stable (Maven Central)

```kotlin:build.gradle.kts
repositories {
    mavenCentral()
}

dependencies {
+   implementation("work.socialhub.kbsky:core:0.2.0")
+   implementation("work.socialhub.kbsky:auth:0.2.0")
+   implementation("work.socialhub.kbsky:stream:0.2.0")
}
```

### Snapshot

```kotlin:build.gradle.kts
repositories {
+   maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
}

dependencies {
+   implementation("work.socialhub.kbsky:core:0.3.0-SNAPSHOT")
+   implementation("work.socialhub.kbsky:auth:0.3.0-SNAPSHOT")
+   implementation("work.socialhub.kbsky:stream:0.3.0-SNAPSHOT")
}
```

### Using as part of a regular Java project

All of the above can be added to and used in regular Java projects, too. All you have to do is to use the suffix `-jvm` when listing the dependency.

Here is a sample Maven configuration:

```xml
<dependency>
    <groupId>work.socialhub.kbsky</groupId>
    <artifactId>core-jvm</artifactId>
    <version>[VERSION]</version>
</dependency>
```

### Starting a Session

#### Authentication with Password

To start a session by specifying a handle and password, do as follows:

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

To access various resources with the obtained access token, execute the following:

```kotlin
val auth = BearerTokenAuthProvider(accessJwt)

BlueskyFactory
    .instance(BSKY_SOCIAL.uri)
    .feed()
    .post(
        FeedPostRequest(auth).also {
            it.text = "Hello World!"
        }
    )
```

#### Authentication with OAuth

Authentication using a password is gradually being replaced with OAuth. For more details on OAuth authentication, please
refer to [Authentication via OAuth](./docs/OAUTH.md).

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
