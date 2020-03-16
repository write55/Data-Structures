
public class MyNode<E extends Comparable<E>> implements Comparable<MyNode<E>> {

	/**
	 * data - Generic object to hold a data value
	 */
	private E data;
	/**
	 * next - reference to the next OLD.ListNode in the linked list
	 */
	private MyNode<E> next;

	/**
	 * Constructor for a OLD.ListNode object, takes parameters for data and the next
	 * OLD.ListNode
	 *
	 * @param input
	 *            generic to set data for this OLD.ListNode
	 * @param next
	 *            OLD.ListNode object, reference to next OLD.ListNode
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
	 * Compares one OLD.ListNode object's to another's data using Java's compareTo
	 * method
	 *
	 * @param input
	 *            OLD.ListNode object to be compared to
	 * @return int, positive if input is less, negative if input is greater
	 */
	public int compareTo(MyNode<E> input) {
		return data.compareTo(input.getData());
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