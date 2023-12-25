package work.socialhub.kbsky.internal

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.api.atproto.IdentityResource
import work.socialhub.kbsky.api.atproto.RepoResource
import work.socialhub.kbsky.api.atproto.ServerResource
import work.socialhub.kbsky.internal.atproto._IdentityResource
import work.socialhub.kbsky.internal.atproto._RepoResource
import work.socialhub.kbsky.internal.atproto._ServerResource

open class _ATProtocol(uri: String) : ATProtocol {

    protected val identity: IdentityResource
    protected val server: ServerResource
    protected val repo: RepoResource

    init {
        identity = _IdentityResource(uri)
        server = _ServerResource(uri)
        repo = _RepoResource(uri)
    }

    /**
     * {@inheritDoc}
     */
    override fun identity() = identity

    /**
     * {@inheritDoc}
     */
    override fun server() = server

    /**
     * {@inheritDoc}
     */
    override fun repo() = repo
}
