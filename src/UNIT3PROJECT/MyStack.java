package UNIT3PROJECT;

public interface MyStack<E> {

    /**
     * Adds an object to the top of the stack
     *
     * @param obj Generic object type to be added
     */
    void push(E obj);

    /**
     * Returns the object stored at the top of the stack without changing the stack
     *
     * @return object at the top of the stack
     */
    E peek();

    /**
     * Removes the object at the top of the stack and returns it
     *
     * @return object at the top of the stack
     */
    E pop();

    /**
     * Checks if the stack is empty
     *
     * @return boolean, true if stack is empty
     */
    boolean isEmpty();
}
