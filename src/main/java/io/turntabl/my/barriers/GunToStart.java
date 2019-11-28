package io.turntabl.my.barriers;

import java.util.concurrent.CyclicBarrier;

public class GunToStart extends Thread {
    private CyclicBarrier cyc;

    //
    public GunToStart(int h, CyclicBarrier cyc){
        super("I'm new and my name is thread_" + h);
        this.cyc = cyc;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + ". Ready now!");
            cyc.await();
            Thread.sleep((int)(Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + ". I am all done now!");
            cyc.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
