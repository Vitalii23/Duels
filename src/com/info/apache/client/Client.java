package com.info.apache.client;

import com.info.apache.model.Account;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String hostname = "localhost";
    private int port = 8080;
    private Account account;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute(){
        try{
            Socket socket = new Socket(hostname, port);
            System.out.println("Conncted to server");
            ReadThread readThread = new ReadThread(socket, this);
            readThread.rtt.start();
            WriteThread writeThread = new WriteThread(socket, this);
            writeThread.wtt.start();
        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

}
