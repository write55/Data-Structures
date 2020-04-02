
public interface MyQueue<E> {

    /**
     * Checks if queue is empty
     *
     * @return boolean, true if queue is empty
     */
    boolean isEmpty();

    /**
     * Adds a new object to the back of the queue
     *
     * @param obj Generic type object to be added to the queue
     */
    void enqueue(E obj);

    /**
     * Removes an object from the front of the queue and returns it
     *
     * @return object which was at the front of the queue
     */
    E dequeue();

    /**
     * Returns object at the front of the queue without changing the queue
     *
     * @return object at the front of the queue
     */
    E peek();
}
