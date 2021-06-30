package org.corejavavolume.basicio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class PrimaryIO {
    private String environment = "F:\\spiderfile\\";

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public static void main(String[] args) throws IOException {
        PrimaryIO primaryIO = new PrimaryIO();

//        printFileInLine("picsFile.html");
        String outFile = primaryIO.getEnvironment() + "picsFile.html";
        System.out.println("--------------------");
        URL url = new URL("https://www.williamlong.info/archives/6007.html");
        pullWebPageIntoLocal(url, outFile);
    }

    private static void printFileInLine(String fileName) throws IOException {
        PrimaryIO pio = new PrimaryIO();
        Scanner in = new Scanner(Paths.get(pio.environment + fileName), "GBK");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
            String sIndex = in.findInLine("img");
        }
        System.out.println("-----------------");

    }

    private static void pullWebPageIntoLocal(URL url, String outFile) throws IOException{
        try (InputStream in = url.openStream();
             PrintWriter out = new PrintWriter(outFile, "UTF-8");){
            Scanner scanner = new Scanner(in);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
//                System.out.println(line);
                out.println(line);
            }
            out.flush();
//            FileOutputStream outputStream = new FileOutputStream("");//TODO
        }
    }
}
