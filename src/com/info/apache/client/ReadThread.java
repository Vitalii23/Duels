package com.info.apache.client;

import com.info.apache.model.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
    private Socket socket;
    private Client client;
    private Account account;
    private BufferedReader reader;

    public ReadThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
        try {
            reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error getting input stream: " + e.getMessage());
            e.printStackTrace();
        }
    }

    Thread rtt = new Thread(() -> {
        while (true) {
            try {
                String responce = reader.readLine();
                System.out.println("\n" + responce);
                if (account.getLogin() != null) {
                    System.out.print("[" + account.getLogin() + "]: ");
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
                e.printStackTrace();
                break;
            }
        }
    });
}
