package com.company;

import java.io.*;
import java.net.*;

public class Server {


    public static void main(String[] args) {
        new Server().makeServer();
    }

    BufferedReader in;
    BufferedWriter out;
    ServerSocket serverSocket;
    Socket socket;

    private void makeServer(){
        try {
            serverSocket = new ServerSocket(4004);
            System.out.println("Server works!");
            socket = serverSocket.accept();
            System.out.println("Accepted");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line = in.readLine();

            String result = "Server gets your message. You write: " + line + "\n";

            out.write(result);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                serverSocket.close();
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }


}