package work.socialhub.kbsky

import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.model.plc.DIDLog

interface PLCDirectory {
    fun DIDDetails(did: String): Response<DIDDetails>
    fun DIDLogs(did: String): Response<List<DIDLog>>
}
