import java.util.NoSuchElementException;

public class MyLinkedQueue<E> implements MyQueue<E> {

    private MyNode<E> front;
    private MyNode<E> back;

    /**
     * Constructor sets both MyNode references, front and back, to null
     */
    public MyLinkedQueue() {
        front = null;
        back = null;
    }

    /**
     * Checks if queue is empty
     *
     * @return boolean, true if queue is empty
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Adds a new object to the back of the queue
     *
     * @param obj Generic type object to be added to the queue
     */
    public void enqueue(E obj) {
        MyNode<E> newNode = new MyNode<>(obj, null);
        if (back != null) {
            back.setNext(newNode);
            back = newNode;
        } else {
            back = newNode;
            front = newNode;
        }
    }

    /**
     * Removes an object from the front of the queue and returns it
     *
     * @return object which was at the front of the queue
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E result = front.getData();
        front = front.getNext();
        if (isEmpty()) {
            back = null;
        }
        return result;
    }

    /**
     * Returns object at the front of the queue without changing the queue
     *
     * @return object at the front of the queue
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            return front.getData();
        }
    }
}
