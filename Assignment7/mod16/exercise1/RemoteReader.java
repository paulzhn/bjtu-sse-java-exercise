package exercise1;

import java.io.*;
import java.net.Socket;

public class RemoteReader implements Runnable {
    private Listener listener;
    Socket socket;
    PrintStream serverOut;
    BufferedReader serverIn;

    public RemoteReader(Socket socket, Listener listener) {
        this.socket = socket;
        this.listener = listener;
    }

    private void listen() {
        String temp;
        try {
            serverIn = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            serverOut = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if ((temp = serverIn.readLine()) != null) {
                    listener.onListen(temp);
                    temp = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void sendMsg(String message) {
        serverOut.print(message + "\n");
    }

    @Override
    public void run() {
        listen();
    }
}
