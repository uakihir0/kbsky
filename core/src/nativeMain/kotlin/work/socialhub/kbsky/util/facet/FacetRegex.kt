package work.socialhub.kbsky.util.facet

/**
 * Native用のハッシュタグ正規表現
 *
 * Kotlin/Nativeの正規表現エンジンでは、#と＃を明示的に文字クラスから除外し、
 * シンプルなパターンを使用することで正しく動作します。
 * (iOS, macOS, Windows, Linux すべてのNativeターゲットで使用)
 */
internal actual fun getTagRegex(): Regex {
    // Native用の調整された正規表現
    // - #＃とスペースを文字クラスから除外
    // - 数字のみのハッシュタグを除外するため、数字以外の文字が最低1文字必要
    // - 先読みで区切り文字を確認
    return Regex("(?<=^|\\s)([#＃](?!\\ufe0f)(?=.*[^\\d#＃\\s])[^#＃\\s]+)(?=\\s|$)")
}
