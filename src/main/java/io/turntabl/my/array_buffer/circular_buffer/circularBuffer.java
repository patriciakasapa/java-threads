package io.turntabl.my.array_buffer.circular_buffer;

import java.util.ArrayList;
import java.util.List;

public class circularBuffer {

    private static volatile int capacity = 5;
    private static volatile int item = 0;
    private static Object lock;
   // private Object lock = new Object();

    public static void main (String[] args) throws InterruptedException {
       List <Integer> queue = new ArrayList<>();
Thread producer = new Thread(() ->{
try {
    if (queue.size() == capacity){
        System.out.println("Circular Buffer is full! Please wait...");
    }
    else {
        if (item < capacity) {
            synchronized (lock) {
                queue.add(item);
                 item++;
            }
            System.out.println("Item_" + item + " added");
        }
    Thread.sleep(1000);
        Thread.yield();
    }
} catch (Exception e) {
    e.printStackTrace();
}
});
Thread consumer = new Thread(() ->{
try {
    if (queue.size() == 0) {
        System.out.println("Circular Buffer is empty! Please wait...");
    }
            System.out.println("Item_" + item + " removed");
    synchronized (lock){
        queue.remove(item);
            item--;
    }
    Thread.sleep(1000);
    Thread.yield();
} catch (Exception e) {
    e.printStackTrace();
}

});

producer.start();
consumer.start();
producer.join();
consumer.join();
    }
}
