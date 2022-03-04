package org.corejavavolume.concurrent.threadpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.*;

public class SortedThreadPoolTest {
    static int callableListSize = 0;
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. E:\\src\\java\\lang):");
            String directory = in.nextLine();
            System.out.println("Enter key word: (e.g. volatile)");
            String keyword = in.nextLine();

            ExecutorService executorService = Executors.newCachedThreadPool();
            ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
            MatchCounter matchCounter = new MatchCounter(new File(directory), keyword, executorService);
            executorCompletionService.submit(matchCounter);//平常路数
            System.out.println("睡觉十秒......");
            Thread.sleep(10000);
            System.out.println("睡醒了以后：......");
            try {
                int temp = 0;
                for (int i = 0; i < callableListSize; i++) {
                    int j = (int) executorCompletionService.take().get();
                    temp += j;
                }
                System.out.println("result.get() is : "+ temp);
            } finally {
                executorService.shutdown();
            }


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SortedMatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorCompletionService executorCompletionService;
    private int count;

    public SortedMatchCounter(File directory, String keyword, ExecutorCompletionService executor){
        this.directory = directory;
        this.keyword = keyword;
        this.executorCompletionService = executor;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] filse = directory.listFiles();
            for (File file : filse) {
                if (file.isDirectory()) {
                    ++SortedThreadPoolTest.callableListSize;
                    SortedMatchCounter counter = new SortedMatchCounter(file, keyword, executorCompletionService);
                    executorCompletionService.submit(counter);
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
            while (!found) {
                String line = sc.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                    System.out.println(file.getPath() + "" +line);
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}