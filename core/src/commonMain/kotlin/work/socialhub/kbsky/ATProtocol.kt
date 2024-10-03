package work.socialhub.kbsky

import work.socialhub.kbsky.api.com.atproto.IdentityResource
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.com.atproto.ServerResource
import work.socialhub.kbsky.api.meta.MetaResource

interface ATProtocol {
    fun identity(): IdentityResource
    fun server(): ServerResource
    fun repo(): RepoResource

    fun meta(): MetaResource
}
