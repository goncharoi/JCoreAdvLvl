package lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReaderWriter {

    protected static void ReadWrite(BufferedReader ioBR, PrintWriter ioOut, BufferedReader ioSc) {
        Reader loReader = new Reader(ioBR);
        loReader.start();

        String ivMessage = "";
        while (!ivMessage.equalsIgnoreCase("stop") && loReader.isAlive()) {
            try {
                if (!ioSc.ready()) continue;
                ivMessage = ioSc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ioOut.println(ivMessage);
            ioOut.flush();
        }
        loReader.interrupt();
        try {
            loReader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
