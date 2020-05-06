package UNIT3PROJECT;

import java.util.NoSuchElementException;

public class MyArrayQueue<E> implements MyQueue<E> {

    /**
     * Maximum items queue can hold at once
     */
    private final int MAX_QUEUE = 5;
    /**
     * Array of generic object types for queue
     */
    private E[] items;
    /**
     * Integers to track the front/back of queue and how many items are in it
     */
    private int front, back, count;

    /**
     * Creates array for queue and sets front/back to initial positions, and count to 0
     */
    public MyArrayQueue() {
        items = (E[]) new Object[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE - 1;
        count = 0;
    }

    /**
     * Checks if queue is empty
     *
     * @return boolean, true if queue is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks if the array for the queue is full
     *
     * @return boolean, true is the queue is full
     */
    public boolean isFull() {
        return count == MAX_QUEUE;
    }

    /**
     * Adds a new object to the back of the queue
     *
     * @param obj Generic type object to be added to the queue
     */
    public void enqueue(E obj) {
        if (!isFull()) {
            back = (back + 1) % (MAX_QUEUE);
            items[back] = obj;
            count++;
        } else {
            throw new NoSuchElementException("Queue full");
        }
    }

    /**
     * Removes an object from the front of the queue and returns it
     *
     * @return object which was at the front of the queue
     */
    public E dequeue() {
        if (!isEmpty()) {
            E queueFront = items[front];
            front = (front + 1) % (MAX_QUEUE);
            count--;
            return queueFront;
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }

//    public void dequeueAll() {
//        items = (E[]) new Object[MAX_QUEUE];
//        front = 0;
//        back = MAX_QUEUE - 1;
//        count = 0;
//    }

    /**
     * Returns object at the front of the queue without changing the queue
     *
     * @return object at the front of the queue
     */
    public E peek() {
        if (!isEmpty()) {
            return items[front];
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }
}
