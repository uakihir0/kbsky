package kbsky.stream;

import kbsky.model.bsky.actor.ActorDefsProfileView;
import kbsky.model.bsky.embed.EmbedImagesView;
import kbsky.model.bsky.embed.EmbedViewUnion;
import kbsky.model.bsky.feed.FeedDefsPostView;
import kbsky.model.bsky.feed.FeedPost;
import kbsky.model.share.RecordUnion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Map;

public class AbstractTest {

    protected String handle;
    protected String password;
    protected String accessJwt;

    @Before
    public void setupTest() {
        try {
            // Get account handle and password.
            String json = readFile("../secrets.json");
            Map<String, String> props = new Gson().fromJson(json,
                    new TypeToken<Map<String, String>>() {
                    }.getType());

            if (props != null) {
                handle = props.get("handle");
                password = props.get("password");
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

        // restore session.
        readAccessJwt();
    }

    /**
     * Read Access JWT
     */
    public void readAccessJwt() {
        accessJwt = readFile("../jwt.txt");
    }

    /**
     * Save Access JWT
     */
    public void saveAccessJwt() {
        saveFile(accessJwt, "../jwt.txt");
    }

    public void print(String url, RecordUnion record) {
        System.out.println("|RECORD|-----------------------------------------");
        System.out.println("URI> " + url);
        System.out.println("TYPE> " + record.getType());

        if (record instanceof FeedPost) {
            FeedPost feedMain = (FeedPost) record;
            System.out.println("TEXT> " + feedMain.getText());
        }
    }

    public void print(FeedDefsPostView post) {
        System.out.println("|POST|-----------------------------------------");
        System.out.println("URI> " + post.getUri());
        System.out.println("CID> " + post.getCid());

        if (post.getEmbed() != null) {
            EmbedViewUnion embed = post.getEmbed();
            if (embed instanceof EmbedImagesView) {
                System.out.println("ImageURL> " +
                        ((EmbedImagesView) embed)
                                .getImages().get(0).getFullsize());
            }
        }

        RecordUnion record = post.getRecord();
        if (record instanceof FeedPost) {
            FeedPost feedMain = (FeedPost) record;
            System.out.println("TEXT> " + feedMain.getText());
        }
    }

    public void print(ActorDefsProfileView user) {
        System.out.println("|USER|-----------------------------------------");
        System.out.println("DID> " + user.getDid());
        System.out.println("HANDLE> " + user.getHandle());
        System.out.println("NAME> " + user.getDisplayName());
    }

    /**
     * Read File
     */
    private String readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder b = new StringBuilder();

            String line;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                b.append(line);
                b.append(ls);
            }

            b.deleteCharAt(b.length() - 1);
            br.close();

            return b.toString();

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Save File
     */
    private void saveFile(String str, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * File to ImageBytes
     */
    public static byte[] convertFile(InputStream stream) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = stream.read(buffer)) != -1) {
                bout.write(buffer, 0, len);
            }
            return bout.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
