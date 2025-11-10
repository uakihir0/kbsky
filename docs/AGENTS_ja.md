# エージェント資料

## 概要

このレポジトリは [Bluesky](https://bsky.app/) の API クライアントライブラリです（Kotlin Multiplatform 対応）。AT Protocol (atproto) に基づいて実装されています。

## 重要な概念

### Lexicon と NSID

**Lexicon** は AT Protocol のスキーマ定義言語で、API エンドポイント、レコード型、バリデーションルールを定義します。各 Lexicon は **NSID (Namespace Identifier)** で識別されます（リバース DNS 形式）。

例：

- `com.atproto.identity.resolveHandle` - ハンドルから DID を解決する API
- `app.bsky.feed.post` - 投稿レコードのスキーマ定義
- `app.bsky.feed.getTimeline` - タイムライン取得 API
- `chat.bsky.convo.sendMessage` - DM メッセージ送信 API

主要な名前空間：

- `com.atproto.*` - AT Protocol のコア機能
- `app.bsky.*` - Bluesky アプリケーション固有の機能（フィード、プロフィール、ソーシャルグラフなど）
- `chat.bsky.*` - Bluesky のダイレクトメッセージ（DM）機能

### XRPC

**XRPC** は AT Protocol の HTTP API システムです。すべてのエンドポイントは `/xrpc/{NSID}` の形式でアクセスします。

- **Query (GET)**: データの取得（読み取り専用）
- **Procedure (POST)**: データの作成・更新・削除

### Lexicon 仕様の参照

実装時は必ず最新の Lexicon 仕様と照合してください：

- **Lexicon 定義ファイル**: [bluesky-social/atproto/lexicons](https://github.com/bluesky-social/atproto/tree/main/lexicons)
  - `com/atproto/` - AT Protocol コア機能
  - `app/bsky/` - Bluesky アプリケーション機能
  - `chat/bsky/` - Bluesky DM 機能
- **仕様書**: [AT Protocol Lexicon 仕様](https://atproto.com/specs/lexicon)

## ディレクトリ構成

- **`core/`**: AT Protocol および Bluesky API のコアライブラリ（`com.atproto.*`、`app.bsky.*`、`chat.bsky.*`）
- **`auth/`**: OAuth 認証機能
- **`stream/`**: リアルタイムイベントストリーミング（`subscribeRepos`）
- **`all/`**: 全モジュールを含むパッケージ
- **`plugins/`**: Gradle ビルド設定

## テスト方法

変更後は必ず以下のテストを実行してください（認証不要）：

```shell
./gradlew core:jvmTest --tests "work.socialhub.kbsky.com.atproto.identity.ResolveHandleTest.testResolveHandle"
```

ネットワークアクセスができない場合は、ビルドの成功を確認：

```shell
./gradlew jvmJar
```

## 実装ガイドライン

### NSID とパッケージ構造の対応

- Lexicon NSID は、パッケージ構造に対応します
- 例: `app.bsky.feed.post` → `core/src/commonMain/kotlin/work/socialhub/kbsky/app/bsky/feed/post/`

### Lexicon との整合性確認

実装時は該当する Lexicon 定義（JSON）と照合してください：

**レコード/型の確認項目：**

- すべてのフィールドが実装されているか
- Lexicon の型（string, integer, boolean, ref, union など）が正しく Kotlin 型にマッピングされているか
- `required` フィールドが non-nullable になっているか
- 制約条件（`maxLength`, `minLength`, `maxGraphemes`, `pattern` など）が実装されているか
- デフォルト値が反映されているか

**XRPC エンドポイントの確認項目：**

- `parameters`（URL パラメータ）が実装されているか
- `input`（リクエストボディ）が実装されているか
- `output`（レスポンス）が実装されているか
- `errors` で定義されたエラーハンドリングが実装されているか

### テスト

- `core/src/jvmTest/kotlin/` にテストクラスを配置
- すべてのフィールドのシリアライズ/デシリアライズをテスト
- バリデーションルールが正しく機能することを確認

## 重要な実装上の注意事項

### chat.bsky（DM 機能）の特別な要件

`chat.bsky.*` の API を実装する際は、以下の点に注意してください：

**認証要件：**

- DM 機能にアクセスするには、「ダイレクトメッセージへのアクセスを許可」スコープを持つアプリパスワードが必要
- 通常のアプリパスワードでは DM API にアクセスできない

**サービスプロキシ：**

- `chat.bsky.*` のエンドポイントは、ユーザーの PDS インスタンスを経由して `did:web:api.bsky.chat` にプロキシされる
- リクエスト時に適切なサービス DID をプロキシヘッダーに設定する必要がある
