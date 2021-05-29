package org.corejavavolume.socket;

import java.io.*;
import java.net.Socket;

public class IndexSocket {

    public static void main(String[] args) throws IOException {
        File tmpFile = new File("wallwrapper.txt");
        if(tmpFile.exists()){
            tmpFile.delete();
        }
        try (Socket socket = new Socket("www.walltu.com",80);
             InputStream in = socket.getInputStream();
             OutputStream out = new FileOutputStream("wallwrapper.txt")){
            if(in.available() > 0){
                int c;
                while((c = in.read()) != -1){
                    out.write(c);
                }
            }
        }
    }
}
