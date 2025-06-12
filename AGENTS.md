# Documentation for Agents

## Testing Method

Since this is primarily a client library for SNS, testing generally requires a user account. However, some endpoints can be tested without a user account. To verify the build and ensure that the basic functionality is not broken, please make sure to run the following test:

```shell
./gradlew core:jvmTest --tests "work.socialhub.kbsky.com.atproto.identity.ResolveHandleTest.testResolveHandle"
```
