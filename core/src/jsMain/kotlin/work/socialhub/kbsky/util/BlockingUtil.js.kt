package work.socialhub.kbsky.util

import kotlinx.coroutines.CoroutineScope

actual fun <T> toBlocking(block: suspend CoroutineScope.() -> T): T {
    throw UnsupportedOperationException(
        "Blocking operations are not supported in JavaScript. " +
                "Please use suspend functions or Promise-based APIs instead."
    )
}

