package lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader extends Thread {

    private BufferedReader moBR;

    public Reader(BufferedReader ioBR){
        moBR = ioBR;
    }
    @Override
    public void run() {
        try {
            String ivMessage = "";
            while(!ivMessage.equalsIgnoreCase("stop") && !isInterrupted()) {
                while (!moBR.ready()) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                ivMessage = moBR.readLine();
                System.out.println(ivMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
