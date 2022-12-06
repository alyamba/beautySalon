package org.example.handler;

import org.example.command.RequestChecker;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SingleClientThread extends Thread{
    private static ObjectInputStream is;
    private static ObjectOutputStream os;
    private Socket socket;

    public SingleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());

            while (socket.isConnected()) {
                System.out.println("������������ � IP " + socket.getInetAddress().getHostName() + " � �������� ������");

                JSONObject requestObject = (JSONObject) is.readObject();
                System.out.println(requestObject);


                RequestChecker requestChecker = new RequestChecker(requestObject);
                JSONObject sendingObject = requestChecker.executingCommand();
                send(sendingObject);
            }
        } catch (IOException e) {
            try {
                socket.close();
                System.out.println("������������ ����������!");
            } catch (IOException ex) {
                System.out.println("Exception socket closing");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void send(JSONObject sendingObject) {
        try {
            os.writeObject(sendingObject);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
