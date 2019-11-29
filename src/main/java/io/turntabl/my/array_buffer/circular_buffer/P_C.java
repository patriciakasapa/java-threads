package io.turntabl.my.array_buffer.circular_buffer;

public class P_C {
    //producer adds items to list and consumer removes.
    public static class PC {

        // Create a list shared by producer and consumer
        CircularQueue<Integer> myqueue = new CircularQueue(30);

        // Function called by producer thread
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    if (myqueue.isFull()) {
                        wait();
                    } else {
                        System.out.println("Producer produced_" + value);
                        //wait();
                        myqueue.enqueue(value);
                        value++;
                        notifyAll();
                        Thread.sleep(1000);
                        Thread.yield();
                    }

                }
            }
        }

        //consumer thread
        public void consume() throws InterruptedException {
            while (true) {
                {
                    synchronized (this) {
                        while (myqueue.isEmpty())
                            wait();
                        // to remove the first job in the list
                        int val = myqueue.dequeue();
                        System.out.println("Consumer consumed_" + val);
                        notifyAll();
                        Thread.sleep(1000);
                        Thread.yield();
                    }
                }
            }
        }
    }
        public static void main(String[] args) throws InterruptedException {
            final PC pc = new PC();
            // producer thread
            Thread t1 = new Thread(() -> {
                try {
                        pc.produce();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // consumer thread
            Thread t2 = new Thread(() -> {
                {

                    try {
                            pc.consume();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }



}
