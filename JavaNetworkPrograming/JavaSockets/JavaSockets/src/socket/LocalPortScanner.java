package socket;

import java.io.*; 
import java.net.*;

public class LocalPortScanner {
    public static void main(String[] args) {
        
        int port = 1;

        while (port <= 65535) {
            
            try {
                ServerSocket server = new ServerSocket(port);    
            } catch (IOException e) {
                System.out.println("Port " + port + " is open!");
            }

            port++;
        }
    }
}