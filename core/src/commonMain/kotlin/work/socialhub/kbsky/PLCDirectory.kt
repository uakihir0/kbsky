package work.socialhub.kbsky


import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.model.plc.DIDLog
import kotlin.js.JsExport

@JsExport
interface PLCDirectory {

    suspend fun DIDDetails(did: String): Response<DIDDetails>

    @JsExport.Ignore
    fun DIDDetailsBlocking(did: String): Response<DIDDetails>

    suspend fun DIDLogs(did: String): Response<List<DIDLog>>

    @JsExport.Ignore
    fun DIDLogsBlocking(did: String): Response<List<DIDLog>>
}
