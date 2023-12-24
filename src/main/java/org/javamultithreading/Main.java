package org.javamultithreading;

import org.javamultithreading.producerconsumer.Consumer;
import org.javamultithreading.producerconsumer.Producer;
import org.javamultithreading.threadpool.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //threadpoolExample();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread t1 = new Thread(producer);
        t1.start();
        Thread t2 = new Thread(consumer);
        t2.start();
       /* t1.join();
        t2.join();*/
    }

    private static void threadpoolExample() {
        ThreadPool threadPool = new ThreadPool(3, 10);
        System.out.println("Thread pool created");

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            Runnable r = () -> {
                System.out.println("Runnable Task- " + taskNo + "done by Thread " + Thread.currentThread().getName());
            };
            threadPool.execute(r);
        }

        System.out.println("Waiting for all task to be completed");
        threadPool.waitForAllTasks();
        System.out.println("All tasks completed");

        /*threadPool.stop();
        System.out.println("Thread pool stopped");*/
    }
}