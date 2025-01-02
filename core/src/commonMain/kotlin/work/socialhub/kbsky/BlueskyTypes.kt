package work.socialhub.kbsky

/**
 * Bluesky/ATProtocol
 * https://atproto.com/docs
 */
object BlueskyTypes {

    /// ----------------------------------------------------------------------- ///
    /// APP.BSKY
    /// ----------------------------------------------------------------------- ///

    // Actor
    const val ActorDefs = "app.bsky.actor.defs"
    const val ActorProfile = "app.bsky.actor.profile"
    const val ActorGetProfile = "app.bsky.actor.getProfile"
    const val ActorGetProfiles = "app.bsky.actor.getProfiles"
    const val ActorGetPreferences = "app.bsky.actor.getPreferences"
    const val ActorGetSuggestions = "app.bsky.actor.getSuggestions"
    const val ActorSearchActors = "app.bsky.actor.searchActors"
    const val ActorSearchActorsTypeahead = "app.bsky.actor.searchActorsTypeahead"

    // Embed
    const val EmbedExternal = "app.bsky.embed.external"
    const val EmbedImages = "app.bsky.embed.images"
    const val EmbedVideo = "app.bsky.embed.video"
    const val EmbedRecord = "app.bsky.embed.record"
    const val EmbedRecordWithMedia = "app.bsky.embed.recordWithMedia"

    // Feed
    const val FeedDefs = "app.bsky.feed.defs"
    const val FeedGetAuthorFeed = "app.bsky.feed.getAuthorFeed"
    const val FeedGetLikes = "app.bsky.feed.getLikes"
    const val FeedGetPostThread = "app.bsky.feed.getPostThread"
    const val FeedGetPosts = "app.bsky.feed.getPosts"
    const val FeedGetQuotes = "app.bsky.feed.getQuotes"
    const val FeedGetRepostedBy = "app.bsky.feed.getRepostedBy"
    const val FeedGetTimeline = "app.bsky.feed.getTimeline"
    const val FeedLike = "app.bsky.feed.like"
    const val FeedPost = "app.bsky.feed.post"
    const val FeedRepost = "app.bsky.feed.repost"
    const val FeedGetFeed = "app.bsky.feed.getFeed"
    const val FeedGetListFeed = "app.bsky.feed.getListFeed"
    const val FeedGetActorFeeds = "app.bsky.feed.getActorFeeds"
    const val FeedGetActorLikes = "app.bsky.feed.getActorLikes"
    const val FeedGetFeedSearchPosts = "app.bsky.feed.searchPosts"
    const val FeedGetFeedGenerator = "app.bsky.feed.getFeedGenerator"
    const val FeedGetFeedGenerators = "app.bsky.feed.getFeedGenerators"
    const val FeedThreadgate = "app.bsky.feed.threadgate"
    const val FeedPostgate = "app.bsky.feed.postgate"

    // Graph
    const val GraphDefs = "app.bsky.graph.defs"
    const val GraphFollow = "app.bsky.graph.follow"
    const val GraphGetFollowers = "app.bsky.graph.getFollowers"
    const val GraphGetFollows = "app.bsky.graph.getFollows"
    const val GraphGetKnownFollowers = "app.bsky.graph.getKnownFollowers"
    const val GraphGetMutes = "app.bsky.graph.getMutes"
    const val GraphMuteActor = "app.bsky.graph.muteActor"
    const val GraphUnmuteActor = "app.bsky.graph.unmuteActor"
    const val GraphBlock = "app.bsky.graph.block"
    const val GraphGetBlocks = "app.bsky.graph.getBlocks"
    const val GraphGetList = "app.bsky.graph.getList"
    const val GraphGetLists = "app.bsky.graph.getLists"
    const val GraphList = "app.bsky.graph.list"
    const val GraphListItem = "app.bsky.graph.listitem"
    const val GraphGetStarterPack = "app.bsky.graph.getStarterPack"
    const val GraphGetStarterPacks = "app.bsky.graph.getStarterPacks"
    const val GraphStarterPack = "app.bsky.graph.starterpack"


    // Labeler
    const val LabelerDefs = "app.bsky.labeler.defs"
    const val LabelerGetServices = "app.bsky.labeler.getServices"

    // Notification
    const val NotificationGetUnreadCount = "app.bsky.notification.getUnreadCount"
    const val NotificationListNotifications = "app.bsky.notification.listNotifications"
    const val NotificationUpdateSeen = "app.bsky.notification.updateSeen"

    // RichText
    const val RichtextFacet = "app.bsky.richtext.facet"

    // Unspecced
    const val UnspeccedGetPopular = "app.bsky.unspecced.getPopular"

    // Video
    const val VideoGetJobStatus = "app.bsky.video.getJobStatus"
    const val VideoGetUploadLimits = "app.bsky.video.getUploadLimits"
    const val VideoUploadVideo = "app.bsky.video.uploadVideo"

    /// ----------------------------------------------------------------------- ///
    /// CHAT.BSKY
    /// ----------------------------------------------------------------------- ///

    // Convo
    const val ConvoDefs = "chat.bsky.convo.defs"
    const val ConvoDeleteMessageForSelf = "chat.bsky.convo.deleteMessageForSelf"
    const val ConvoGetConvo = "chat.bsky.convo.getConvo"
    const val ConvoGetConvoForMembers = "chat.bsky.convo.getConvoForMembers"
    const val ConvoGetLog = "chat.bsky.convo.getLog"
    const val ConvoGetMessages = "chat.bsky.convo.getMessages"
    const val ConvoLeaveConvo = "chat.bsky.convo.leaveConvo"
    const val ConvoListConvos = "chat.bsky.convo.listConvos"
    const val ConvoMuteConvo = "chat.bsky.convo.muteConvo"
    const val ConvoSendMessage = "chat.bsky.convo.sendMessage"
    const val ConvoSendMessageBatch = "chat.bsky.convo.sendMessageBatch"
    const val ConvoUnmuteConvo = "chat.bsky.convo.unmuteConvo"
    const val ConvoUpdateRead = "chat.bsky.convo.updateRead"
}
