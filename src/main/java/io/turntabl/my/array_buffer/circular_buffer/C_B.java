package io.turntabl.my.array_buffer.circular_buffer;

public class C_B {
    private int CAPACITY = 6;
    private volatile int[] buffer = new int[CAPACITY];
    private volatile int readIndex = 0;
    private volatile int writeIndex = 0;
    private volatile int current_bufLength = 0;
    int insertion = (int) Math.random();

    public C_B(int CAPACITY) {
        this.CAPACITY = CAPACITY;
           }

           public boolean isEmpty(){
                return CAPACITY == 0;
           }
           public boolean isFull(){
                return current_bufLength == CAPACITY;
           }

    public int read_remove() {
        while (!isEmpty()) {
            while (readIndex % CAPACITY > writeIndex) {
                current_bufLength--;
                buffer[readIndex] = 0;
                readIndex = (readIndex + 1) % CAPACITY;
            }
            if (readIndex == CAPACITY) {
                readIndex = 0;
            }
//            buffer.toString();
//            System.out.println(buffer);
//        int ret = buffer[++latest_read];
//        latest_read = latest_read % CAPACITY;
        }
            return current_bufLength;
    }

    public int write_add(){
        while (!isFull()) {
            while (writeIndex % CAPACITY <= readIndex) {
                buffer[writeIndex] = insertion;
                current_bufLength++;
                writeIndex = (writeIndex + 1) % CAPACITY;
            }
            if (writeIndex == CAPACITY) {
                return writeIndex = 0;
            }
//            buffer.toString();
//            System.out.println(buffer);
        }
        return current_bufLength;
    }

    public static void main (String [] args) throws InterruptedException {
        C_B circularBuffer = new C_B(6);
        Thread producer = new Thread(() ->{
            try {
                circularBuffer.write_add();
                Thread.sleep(10000);
                Thread.yield();
            } catch (Exception e) {
                e.printStackTrace();
            }
           // System.out.println(circularBuffer);
        });

        Thread consumer = new Thread(() ->{
            try {
                circularBuffer.read_remove();
                Thread.sleep(10000);
                Thread.yield();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(circularBuffer);
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

}
