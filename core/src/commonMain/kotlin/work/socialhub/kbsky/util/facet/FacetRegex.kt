package work.socialhub.kbsky.util.facet

/**
 * プラットフォーム別のハッシュタグ正規表現を提供
 *
 * iOSとJVMで正規表現エンジンの動作が異なるため、
 * expect/actualでプラットフォーム別の実装を提供します。
 */
internal expect fun getTagRegex(): Regex
