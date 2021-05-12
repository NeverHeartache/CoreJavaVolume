package org.corejavavolume.io.bytestream;

import org.corejavavolume.io.IOProxy;

import java.io.*;

public class ByteStream {

    private InputStream inputStream;
    private OutputStream outputStream;

    /**
     * 复制字节
     * @param inFilePath
     * @param outFilePath
     * @throws IOException
     */
    public void byteCopy(String inFilePath, String outFilePath) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
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

    public static void main(String[] args) {
        String inputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\readme.txt";
        String outputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\output.txt";
        IOProxy ioProxy = new IOProxy();
        try {
            ioProxy.byteCopy(inputFile, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
