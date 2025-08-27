package work.socialhub.kbsky

import work.socialhub.kbsky.api.com.atproto.IdentityResource
import work.socialhub.kbsky.api.com.atproto.ModerationResource
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.com.atproto.ServerResource

interface ATProtocol {
    fun identity(): IdentityResource
    fun server(): ServerResource
    fun repo(): RepoResource
    fun moderation(): ModerationResource
}
