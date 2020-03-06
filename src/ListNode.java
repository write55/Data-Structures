
public class ListNode<E extends Comparable<E>> implements Comparable<ListNode<E>> {

	/**
	 * data - Generic object to hold a data value
	 */
	private E data;
	/**
	 * next - reference to the next ListNode in the linked list
	 */
	private ListNode<E> next;
	/**
	 * previous - reference to the previous ListNode object in the linked list
	 */
	private ListNode<E> previous;

	/**
	 * Constructor for a ListNode object, takes parameters for data and the next
	 * ListNode
	 * 
	 * @param input
	 *            generic to set data for this ListNode
	 * @param next
	 *            ListNode object, reference to next ListNode
	 */
	public ListNode(E input, ListNode<E> previous, ListNode<E> next) {
		this.data = input;
		this.previous = previous;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public ListNode<E> getNext() {
		return next;
	}

	public ListNode<E> getPrevious() {
		return previous;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	public void setPrevious(ListNode<E> previous) {
		this.previous = previous;
	}

	/**
	 * Compares one ListNode object's to another's data using Java's compareTo
	 * method
	 * 
	 * @param input
	 *            ListNode object to be compared to
	 * @return int, positive if input is less, negative if input is greater
	 */
	public int compareTo(ListNode<E> input) {
		return data.compareTo(input.getData());
	}

	/**
	 * Compares data, checking if it is equal using Java's equals method
	 * 
	 * @param input
	 *            listNode object to be compared to
	 * @return boolean, true if equals
	 */
	public boolean equals(ListNode<E> input) {
		return data.equals(input.getData());
	}

}