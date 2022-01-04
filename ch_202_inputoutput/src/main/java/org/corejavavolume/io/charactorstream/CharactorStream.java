package org.corejavavolume.io.charactorstream;

import org.corejavavolume.io.IOProxy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharactorStream {

    public void charactersCopy(String inputFile, String outputFile) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader(inputFile);
            outputStream = new FileWriter(outputFile);

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\xanadu.txt";
        String outputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\characteroutput.txt";
        IOProxy ioProxy = new IOProxy();
        try {
            ioProxy.charactersCopy(inputFile, outputFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
