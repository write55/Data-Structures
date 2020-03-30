
import java.util.EmptyStackException;

public class MyLinkedStack<E> implements MyStack<E> {

    /**
     * Reference to top element in stack
     */
    private MyNode<E> topOfStackRef;

    /**
     * Linked/reference based stack, uses a linked list for the stack, constructor sets top of stack to null
     */
    public MyLinkedStack() {
        topOfStackRef = null;
    }

    /**
     * Adds a new node to the top of the stack
     *
     * @param obj new MyNode object to be added
     */
    public void push(E obj) {
        topOfStackRef = new MyNode<E>(obj, topOfStackRef);
    }

    /**
     * Returns MyNode at top of stack without changing the stack
     *
     * @return Data from MyNode object at top of stack
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topOfStackRef.getData();
        }
    }

    /**
     * Removes MyNode object from top of stack and returns its data
     *
     * @return Data from MyNode object at top of stack
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E result = topOfStackRef.getData();
            topOfStackRef = topOfStackRef.getNext();
            return result;
        }
    }

    /**
     * Checks if stack is empty
     *
     * @return boolean, true if stack is empty
     */
    public boolean isEmpty() {
        return topOfStackRef == null;
    }

}
