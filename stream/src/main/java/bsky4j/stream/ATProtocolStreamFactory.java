package kbsky.stream;

import kbsky.stream.internal.atproto._ATProtocolStream;

public class ATProtocolStreamFactory {

    public static ATProtocolStream getInstance(String uri) {
        return new _ATProtocolStream(uri);
    }
}
