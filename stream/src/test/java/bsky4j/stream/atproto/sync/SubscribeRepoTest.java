package kbsky.stream.atproto.sync;

import kbsky.domain.Service;
import kbsky.stream.ATProtocolStreamFactory;
import kbsky.stream.AbstractTest;
import kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest;
import kbsky.stream.util.StreamClient;
import net.socialhub.logger.Logger;
import org.junit.Test;

public class SubscribeRepoTest extends AbstractTest {

    @Test
    public void testSubscribeRepo() {
        Logger.getLogger(null).setLogLevel(Logger.LogLevel.WARN);

        try {
            StreamClient stream = ATProtocolStreamFactory
                    .getInstance(Service.BSKY_SOCIAL.getUri())
                    .sync().subscribeRepos(
                            SyncSubscribeReposRequest
                                    .builder()
                                    .build()
                    );

            stream.setEventCallback((cid, url, record) -> {
                print(url, record);
            });

            stream.connect();
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
