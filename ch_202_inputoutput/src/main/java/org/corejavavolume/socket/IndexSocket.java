package org.corejavavolume.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class IndexSocket {

    public static void main(String[] args) throws IOException {
        File tmpFile = new File("wallwrapper.txt");
        if(tmpFile.exists()){
            tmpFile.delete();
        }
        try (Socket socket = new Socket("www.baidu.com",443);
             Scanner sc = new Scanner(socket.getInputStream(), "UTF-8");
//             InputStream in = socket.getInputStream();
//             OutputStream out = new FileOutputStream("wallwrapper.txt")
        ){
            InetAddress address = InetAddress.getLocalHost();
            byte[] addressBytes = address.getAddress();
            System.out.println(address.toString());
            System.out.println(address.getHostName());
            System.exit(0);
            socket.setSoTimeout(10000);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
//            if(in.available() > 0){
//                int c;
//                while((c = in.read()) != -1){
//                    out.write(c);
//                }
//            }
        }
    }

    /**
     * 创建套接字
     * @param host 主机
     * @param port 端口
     * @return 套接字
     * @throws IOException
     */
    public Socket getSocket(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        return socket;
    }

    /**
     * 设置读写连接超时时间
     * @param host 主机
     * @param port 端口
     * @param milisecond 超时时间
     * @return 套接字
     * @throws IOException
     */
    public Socket getTimeoutSocket(String host, int port, int milisecond) throws IOException{
        Socket socket = new Socket(host, port);
        socket.setSoTimeout(milisecond);
        return socket;
    }

    /**
     * 设置连接超时的套接字
     * @param host 主机
     * @param port 端口
     * @param milisecond 超时时间
     * @return 连接
     * @throws IOException
     */
    public Socket getConnectTimeoutSocket(String host, int port, int milisecond) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), milisecond);
        return socket;
    }


}
