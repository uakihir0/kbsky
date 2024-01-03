> [日本語](./README_ja.md)

# kbsky cocoapods

This repository is the Cocoapods repository for [kbsky].
[kbsky] is a Bluesky/ATProtocol client library created using Kotlin Multiplatform.
Therefore, it can be built and used on Apple devices such as iOS. Here,
we distribute the library built as an XCFramework via Cocoapods.
Also, this repository is automatically committed by [kbsky]'s GitHub Actions,
so please send issues and pull requests to [kbsky].

## Usage

### Podfile

Please add the following lines to your Podfile.
There is no specific version for this repository,
and it corresponds to the branch that matches the version of [kbsky].
The version to use is determined by specifying the branch of this repository.
Check the [Branch List](https://github.com/uakihir0/kbsky-cocoapods/branches)
for the branch corresponding to your version.
Additionally, different dependencies are used for Debug and Release builds.

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

### Request Example

While it can be used in Objective-C as well,
here is an example of usage in Swift.
For more detailed instructions, please refer to the README of [kbsky].

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

## License

MIT License

## Author

[Akihiro Urushihara](https://github.com/uakihir0)

[kbsky]: https://github.com/uakihir0/kbsky