# Documentation for Agents

## Testing Method

Since this is primarily a client library for SNS, testing generally requires a user account. However, some endpoints can be tested without a user account. To verify the build and ensure that the basic functionality is not broken, please make sure to run the following test:

```shell
./gradlew core:jvmTest --tests "work.socialhub.kbsky.com.atproto.identity.ResolveHandleTest.testResolveHandle"
```

If you cannot access the Bluesky server, please verify that the build is successful. In the JVM environment, you can check compilation with the following command:

```shell
./gradlew jvmJar
```
