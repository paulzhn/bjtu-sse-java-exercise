// ReadFile.java
// TCP/IP simple client that reads a file on the server  
// Accepts at least one argument, the name of a file on 
// the server to read. Opens a connection with the server 
// and displays the resultant file or an error result

import java.awt.*;
import java.net.*;
import java.io.*;

// This is the lab template. 
// Fill in the code for the two methods called from main

class ReadFile {

  // This method will send the file name to read to the 
  // server. You need to set up your own data output 
  // stream to pass the filename to the server (which 
  // should be reading a data input stream and expecting 
  // a string).

  public static void sendFileName(
        Socket s, String fileName) 
        throws IOException {

    // FILL IN THIS METHOD - Hint: create a stream to 
    // send the filename to the server

  }

  // This method will receive the file from the Server, 
  // or the result of the attempt to read the file.

  public static void receiveFile(Socket s) 
        throws IOException {

    // FILL IN THIS METHOD - Hint: look at the 
    // simpleClient code

  }

  public static void main(String args[]) {
    Socket s;
    int port = 4321;

    // Did we receive the correct number of arguments?
    if (args.length != 2) {
      System.out.println(
          "Usage: java ReadFile <server> <file>");
      System.exit (-1);
    }

    try {

      // Open our connection to args[0]
      s = new Socket(args[0], port);

      // Send the file name to the Server
      sendFileName (s, args[1]);

      // Output the file (or result of the request)
      receiveFile (s);

      // When the EOF is reached, just close the 
      // connection and exit
      s.close();

    } catch (IOException e) {
      // ignore
    }
  }
}
