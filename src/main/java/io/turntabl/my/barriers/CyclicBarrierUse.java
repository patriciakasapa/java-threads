package io.turntabl.my.barriers;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class CyclicBarrierUse {
    public static void main (String[] args){
        int horses = 3;
        CyclicBarrier cb = new CyclicBarrier(horses, () ->
                System.out.println("All done now so you can go home...hahaha"));
        IntStream.range(0, horses).forEach(h -> new GunToStart(h, cb).start());
    }
}
