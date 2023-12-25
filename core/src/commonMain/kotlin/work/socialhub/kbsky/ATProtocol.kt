package work.socialhub.kbsky

import work.socialhub.kbsky.api.atproto.IdentityResource
import work.socialhub.kbsky.api.atproto.RepoResource
import work.socialhub.kbsky.api.atproto.ServerResource

interface ATProtocol {
    fun identity(): IdentityResource
    fun server(): ServerResource
    fun repo(): RepoResource
}
