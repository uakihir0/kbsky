# kbsky SPM

This repository is the Swift Package repository for [kbsky].
[kbsky] is a Bluesky/ATProtocol client library built using Kotlin Multiplatform.
As a result, it can be built and used on Apple devices such as iOS.
Here, we distribute the library built as an XCFramework via Swift Package.
Additionally, this repository is automatically committed to via GitHub Actions from [kbsky].
Please direct any issues or pull requests to [kbsky].

## Usage

This repository does not have its own versioning.
Instead, branches corresponding to the versions of [kbsky] are provided.
To use a specific version of [kbsky], specify the corresponding branch of this repository.
Check the [list of branches](https://github.com/uakihir0/kbsky-spm/branches) to find the branch matching your desired version.

### How to Make Requests

Although it is also usable from Objective-C, below is an example of how to use it in Swift.
For more detailed usage instructions, please refer to the [kbsky] README.

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
