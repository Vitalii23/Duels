package com.info.apache.client;

import com.info.apache.model.Account;
import com.info.apache.model.Player;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class WriteThread extends Thread {
    private Socket socket;
    private Client client;
    private Account account;
    private PrintWriter writer;
    private Map<String, Player> combatants;

    public WriteThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
        try{
            writer =
                    new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()), true);
        } catch (IOException e) {
            System.out.println("Error getting output stream: " + e.getMessage());
            e.printStackTrace();
        }
    }

    Thread wtt = new Thread(() -> {
        writer.println(account.getLogin());
        String text;


        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error writing to server: " + e.getMessage());
        }
    });

}
