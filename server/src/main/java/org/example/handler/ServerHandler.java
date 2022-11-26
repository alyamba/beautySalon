package org.example.handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler {
    public void listenUsers(){
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while(true){
                Socket socket = serverSocket.accept();
                new SingleClientThread(socket).start();
                System.out.println("Пользователь присоединился, Server IP: " + socket.getInetAddress().getHostName());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
