package socket;

import java.net.*;

import socket.test.ClientThread;

import java.io.*;

/**
 *
 * @author catalin
 */
public class MultiThreadedServer 
{
    public static void main(String [] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(9090);
            boolean stop = false;
            while(!stop)
            {
                System.out.println("Waiting for clients...");

                Socket clientSocket = serverSocket.accept();
                
                System.out.println("Client is connected.");
                
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.run();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
