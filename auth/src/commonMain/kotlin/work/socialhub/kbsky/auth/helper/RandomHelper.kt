package work.socialhub.kbsky.auth.helper

object RandomHelper {

    fun random(len: Int): String {
        val lists = ('a'..'z') + ('0'..'9')
        return (1..len)
            .map { lists.random() }
            .joinToString("")
    }
}