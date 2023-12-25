package kbsky.stream.util;

public interface WebSocketListener {

    void onConnect();

    void onMessage(String message);

    void onMessage(byte[] data);

    void onDisconnect(int code, String reason);

    void onError(Exception error);
}