package work.socialhub.kbsky

import work.socialhub.kbsky.internal._PLCDirectory

object PLCDirectoryFactory {
    fun instance(): PLCDirectory {
        return _PLCDirectory("https://plc.directory/")
    }

    fun instance(uri: String): PLCDirectory {
        return _PLCDirectory(uri)
    }
}
