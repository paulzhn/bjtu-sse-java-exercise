package exercise1;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

public class RemoteReader {
    Socket socket;
    PrintStream serverOut;
    BufferedReader serverIn;

    public RemoteReader(Socket socket) {
        this.socket = socket;
    }


}
