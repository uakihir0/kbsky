# kbsky cocoapods

本レポジトリは、[kbsky] の Cocoapods レポジトリです。[kbsky] は Kotlin Multiplatform を用いて作成された Bluesky/ATProtocol クライアントライブラリです。
そのため、iOS 等の Apple Device でも使用でもビルドして使用することができます。ここでは、XCFramework としてビルドしたものを Cocoapods 経由で配布しています。
また、このレポジトリは [kbsky] の GitHub Actions によって自動コミットされています。issue や pull request は [kbsky] にお願いします。

## 使用方法

### Podfile

Podfile に以下のように記載してください。
本レポジトリにはバージョンは存在せず、[kbsky] のバージョンと一致するブランチが存在します。
どのバージョンの [kbsky] を使用するかは、本レポジトリのブランチを指定することで決定します。
[ブランチ一覧](https://github.com/uakihir0/kbsky-cocoapods/branches) からバージョンに対応するブランチを確認してください。
また、Debug ビルドと Release ビルドでは異なるものを使用しています。

```ruby
target '{{PROJECT_NAME}}' do
  use_frameworks!

  # Pods for kbsky
  pod 'kbsky-debug', 
    :configuration => ['Debug'], 
    :git => 'https://github.com/uakihir0/kbsky-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  pod 'kbsky-release', 
    :configuration => ['Release'], 
    :git => 'https://github.com/uakihir0/kbsky-cocoapods/', 
    :branch => '{{BRANCH_NAME}}'
  ...
end
```

### リクエスト方法

Objective-C でも使用可能ですが、以下に Swift での使用方法を記載します。
詳しい使い方については、[kbsky] の README も合わせて確認してください。

```swift
let response = BskyFactory()
  .atproto(apiUri: "https://bsky.social/")
  .repo()
  .getRecord(request:
    CoreRepoGetRecordRequest(
      repo: "uakihir0.com",
      collection: "app.bsky.feed.post",
      rkey: nil,
      uri: "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jqcyfp3zt22s"
    )
  )

print(response.data?.uri ?? "nil") 
```

## ライセンス

MIT License

## 作者

[Akihiro Urushihara](https://github.com/uakihir0)


[kbsky]: https://github.com/uakihir0/kbsky