package kbsky.stream;

import kbsky.stream.api.atproto.SyncResource;

public interface ATProtocolStream {

    SyncResource sync();
}
