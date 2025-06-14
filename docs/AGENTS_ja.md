# エージェント向け資料

## テスト方法

基本的に SNS のクライアントライブラリになるので、テストにはユーザーアカウントが必要になります。ただし、いくつかのエンドポイントではユーザーアカウントが不要でも試せるテストがあるので、ビルドの確認と基本的な部分が壊れていないかを確認するため、以下のテストは実行するようにしてください。

```shell
./gradlew core:jvmTest --tests "work.socialhub.kbsky.com.atproto.identity.ResolveHandleTest.testResolveHandle"
```

Bluesky のサーバーにアクセス出来ない場合は、ビルドができることを確認してください。JVM 環境では以下でコンパイルの確認ができます。

```shell
./gradlew jvmJar
```