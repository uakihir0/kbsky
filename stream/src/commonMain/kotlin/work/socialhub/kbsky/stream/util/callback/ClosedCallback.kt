package work.socialhub.kbsky.stream.util.callback

interface ClosedCallback {
    fun onClosed(remote: Boolean)
}
