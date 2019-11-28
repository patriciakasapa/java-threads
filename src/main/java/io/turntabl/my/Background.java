package io.turntabl.my;

public class Background {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            System.out.println("t1");
        try{
            Thread.sleep(10000);
            System.out.println("Hello from t1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        );
        t1.start();


        Thread t2 = new Thread(()->
        {
            System.out.println("t2");
            try {
                Thread.sleep(10000);
                System.out.println("Hi y'all... I'm t2");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        );
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Hope main thread is dying...");

    }
}
