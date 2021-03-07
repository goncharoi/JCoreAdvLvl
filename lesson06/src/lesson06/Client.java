package lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends ReaderWriter {

    public static void main(String[] args) {
        startTextClient();
    }

    private static void startTextClient() {
        try (Socket loSocket  = new Socket("localhost", 8180);
             BufferedReader loIn = new BufferedReader(new InputStreamReader(loSocket.getInputStream()));
             PrintWriter loOut = new PrintWriter(loSocket.getOutputStream());
             BufferedReader loSc = new BufferedReader(new InputStreamReader(System.in));
        ){
                ReadWrite(loIn,loOut,loSc);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
