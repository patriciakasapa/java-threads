package io.turntabl.my.array_buffer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue items;
    public Consumer(BlockingQueue items) {
        this.items = items  ;
    }

    @Override
    public void run() {
    //To check if there are still empty positions in the queue
        //In other words, if it is not full
        while (items.remainingCapacity() > 0) {
            System.out.println("Queue's current size: " + items.size());
            System.out.println("Work: " + items.poll());
            System.out.println("The remaining capacity is: " + items.remainingCapacity());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
