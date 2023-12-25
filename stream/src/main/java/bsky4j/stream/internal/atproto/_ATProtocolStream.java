package kbsky.stream.internal.atproto;

import kbsky.ATProtocol;
import kbsky.internal._ATProtocol;
import kbsky.stream.ATProtocolStream;
import kbsky.stream.api.atproto.SyncResource;

public class _ATProtocolStream implements ATProtocolStream {


    private final ATProtocol atproto;

    protected final SyncResource sync;

    public _ATProtocolStream(String uri) {
        this.atproto = new _ATProtocol(uri);
        this.sync = new _SyncResource(this.atproto, uri);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SyncResource sync() {
        return sync;
    }

}
