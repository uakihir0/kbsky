# kbsky.js

本レポジトリは、[kbsky] の npm レポジトリです。[kbsky] は Kotlin Multiplatform を用いて作成された Bluesky/ATProtocol クライアントライブラリです。
そのため、Web アプリケーション等でも使用していただくことができます。
また、このレポジトリは [kbsky] の GitHub Actions によって自動コミットされています。issue や pull request は [kbsky] にお願いします。

## 使用方法

### 追加方法

npm で管理している場合、以下のコマンドでアプリケーションに追加することができます。
本レポジトリにはバージョンは存在せず、[kbsky] のバージョンと一致するブランチが存在します。
どのバージョンの [kbsky] を使用するかは、本レポジトリのブランチを指定することで決定します。
[ブランチ一覧](https://github.com/uakihir0/kbsky.js/branches) からバージョンに対応するブランチを確認してください。

```shell
npm add uakihir0/kbsky.js
or
npm add uakihir0/kbsky.js#{{BRANCH_NAME}}
```

### 基本的な使い方

TypeScript の型情報も含まれており、TypeScript での記述をオススメします。
詳しい使い方については、[kbsky] の README も合わせて確認してください。

#### パスワードでの認証

ハンドルとパスワードを指定してセッションを開始する場合は以下のようにします。

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

// 取得したアクセストークンで各種リソースにアクセス
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

#### OAuth での認証

パスワードでの認証は徐々に OAuth による認証に移行される予定です。 OAuth での認証については長くなるので、[OAuth による認証](../OAUTH_ja.md) を参照してください。

### PLC Directory

```typescript
import kbsky from "kbsky-js";
import PLCDirectoryFactory = kbsky.work.socialhub.kbsky.PLCDirectoryFactory;

const response = await PLCDirectoryFactory
  .instance()
  .DIDDetails("did:plc:example");

console.log(response.data.alsoKnownAs[0]);
```

### SubscribeRepos (ストリーム)

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

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)

[kbsky]: https://github.com/uakihir0/kbsky
