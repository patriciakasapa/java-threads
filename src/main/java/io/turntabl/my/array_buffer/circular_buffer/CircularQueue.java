package io.turntabl.my.array_buffer.circular_buffer;

import java.util.Arrays;

class CircularQueue<E> {

    private int currentSize;
    private E[] itemsInQueue;
    private int capacity;
    private int rear;
    private int front;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        itemsInQueue = (E[]) new Object[capacity];
        currentSize = 0;
        front = -1;
        rear = -1;
    }
    public void enqueue(E item) {
        if (isFull()) {
           // producer.run();
            System.out.println("Circular Queue is full, please...");
        }
        else {
            rear = (rear + 1) % itemsInQueue.length;
            itemsInQueue[rear] = item;
            currentSize++;
            //consumer.run();
            if (front == -1) {
                front = rear;
            }
        }
    }
    //Dequeue element from Front.
    public E dequeue() {
        E deQueuedElement = null;
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        }
        else {
            deQueuedElement = itemsInQueue[front];
            //itemsInQueue[front] = null;
            front = (front + 1) % itemsInQueue.length;
            currentSize--;
        }
        return deQueuedElement;
    }
    public boolean isFull() {
        return (currentSize == capacity);
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(itemsInQueue) + "]";
    }

}
