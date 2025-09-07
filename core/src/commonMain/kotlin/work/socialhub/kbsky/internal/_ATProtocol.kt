package work.socialhub.kbsky.internal

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.api.com.atproto.IdentityResource
import work.socialhub.kbsky.api.com.atproto.ModerationResource
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.com.atproto.ServerResource
import work.socialhub.kbsky.internal.com.atproto._IdentityResource
import work.socialhub.kbsky.internal.com.atproto._ModerationResource
import work.socialhub.kbsky.internal.com.atproto._RepoResource
import work.socialhub.kbsky.internal.com.atproto._ServerResource

open class _ATProtocol(
    config: ATProtocolConfig
) : ATProtocol {

    protected val identity: IdentityResource = _IdentityResource(config)
    protected val server: ServerResource = _ServerResource(config)
    protected val repo: RepoResource = _RepoResource(config)
    protected val moderation: ModerationResource = _ModerationResource(config)

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

    /**
     * {@inheritDoc}
     */
    override fun moderation() = moderation
}
