package exercise1;

import java.io.IOException;
import java.net.Socket;

public class SocketConnector {
    private Socket socket;
    private final String host = "localhost";
    private final int port = 2333;

    public Socket getSocket() {
        return socket;
    }

    public void connectSocket() throws IOException{
        socket = new Socket(host, port);
    }

    public SocketConnector() {
        while(true) {
            try {
                connectSocket();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
