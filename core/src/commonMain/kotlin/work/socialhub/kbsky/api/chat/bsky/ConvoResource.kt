package work.socialhub.kbsky.api.chat.bsky

import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoForMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoForMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetLogRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetLogResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoLeaveConvoRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoLeaveConvoResponse
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoListConvosRequest
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoListConvosResponse
import work.socialhub.kbsky.api.entity.share.Response

interface ConvoResource {

    /**
     *
     */
    fun getConvo(
        request: ConvoGetConvoRequest
    ): Response<ConvoGetConvoResponse>

    /**
     *
     */
    fun getConvoForMembers(
        request: ConvoGetConvoForMembersRequest
    ): Response<ConvoGetConvoForMembersResponse>

    /**
     *
     */
    fun getLog(
        request: ConvoGetLogRequest
    ): Response<ConvoGetLogResponse>

    fun leaveConvo(
        request: ConvoLeaveConvoRequest
    ): Response<ConvoLeaveConvoResponse>

    fun listConvos(
        request: ConvoListConvosRequest
    ): Response<ConvoListConvosResponse>
}