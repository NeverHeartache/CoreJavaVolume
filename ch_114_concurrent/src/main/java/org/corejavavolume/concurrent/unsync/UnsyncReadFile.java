package org.corejavavolume.concurrent.unsync;

import java.io.*;

public class UnsyncReadFile {

    private String readFilePath = "E:\\GithubRepo\\CoreJavaVolume\\ch_114_concurrent\\src\\main\\resources\\concurrent.txt";

    synchronized void readFile() {
        File file = new File(readFilePath);
        StringBuffer sb = new StringBuffer();
        if (file.exists() && !file.isDirectory()) {
            try ( BufferedReader fis = new BufferedReader(new FileReader(readFilePath))){
                String line;
                while((line = fis.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " -- " + line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            UnsyncReadFile urf = new UnsyncReadFile();
            urf.readFile();
        };
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}
