package org.corejavavolume.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoSocket {

    public static void main(String[] args) throws IOException {
        //服务器套接字
        try(ServerSocket echoSocket = new ServerSocket(8089)){
            //获取客户端连接套接字；
            try(Socket socket = echoSocket.accept()){
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                //扫描器
                try(Scanner sc = new Scanner(inputStream, "UTF-8")){
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outputStream,"UTF-8"), true);
                    out.println("Hello! Enter BYE to exit.");

                    //echo client input
                    boolean done = false;
                    while(!done && sc.hasNextLine()){
                        String line = sc.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
