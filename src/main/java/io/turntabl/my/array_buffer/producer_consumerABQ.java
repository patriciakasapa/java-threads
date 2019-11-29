package io.turntabl.my.array_buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class producer_consumerABQ {

    public static void main(String[] args) {
        // To create my blocking queue called items Queue
        BlockingQueue itemsQ = new ArrayBlockingQueue(30);
        Thread producer = new Thread(new Producer(itemsQ));
        Thread consumer = new Thread(new Consumer(itemsQ));

        producer.start();
        consumer.start();

    }

}