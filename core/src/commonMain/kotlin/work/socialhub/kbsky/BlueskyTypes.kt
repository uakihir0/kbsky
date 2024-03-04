package work.socialhub.kbsky

/**
 * Bluesky/ATProtocol
 * https://atproto.com/docs
 */
object BlueskyTypes {

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
    const val EmbedRecord = "app.bsky.embed.record"
    const val EmbedRecordWithMedia = "app.bsky.embed.recordWithMedia"

    // Feed
    const val FeedDefs = "app.bsky.feed.defs"
    const val FeedGetAuthorFeed = "app.bsky.feed.getAuthorFeed"
    const val FeedGetLikes = "app.bsky.feed.getLikes"
    const val FeedGetPostThread = "app.bsky.feed.getPostThread"
    const val FeedGetPosts = "app.bsky.feed.getPosts"
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

    // Graph
    const val GraphDefs = "app.bsky.graph.defs"
    const val GraphFollow = "app.bsky.graph.follow"
    const val GraphGetFollowers = "app.bsky.graph.getFollowers"
    const val GraphGetFollows = "app.bsky.graph.getFollows"
    const val GraphGetMutes = "app.bsky.graph.getMutes"
    const val GraphMuteActor = "app.bsky.graph.muteActor"
    const val GraphUnmuteActor = "app.bsky.graph.unmuteActor"
    const val GraphBlock = "app.bsky.graph.block"
    const val GraphGetBlocks = "app.bsky.graph.getBlocks"
    const val GraphGetList = "app.bsky.graph.getList"
    const val GraphGetLists = "app.bsky.graph.getLists"
    const val GraphList = "app.bsky.graph.list"
    const val GraphListItem = "app.bsky.graph.listitem"

    // Notification
    const val NotificationGetUnreadCount = "app.bsky.notification.getUnreadCount"
    const val NotificationListNotifications = "app.bsky.notification.listNotifications"
    const val NotificationUpdateSeen = "app.bsky.notification.updateSeen"

    // RichText
    const val RichtextFacet = "app.bsky.richtext.facet"

    // Unspecced
    const val UnspeccedGetPopular = "app.bsky.unspecced.getPopular"
}
