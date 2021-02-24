package lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends ReaderWriter {

    public static void main(String[] args) {
        startTextServer();
    }

    private static void startTextServer() {
        try(ServerSocket loServerSocket = new ServerSocket(8180)){
            System.out.println("Server is listening");
            try(Socket loSocket = loServerSocket.accept();
                BufferedReader loIn = new BufferedReader(new InputStreamReader(loSocket.getInputStream()));
                PrintWriter loOut = new PrintWriter(loSocket.getOutputStream());
                BufferedReader loSc = new BufferedReader(new InputStreamReader(System.in));
            ){
                System.out.println("Client is connected");
                ReadWrite(loIn,loOut,loSc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
