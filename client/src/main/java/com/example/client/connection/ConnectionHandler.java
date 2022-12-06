package com.example.client.connection;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

public class ConnectionHandler extends Thread{
    private static Socket socket;
    private static ObjectInputStream is;
    private static ObjectOutputStream os;

    public ConnectionHandler() {
        try {
            socket = new Socket("127.0.0.1", 8000);
            System.out.println("Успешное соединение с сервером!");
            os = new ObjectOutputStream(socket.getOutputStream());
            os.flush();
            is = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject listen(){
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

    public static void send(JSONObject jsonObject) {
        try {
            os.writeObject(jsonObject);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
