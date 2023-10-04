package org.javamultithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    int count = 0;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            count++;
            try {
                queue.put(count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
