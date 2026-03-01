package work.socialhub.kbsky.internal

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.api.com.atproto.IdentityResource
import work.socialhub.kbsky.api.com.atproto.ModerationResource
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.com.atproto.ServerResource
import work.socialhub.kbsky.internal.com.atproto.IdentityResourceImpl
import work.socialhub.kbsky.internal.com.atproto.ModerationResourceImpl
import work.socialhub.kbsky.internal.com.atproto.RepoResourceImpl
import work.socialhub.kbsky.internal.com.atproto.ServerResourceImpl

open class ATProtocolImpl(
    config: ATProtocolConfig
) : ATProtocol {

    protected val identity: IdentityResource = IdentityResourceImpl(config)
    protected val server: ServerResource = ServerResourceImpl(config)
    protected val repo: RepoResource = RepoResourceImpl(config)
    protected val moderation: ModerationResource = ModerationResourceImpl(config)

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
