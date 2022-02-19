package org.corejavavolume.io.file;

import org.corejavavolume.io.IOConstant;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageReader {

    private static final String resourcePath =  IOConstant.resourcePath;

    private static final String sysProperties = IOConstant.SYS_PROPERTIES;

    public static void main(String[] args) {
        System.out.println(resourcePath);
        Path path = Paths.get(resourcePath);
        File imagePathFile = new File(resourcePath);
        List<File> jpgFileList = new ArrayList<>();
        File[] files = null;
        if (imagePathFile.isDirectory()) {
            files = imagePathFile.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.endsWith("jpg")) {
                        return true;
                    }
                    return false;
                }
            });
            Arrays.stream(files).forEach(f -> {
                String fileName = f.getName();
                System.out.println(fileName);
                if (fileName.endsWith(".jpg")) {
                    jpgFileList.add(f);
                }
            });
        }
        if (files != null) {

        }
    }
}
