package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private static int PORT = 4004;
    private static String IP = "localhost";


    BufferedReader in;
    BufferedWriter out;
    BufferedReader reader;
    Socket socket;

    private void makeClient(){
        try {
            socket = new Socket(IP, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Write tp server: ");

            String word = reader.readLine();

            out.write(word + "\n");
            out.flush();

            String serverWord = in.readLine();

            System.out.println(serverWord);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                socket.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Client().makeClient();
    }
}
