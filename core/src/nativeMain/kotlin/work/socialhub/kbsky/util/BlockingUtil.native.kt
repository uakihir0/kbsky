package work.socialhub.kbsky.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun <T> toBlocking(block: suspend CoroutineScope.() -> T): T {
    return runBlocking {
        block()
    }
}