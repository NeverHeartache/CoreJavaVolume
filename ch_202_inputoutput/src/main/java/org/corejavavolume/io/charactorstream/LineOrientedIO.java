package org.corejavavolume.io.charactorstream;

import java.io.*;

/**
 * Let's modify the CopyCharacters example to use line-oriented I/O. To do this, we have to use two classes we haven't seen before,
 * @BufferedReader and
 * @PrintWriter.
 * We'll explore these classes in greater depth in Buffered I/O and Formatting.
 * Right now, we're just interested in their support for line-oriented I/O.
 */
public class LineOrientedIO {
    private BufferedReader reader;
    private PrintWriter printWriter;

    public void printLine(String sourceFile, String targetFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             PrintWriter printWriter = new PrintWriter(new FileWriter(targetFile))){
            String line ;
            while ((line = reader.readLine()) != null){
                printWriter.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\xanadu.txt";
        String outputFile = "E:\\GitHubRepo\\CoreJavaVolume\\inputoutput\\src\\main\\resources\\lineoutput.txt";
        LineOrientedIO lineOrientedIO = new LineOrientedIO();
        lineOrientedIO.printLine(inputFile, outputFile);

    }
}

