package work.socialhub.kbsky.util.facet

object FacetUtil {
    /**
     * Expand the string and expand the elements that can be Facets
     * 文字列を展開して Facets になりえる要素を展開します
     * (公式 Web App を準拠した形で作成しています)
     * (リンクカード等は生成しません)
     *
     * ref: https://github.com/bluesky-social/atproto/blob/main/packages/api/src/rich-text/util.ts
     */
    fun extractFacets(text: String): FacetList {
        val records = mutableListOf<FacetRecord>()
        var str = text

        // メンションの要素を分解
        // (ref そのまだだと、空文字でも認識されてしまう問題があるので先頭を修正し、括弧を追加)
        val mentionRegex = Regex("(?<=^|\\s|\\()((@)([a-zA-Z0-9.-]+))(\\b)")

        // リンクの要素を展開
        // (ref そのまだだと、空文字でも認識されてしまう問題があるので先頭を修正)
        val linkRegex = Regex("(?<=^|\\s|\\()((https?://[\\S]+)|((?<domain>[a-z][a-z0-9]*(\\.[a-z0-9]+)+)[\\S]*))")

        // ハッシュタグの要素を展開
        // (ref そのまだだと、空文字でも認識されてしまう問題があるので先頭を修正し、括弧を追加した上で、# だけでも認識される問題があるので末尾の ? を + に変更)
        val tagRegex =
            Regex("(?<=^|\\s)([#＃]((?!\\ufe0f)[^\\s\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]*[^\\d\\s\\p{P}\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]+[^\\s\\u00AD\\u2060\\u200A\\u200B\\u200C\\u200D\\u20e2]*)+)")

        while (true) {
            val mentionFind = mentionRegex.find(str)
            val linkFind = linkRegex.find(str)
            val tagFind = tagRegex.find(str)

            // いずれも発見できなかった場合は終了
            if (mentionFind == null && linkFind == null && tagFind == null) {
                records.add(FacetRecord(FacetType.Text, str, str))
                break
            }

            // 前の方で発見したものから順次処理を実行
            var start = -1
            var end = -1
            var type: FacetType? = null

            if (mentionFind != null) {
                start = mentionFind.range.first
                end = mentionFind.range.last
                type = FacetType.Mention
            }

            if (linkFind != null) {
                if (start < 0 || linkFind.range.first < start) {
                    start = linkFind.range.first
                    end = linkFind.range.last
                    type = FacetType.Link
                }
            }

            if (tagFind != null) {
                if (start < 0 || tagFind.range.first < start) {
                    start = tagFind.range.first
                    end = tagFind.range.last
                    type = FacetType.Tag
                }
            }

            // 前後の文字列を切り出す
            val before = str.substring(0, start)
            str = str.substring(end + 1)

            // 前の部分について Text として登録
            if (before.isNotEmpty()) {
                records.add(FacetRecord(FacetType.Text, before, before))
            }

            when (type) {
                FacetType.Mention -> records.add(mentionFacet(mentionFind!!.groupValues[1]))
                FacetType.Link -> records.add(linkFacet(linkFind!!.groupValues[1]))
                FacetType.Tag -> records.add(tagFacet(tagFind!!.groupValues[1]))
                else -> throw Exception("unknown type")
            }

            if (str.isEmpty()) {
                break
            }
        }
        return FacetList(records)
    }

    private fun mentionFacet(mention: String): FacetRecord {
        return FacetRecord(FacetType.Mention, mention, mention)
    }

    private fun linkFacet(link: String): FacetRecord {

        // プロトコルの部分のみ削除
        var display = link.replace("(https?://)".toRegex(), "")

        // 文字列長さが 30 を超えた場合は省略
        if (display.length > 30) {
            display = display.substring(0, 27) + "..."
        }
        return FacetRecord(FacetType.Link, link, display)
    }

    private fun tagFacet(tag: String): FacetRecord {
        return FacetRecord(FacetType.Tag, tag, tag)
    }
}
