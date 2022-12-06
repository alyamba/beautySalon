package org.example;

import org.example.handler.ServerHandler;
import org.example.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        new HibernateUtil();
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.listenUsers();
    }
}