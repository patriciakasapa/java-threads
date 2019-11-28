package io.turntabl.my;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsOfThreads {
    public static void main(String[] args) throws InterruptedException {
        try {
            List<Thread> threads = (List<Thread>) IntStream.range(0, 10).mapToObj(t -> new Thread (() -> {
                while (!Thread.interrupted()) {
                    System.out.println("Still here: " + t);
                }
                System.out.println("Oh nooo..." + t + " was Interrupted");

            }
            )).collect((Collectors.toList()));
            threads.forEach(Thread::start);
            for (Thread thread : threads) {
                thread.sleep(1000);
            }
            threads.forEach(Thread::interrupt);
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
