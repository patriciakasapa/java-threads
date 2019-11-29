package io.turntabl.my.array_buffer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue items;

    public Producer(BlockingQueue items) {
        this.items = items;
    }
    @Override
    public void run() {
for (int i = 0; i < 30; i++) {
    System.out.println("Trying to add to queue: Action_" + i);
    System.out.println("Check result: " + items.offer("Action_" + i));


    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}
