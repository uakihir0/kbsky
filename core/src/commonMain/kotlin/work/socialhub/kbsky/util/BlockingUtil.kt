package work.socialhub.kbsky.util

import kotlinx.coroutines.CoroutineScope

expect fun <T> toBlocking(block: suspend CoroutineScope.() -> T): T