package socket;

import java.io.*; 
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        
        System.out.println("Waiting for client......");

        Socket socket = serverSocket.accept();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello client!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String clientInput = input.readLine();
        
        System.out.println(clientInput);
        
        input.close();
        out.close();
        socket.close();
    }
}