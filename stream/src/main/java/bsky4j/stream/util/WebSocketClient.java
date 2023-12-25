package kbsky.stream.util;


import net.socialhub.logger.Logger;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebSocketClient {

    private static final Logger logger = Logger.getLogger(WebSocketClient.class);

    private final URI mURI;
    private Socket mSocket;
    private Thread mThread;
    private final HybiParser mParser;
    private final WebSocketListener mListener;
    private final ExecutorService mService;

    private final Object mSendLock = new Object();

    public WebSocketClient(URI uri, WebSocketListener listener) {
        mURI = uri;
        mListener = listener;
        mParser = new HybiParser(this);
        mService = Executors.newSingleThreadExecutor();
    }

    public WebSocketListener getListener() {
        return mListener;
    }

    public void connect() {
        if (mThread != null && mThread.isAlive()) {
            return;
        }

        mThread = new Thread(() -> {
            try {
                String secret = createSecret();
                logger.debug("Secret: " + secret);

                String path = isEmpty(mURI.getPath()) ? "/" : mURI.getPath();
                if (!isEmpty(mURI.getQuery())) {
                    path += "?" + mURI.getQuery();
                }

                String originScheme = mURI.getScheme().equals("wss") ? "https" : "http";
                URI origin = new URI(originScheme, "//" + mURI.getHost(), null);

                SocketFactory factory = mURI.getScheme().equals("wss") ? getSSLSocketFactory() : SocketFactory.getDefault();
                mSocket = factory.createSocket(mURI.getHost(), getPort());

                PrintWriter out = new PrintWriter(mSocket.getOutputStream());
                writeRN(out, "GET " + path + " HTTP/1.1");
                writeRN(out, "Upgrade: websocket");
                writeRN(out, "Connection: Upgrade");
                writeRN(out, "Host: " + mURI.getHost());
                writeRN(out, "Origin: " + origin);
                writeRN(out, "Sec-WebSocket-Key: " + secret);
                writeRN(out, "Sec-WebSocket-Version: 13");
                writeRN(out, "");
                out.flush();

                HybiParser.HappyDataInputStream stream =
                        new HybiParser.HappyDataInputStream(mSocket.getInputStream());

                // Read HTTP response status line.
                String status = readLine(stream);
                logger.debug(status);

                // Read HTTP response headers.
                String line;
                while (!isEmpty(line = readLine(stream))) {
                    logger.debug(line);
                }

                mListener.onConnect();

                // Now decode websocket frames.
                mParser.start(stream);

            } catch (EOFException ex) {
                logger.debug("WebSocket EOF!", ex);
                mListener.onDisconnect(0, "EOF");

            } catch (SSLException ex) {
                // Connection reset by peer
                logger.debug("Websocket SSL error!", ex);
                mListener.onDisconnect(0, "SSL");

            } catch (Exception ex) {
                mListener.onError(ex);
                mListener.onDisconnect(0, "UNEXPECTED");
            }
        });
        mThread.start();
    }

    private int getPort() {
        return (mURI.getPort() != -1) ? mURI.getPort() :
                (mURI.getScheme().equals("wss") ? 443 : 80);
    }

    public void disconnect() {
        if (mSocket != null) {
            mService.submit(() -> {
                try {
                    mSocket.close();
                    mSocket = null;
                } catch (IOException ex) {
                    logger.debug("Error while disconnecting", ex);
                    mListener.onError(ex);
                }
            });
        }
    }

    public void send(String data) {
        sendFrame(mParser.frame(data));
    }

    public void send(byte[] data) {
        sendFrame(mParser.frame(data));
    }

    public void sendPing() {
        sendFrame(mParser.pingFrame());
    }

    // Can't use BufferedReader because it buffers past the HTTP data.
    private String readLine(HybiParser.HappyDataInputStream reader) throws IOException {
        int readChar = reader.read();
        if (readChar == -1) {
            return null;
        }
        StringBuilder string = new StringBuilder();
        while (readChar != '\n') {
            if (readChar != '\r') {
                string.append((char) readChar);
            }

            readChar = reader.read();
            if (readChar == -1) {
                return null;
            }
        }
        return string.toString();
    }

    private String createSecret() {
        byte[] nonce = new byte[16];
        for (int i = 0; i < 16; i++) {
            nonce[i] = (byte) (Math.random() * 256);
        }
        return Base64.getEncoder().encodeToString(nonce).trim();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private void writeRN(PrintWriter writer, String line) {
        logger.debug(line);
        writer.print(line + "\r\n");
    }

    void sendFrame(final byte[] frame) {
        mService.submit(() -> {
            try {
                synchronized (mSendLock) {
                    if (mSocket == null) {
                        throw new IllegalStateException("Socket not connected");
                    }
                    OutputStream outputStream = mSocket.getOutputStream();
                    outputStream.write(frame);
                    outputStream.flush();
                }
            } catch (IOException e) {
                mListener.onError(e);
            }
        });
    }

    private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);
        return context.getSocketFactory();
    }
}