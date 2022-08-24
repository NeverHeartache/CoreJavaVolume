package org.corejavavolume.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketService {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8899)) {
            int i = 1;
            while (true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable {

    private Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket) {
        incoming = incomingSocket;
    }

    @Override
    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outputStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inStream, "gbk");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "GBK"), true);
            out.println("Hello!Ener BYE to exit.");

            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
