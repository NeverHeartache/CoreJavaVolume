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

    public static void main(String[] args) throws IOException {
        printFileInLine("picsFile.html");
    }

    private static void printFileInLine(String fileName) throws IOException {
        PrimaryIO pio = new PrimaryIO();
        Scanner in = new Scanner(Paths.get(pio.environment + fileName), "GBK");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
            String sIndex = in.findInLine("img");
        }
    }

    private static void pullWebPageIntoLocal(URL url, String outFile) throws IOException{
        try (InputStream in = url.openStream()){
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            PrintWriter out = new PrintWriter(outFile, "UTF-8");
            FileOutputStream outputStream = new FileOutputStream("");//TODO
        }
    }
}
