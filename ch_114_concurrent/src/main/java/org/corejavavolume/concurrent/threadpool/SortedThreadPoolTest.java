package org.corejavavolume.concurrent.threadpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class SortedThreadPoolTest {
    static int callableListSize = 0;
    public static void main(String[] args) {
        List<Callable<Integer>> futures = new ArrayList<>();
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. E:\\src\\java\\lang):");
            String directory = in.nextLine();
            System.out.println("Enter key word: (e.g. volatile)");
            String keyword = in.nextLine();

            ExecutorService executorService = Executors.newCachedThreadPool();
            ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
            SortedMatchCounter matchCounter = new SortedMatchCounter(new File(directory), keyword, futures);
            executorCompletionService.submit(matchCounter);

            try {
                int temp = 0;
                for (int i=0; i < futures.size(); i++) {
                    temp += (int) executorCompletionService.take().get();
                }
                System.out.println("result.get() is : "+ temp);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
class SortedMatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private int count;
    private List<Callable<Integer>> futures;

    public SortedMatchCounter(File directory, String keyword, List<Callable<Integer>> list){
        this.directory = directory;
        this.keyword = keyword;
        this.futures = list;
    }

    public List<Callable<Integer>> getFutures() {
        return futures;
    }

    public void setFutures(List<Callable<Integer>> futures) {
        this.futures = futures;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] filse = directory.listFiles();
            for (File file : filse) {
                if (file.isDirectory()) {
                    SortedMatchCounter counter = new SortedMatchCounter(file, keyword, futures);
                    futures.add(counter);
                } else {
                    if (search(file)) count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File file) {
        boolean found = false;
        try (Scanner sc = new Scanner(file, "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                    System.out.println(file.getPath() + "  " +line);
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}