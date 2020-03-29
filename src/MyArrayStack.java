import java.util.EmptyStackException;

public class MyArrayStack<E> implements MyStack<E> {

    E[] theData;
    int topOfStack = -1;

    public MyArrayStack(int capacity) {
        theData = (E[]) new Object[capacity];
    }

    public void push(E obj) {
//        if (topOfStack == theData.length - 1) {
//            reallocate();
//        }
        topOfStack++;
        theData[topOfStack] = obj;
    }


    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack];
    }


    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack--];
    }


    public boolean isEmpty() {
        return topOfStack == -1;
    }

//    private void reallocate() {
//        E[] temp = (E[]) new Object[2 * theData.length];
//        System.arraycopy(theData, 0, temp, 0, theData.length);
//        theData = temp;
//    }
}
