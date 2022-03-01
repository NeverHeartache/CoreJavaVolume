package org.corejavavolume.concurrent.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Description 指定某个目录，列出该目录下所有文件夹和文件
 * 遍历所有文件夹下的所有文件，查询文件当中是否含有指定的“关键词”，如果文件当中有，则计数器加一
 * 然后
 */
public class CFInstance {
    private Callable<Integer> callable;
    private Future<Integer> future;
    static Executor executor = Executors.newCachedThreadPool();

    public CFInstance() {
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base dir (e.g. E:\\Java-Api\\src\\java\\lang):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = in.nextLine();
            System.out.println("keyword is : " + keyword);

            MatchCounter matchCounter = new MatchCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(matchCounter);
            Thread t = new Thread(task);
            t.start();

            try {
                System.out.println(task.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyword);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file)) count++;
            }
        }

        for (Future<Integer> future : results) {
            try {
                count += future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner sc = new Scanner(file,"UTF-8")) {
            boolean found = false;
            while (!found && sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(keyword)){
                    System.out.println(file.getPath() + " -- " + file.getName());
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
