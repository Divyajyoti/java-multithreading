package org.javamultithreading.threadpool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {
    private BlockingQueue<Runnable> taskQueue;
    public ThreadPoolRunnable(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable r = taskQueue.take();
                r.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
