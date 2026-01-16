package work.socialhub.kbsky.util

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

data class DateFormatter(
    val format: String,
    val timezone: TimeZone,
) {

    @OptIn(ExperimentalTime::class)
    fun format(instant: Instant): String {
        val local = instant.toLocalDateTime(timezone)
        val date = local.date

        val year = date.year
        val day = date.day
        val month = date.month.ordinal + 1

        val hour = local.hour
        val minute = local.minute
        val second = local.second
        val millisecond = local.nanosecond / 1000000

        return format
            .replace("yyyy", year.toString())
            .replace("MM", month.zeroPrefixed(2))
            .replace("M", month.toString())
            .replace("dd", day.zeroPrefixed(2))
            .replace("d", day.toString())
            .replace("HH", hour.zeroPrefixed(2))
            .replace("H", hour.toString())
            .replace("mm", minute.zeroPrefixed(2))
            .replace("m", minute.toString())
            .replace("ss", second.zeroPrefixed(2))
            .replace("s", second.toString())
            .replace("SSS", millisecond.zeroPrefixed(3))
            .replace("S", millisecond.toString())
    }

    private fun Int.zeroPrefixed(
        maxLength: Int,
    ): String {
        if (this < 0 || maxLength < 1) return ""

        val string = this.toString()
        val currentStringLength = string.length
        return if (maxLength <= currentStringLength) {
            string

        } else {
            val diff = maxLength - currentStringLength
            var prefixedZeros = ""
            repeat(diff) {
                prefixedZeros += "0"
            }
            "$prefixedZeros$string"
        }
    }
}


