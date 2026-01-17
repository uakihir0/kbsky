> [日本語](./README_ja.md)

# kbsky.js

This repository is the npm repository for [kbsky]. [kbsky] is a Bluesky/ATProtocol client library created using Kotlin Multiplatform.
Therefore, it can be used in web applications and similar contexts.
Additionally, this repository is automatically committed by GitHub Actions of [kbsky]. Please submit issues or pull requests to [kbsky].

## Usage

### Installation

If you're managing with npm, you can add it to your application using the following command.
There are no versions in this repository, but there are branches corresponding to [kbsky] versions.
Please check the branches on the [branch list](https://github.com/uakihir0/kbsky.js/branches) to find the branch corresponding to the version you want to use.

```shell
npm add uakihir0/kbsky.js
or
npm add uakihir0/kbsky.js#{{BRANCH_NAME}}
```

### Basic Usage

TypeScript type information is included, so it's recommended to write in TypeScript.
Please also refer to the README of [kbsky] for detailed usage.

#### Authentication with Password

To start a session by specifying a handle and password, do as follows:

```typescript
import kbsky from "kbsky-js";
import BlueskyFactory = kbsky.work.socialhub.kbsky.BlueskyFactory;
import ServerCreateSessionRequest = kbsky.work.socialhub.kbsky.api.entity.app.bsky.actor.ServerCreateSessionRequest;
import BearerTokenAuthProvider = kbsky.work.socialhub.kbsky.domain.service.auth.BearerTokenAuthProvider;
import FeedPostRequest = kbsky.work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest;

const response = await BlueskyFactory
  .instance("https://bsky.social")
  .server()
  .createSession(
    new ServerCreateSessionRequest().also((it) => {
      it.identifier = "YOUR_HANDLE";
      it.password = "YOUR_PASSWORD";
    })
  );

console.log(response.data.accessJwt);

// Access resources with the obtained access token
const auth = new BearerTokenAuthProvider(response.data.accessJwt);

await BlueskyFactory
  .instance("https://bsky.social")
  .feed()
  .post(
    new FeedPostRequest(auth).also((it) => {
      it.text = "Hello World!";
    })
  );
```

#### Authentication with OAuth

Authentication using a password is gradually being replaced with OAuth. For more details on OAuth authentication, please refer to [Authentication via OAuth](../OAUTH.md).

### PLC Directory

```typescript
import kbsky from "kbsky-js";
import PLCDirectoryFactory = kbsky.work.socialhub.kbsky.PLCDirectoryFactory;

const response = await PLCDirectoryFactory
  .instance()
  .DIDDetails("did:plc:example");

console.log(response.data.alsoKnownAs[0]);
```

### SubscribeRepos (stream)

```typescript
import kbsky from "kbsky-js";
import ATProtocolStreamFactory = kbsky.work.socialhub.kbsky.ATProtocolStreamFactory;
import SyncSubscribeReposRequest = kbsky.work.socialhub.kbsky.api.entity.com.atproto.sync.SyncSubscribeReposRequest;
import EventCallback = kbsky.work.socialhub.kbsky.stream.EventCallback;

const stream = ATProtocolStreamFactory
  .instance(
    "https://bsky.social",
    "wss://bsky.network"
  )
  .sync()
  .subscribeRepos(
    new SyncSubscribeReposRequest().also((it) => {
      it.filter = ["app.bsky.feed.post"];
    })
  );

stream.eventCallback({
  onEvent: (cid, uri, record) => {
    console.log(record);
  }
});
```

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[kbsky]: https://github.com/uakihir0/kbsky
