package work.socialhub.kbsky.util.facet

/**
 * JVM用のハッシュタグ正規表現
 */
internal actual fun getTagRegex(): Regex {
    // (ref そのまだだと、空文字でも認識されてしまう問題があるので先頭を修正し、括弧を追加した上で、# だけでも認識される問題があるので末尾の ? を + に変更)
    return Regex("(?<=^|\\s)([#＃]((?!\\ufe0f)[^\\s\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]*[^\\d\\s\\p{P}\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]+[^\\s\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]*)+)")
}
