package work.socialhub.kbsky

/**
 * ATProtocol
 * https://atproto.com/docs
 */
object ATProtocolTypes {

    // Admin
    const val AdminGetModerationAction = "com.atproto.admin.getModerationAction"
    const val AdminGetModerationActions = "com.atproto.admin.getModerationActions"
    const val AdminGetModerationReport = "com.atproto.admin.getModerationReport"
    const val AdminGetModerationReports = "com.atproto.admin.getModerationReports"
    const val AdminGetRecord = "com.atproto.admin.getRecord"
    const val AdminGetRepo = "com.atproto.admin.getRepo"
    const val AdminResolveModerationReports = "com.atproto.admin.resolveModerationReports"
    const val AdminReverseModerationAction = "com.atproto.admin.reverseModerationAction"
    const val AdminSearchRepos = "com.atproto.admin.searchRepos"
    const val AdminTakeModerationAction = "com.atproto.admin.takeModerationAction"

    // Identify
    const val IdentifyResolveHandle = "com.atproto.identity.resolveHandle"
    const val IdentifyUpdateHandle = "com.atproto.identity.updateHandle"

    // Moderation
    const val ModerationCreateReport = "com.atproto.moderation.createReport"

    // Repo
    const val RepoApplyWrites = "com.atproto.repo.applyWrites"
    const val RepoCreateRecord = "com.atproto.repo.createRecord"
    const val RepoDeleteRecord = "com.atproto.repo.deleteRecord"
    const val RepoDescribeRepo = "com.atproto.repo.describeRepo"
    const val RepoGetRecord = "com.atproto.repo.getRecord"
    const val RepoListRecords = "com.atproto.repo.listRecords"
    const val RepoPutRecord = "com.atproto.repo.putRecord"
    const val RepoUploadBlob = "com.atproto.repo.uploadBlob"

    // Server
    const val ServerCreateAccount = "com.atproto.server.createAccount"
    const val ServerCreateInviteCode = "com.atproto.server.createInviteCode"
    const val ServerCreateSession = "com.atproto.server.createSession"
    const val ServerDeleteAccount = "com.atproto.server.deleteAccount"
    const val ServerDeleteSession = "com.atproto.server.deleteSession"
    const val ServerDescribeServer = "com.atproto.server.describeServer"
    const val ServerGetSession = "com.atproto.server.getSession"
    const val ServerRefreshSession = "com.atproto.server.refreshSession"
    const val ServerRequestAccountDelete = "com.atproto.server.requestAccountDelete"
    const val ServerRequestPasswordReset = "com.atproto.server.requestPasswordReset"
    const val ServerResetPassword = "com.atproto.server.resetPassword"

    // Sync
    const val SyncGetBlob = "com.atproto.sync.getBlob"
    const val SyncGetBlocks = "com.atproto.sync.getBlocks"
    const val SyncGetCheckout = "com.atproto.sync.getCheckout"
    const val SyncGetCommitPath = "com.atproto.sync.getCommitPath"
    const val SyncGetHead = "com.atproto.sync.getHead"
    const val SyncGetRecord = "com.atproto.sync.getRecord"
    const val SyncGetRepo = "com.atproto.sync.getRepo"
    const val SyncListBlobs = "com.atproto.sync.listBlobs"
    const val SyncNotifyOfUpdate = "com.atproto.sync.notifyOfUpdate"
    const val SyncRequestCrawl = "com.atproto.sync.requestCrawl"
    const val SyncSubscribeRepos = "com.atproto.sync.subscribeRepos"
}
