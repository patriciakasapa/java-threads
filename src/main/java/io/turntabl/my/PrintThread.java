package io.turntabl.my;

import java.io.File;

public class PrintThread implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread lister = new Thread(() -> {
           // IntStream.range(0, 1000).forEach(i -> );
            String[] allfiles;
            File directory = new File("/home/patricia-agyekum/scala-getting-started/");
            allfiles = directory.list();
            for (String filename: allfiles) {
                System.out.println(filename);
            }
        }
        );
        lister.start();
        lister.join();
    }
    @Override
    public void run() {

    }
}
