package io.turntabl.my;

import java.util.concurrent.ArrayBlockingQueue;

public class Concurrency {
    private boolean production = false;
    private ArrayBlockingQueue items = new ArrayBlockingQueue<>(30);

    public Concurrency(boolean production, ArrayBlockingQueue items) {
        this.production = production;
        this.items = items;
    }


    public void offer () {

    }
    public void poll () {
    }
    public static void main(String[] args) {
        
        Thread producer = new Thread(() -> {

            try {
                Thread.sleep(1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );
        Thread consumer = new Thread(() -> {

        }
        );

    }
}