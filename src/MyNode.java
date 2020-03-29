
public class MyNode<E> {

	/**
	 * data - Generic object to hold a data value
	 */
	private E data;
	/**
	 * next - reference to the next MyNode in the linked list
	 */
	private MyNode<E> next;

	/**
	 * Constructor for a MyNode object, takes parameters for data and the next
	 * OLD.ListNode
	 *
	 * @param input
	 *            generic to set data for this MyNode
	 * @param next
	 *            OLD.ListNode object, reference to next MyNode
	 */
	public MyNode(E input, MyNode<E> next) {
		this.data = input;
		this.next = next;
	}

	// GETTERS
	public E getData() {
		return data;
	}

	public MyNode<E> getNext() {
		return next;
	}

	// SETTERS
	public void setData(E data) {
		this.data = data;
	}

	public void setNext(MyNode<E> next) {
		this.next = next;
	}

	/**
	 * Compares data, checking if it is equal using Java's equals method
	 *
	 * @param input
	 *            listNode object to be compared to
	 * @return boolean, true if equals
	 */
	public boolean equals(MyNode<E> input) {
		return data.equals(input.getData());
	}


}