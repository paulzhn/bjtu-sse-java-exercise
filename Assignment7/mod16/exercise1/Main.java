package exercise1;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        SocketConnector connector = new SocketConnector();
        Socket socket = connector.getSocket();
        new ChatClient();

    }
}
