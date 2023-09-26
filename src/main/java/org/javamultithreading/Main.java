package org.javamultithreading;

import org.javamultithreading.threadpool.ThreadPool;

public class Main {
    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool(3, 10);
        System.out.println("Thread pool created");

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            Runnable r = () -> {
                System.out.println("Runnable Task- " + taskNo + "done by Thread " + Thread.currentThread().getName());
            };
            threadPool.execute(r);
        }

        /*System.out.println("Waiting for all task to be completed");
        threadPool.waitForAllTasks();
        System.out.println("All tasks completed");*/

        /*threadPool.stop();
        System.out.println("Thread pool stopped");*/
    }
}