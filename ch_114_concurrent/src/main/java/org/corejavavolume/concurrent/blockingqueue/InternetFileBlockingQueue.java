package org.corejavavolume.concurrent.blockingqueue;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InternetFileBlockingQueue {
    private static final int QUEUE_SIZE = 50;
    private BlockingQueue<File> imageInFile = new ArrayBlockingQueue<File>(QUEUE_SIZE);
    private String goalNet = "";

    public static void main(String[] args) {

    }
}
