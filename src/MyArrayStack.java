import java.util.EmptyStackException;

public class MyArrayStack<E> implements MyStack<E> {

    /**
     * Array of generic object types containing the stack
     */
    private E[] theData;
    /**
     * Index of the top of the stack
     */
    private int topOfStack = -1;

    /**
     * Constructor for a new MyArrayStack object, sets the size of the stack to the given parameter
     *
     * @param capacity integer, input for the max capacity of the stack
     */
    public MyArrayStack(int capacity) {
        theData = (E[]) new Object[capacity];
    }

    /**
     * Adds an object to the top of the stack
     *
     * @param obj Generic object type to be added
     */
    public void push(E obj) {
        if (topOfStack == theData.length - 1) {
            reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
    }

    /**
     * Returns the object stored at the top of the stack without changing the stack
     *
     * @return object at the top of the stack
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack];
    }

    /**
     * Removes the object at the top of the stack and returns it
     *
     * @return object at the top of the stack
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack--];
    }

    /**
     * Checks if the stack is empty
     *
     * @return boolean, true if stack is empty
     */
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    /**
     * When array is full, creates a new array twice the original size and moves the data to the new array
     */
    private void reallocate() {
        E[] temp = (E[]) new Object[2 * theData.length];
        System.arraycopy(theData, 0, temp, 0, theData.length);
        theData = temp;
    }
}
