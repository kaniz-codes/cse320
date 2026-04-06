import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        server.close();
    }
}