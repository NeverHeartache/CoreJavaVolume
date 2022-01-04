package org.corejavavolume.io;

import java.io.*;

public class IOProxy {

    private InputStream inputStream;

    private OutputStream outputStream;

    FileInputStream fileInputStream;

    FileOutputStream fileOutputStream;

    public IOProxy(){}

    public IOProxy(InputStream in, OutputStream out){
        this.inputStream = in;
        this.outputStream = out;
    }

    public void byteCopy(String inFilePath, String outFilePath) throws IOException{
        try {
            int c;
            fileInputStream = new FileInputStream(inFilePath);
            fileOutputStream = new FileOutputStream(outFilePath);
            if (fileInputStream.available() > 0){
                while((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null){
                fileOutputStream.close();
            }
        }
    }

    public void charactersCopy(String inputFile, String outputFile) throws IOException{
        FileReader inputStream = null;
        FileWriter outputStream = null;
        inputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\xanadu.txt";
        outputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\characteroutput.txt";
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
        String inputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\readme.txt";
        String outputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\output.txt";
        IOProxy ioProxy = new IOProxy();
//        try {
//            ioProxy.byteCopy(inputFile, outputFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            ioProxy.charactersCopy("", "");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
