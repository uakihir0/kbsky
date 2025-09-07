package work.socialhub.kbsky.model.com.atproto.moderation

/**
 * モデレーションレポートの理由タイプ定数
 */
object ModerationReasonType {
    /** スパム: 頻繁な不要な宣伝、返信、メンション */
    const val SPAM = "com.atproto.moderation.defs#reasonSpam"
    
    /** 規約違反: サーバールール、法律、利用規約の直接的な違反 */
    const val VIOLATION = "com.atproto.moderation.defs#reasonViolation"
    
    /** 誤解を招く内容: 誤解を招くアイデンティティ、所属、またはコンテンツ */
    const val MISLEADING = "com.atproto.moderation.defs#reasonMisleading"
    
    /** 性的コンテンツ: 不要または誤表示された性的コンテンツ */
    const val SEXUAL = "com.atproto.moderation.defs#reasonSexual"
    
    /** 失礼な行為: ハラスメント、露骨な、または歓迎されない行動 */
    const val RUDE = "com.atproto.moderation.defs#reasonRude"
    
    /** その他: 他のカテゴリに該当しないレポート */
    const val OTHER = "com.atproto.moderation.defs#reasonOther"
    
    /** 異議申し立て: 以前に取られたモデレーション行動への異議申し立て */
    const val APPEAL = "com.atproto.moderation.defs#reasonAppeal"
}