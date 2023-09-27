package org.javamultithreading.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private ThreadPoolRunnable runnable;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        runnable = new ThreadPoolRunnable(taskQueue);
        for (int i = 0; i < noOfThreads; i++) {
            new Thread(runnable).start();
        }

    }

    public void execute(Runnable r) {
        taskQueue.offer(r);
    }

    public void stop() {

    }

    public void waitForAllTasks() {
        while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
