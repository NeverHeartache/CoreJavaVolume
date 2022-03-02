package org.corejavavolume.concurrent.threadpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. E:\\src\\java\\lang):");
            String directory = sc.nextLine();
            System.out.println("Enter key word: (e.g. volatile)");
            String keyword = sc.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size is :" + largestPoolSize);
        }
    }
}

/**
 * @Description
 */
class MatchCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file:files) {
                if (file.isDirectory()) {
                    MatchCounter matchCounter = new MatchCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(matchCounter);
                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            }

            for (Future<Integer> future:results) {
                try{
                    count += future.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
