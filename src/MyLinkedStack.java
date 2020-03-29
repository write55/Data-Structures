
import java.util.EmptyStackException;

public class MyLinkedStack<E> implements MyStack<E> {

	private MyNode<E> topOfStackRef;

	public MyLinkedStack() {
		topOfStackRef = null;
	}

	public void push(E obj) {
		topOfStackRef = new MyNode<E>(obj, topOfStackRef);
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return topOfStackRef.getData();
		}
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			E result = topOfStackRef.getData();
			topOfStackRef = topOfStackRef.getNext();
			return result;
		}
	}

	public boolean isEmpty() {
		return topOfStackRef == null;
	}

}
