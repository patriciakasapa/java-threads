package io.turntabl.my;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class PrintThread implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread lister = new Thread(() -> IntStream.range(0, 1000).forEach(i -> {
            String[] allfiles;
            File directory = new File(
                    "/home/kasapa/logging-microservice");
            // /home/patricia-agyekum/scala-getting-started/");
            allfiles = directory.list();
            List<String> filelocator = new ArrayList<>();
            for (String filename : allfiles) {
                filelocator.add(filename);
                //filelocator.addAll(Arrays.asList(allfiles));
                filelocator.iterator();
                ListIterator<String> thefile = filelocator.listIterator();
                while (thefile.next() == filename){
                System.out.println(filelocator);
            }
//                    for (filename: filelocator) {
//
//                    }
                    System.out.println();
                    System.out.println();
        }
        }
        ));
        lister.start();
        Thread.sleep(30000);
        lister.join();
        lister.interrupt();
    }
    @Override
    public void run() {

    }
}
