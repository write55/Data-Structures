
public class LinkedListProgram<E extends Comparable<E>> {

	/**
	 * front - first ListNode object in linked list
	 */
	private ListNode<E> front;

	/**
	 * Constructor for LinkedListProgram object
	 */
	public LinkedListProgram() {
		front = null;
	}

	public ListNode<E> getFront() {
		return front;
	}

	public void setFront(ListNode<E> front) {
		this.front = front;
	}

	/**
	 * Adds a given ListNode object to the linked list in order
	 * 
	 * @param input
	 *            ListNode object to be added in order
	 */
	public void add(ListNode<E> input) {
		if (front == null) {
			front = input;
		} else if (input.compareTo(front) < 0) {
			input.setNext(front);
			front = input;
		} else if (input.equals(front)) {
			System.out.println("Already on List");
		} else {
			ListNode<E> current = front;
			ListNode<E> previous = null;
			while (current != null && input.compareTo(current) > 0) {
				previous = current;
				current = current.getNext();
			}
			if (current == null) {
				previous.setNext(input);
			} else if (!input.equals(current)) {
				input.setNext(current);
				previous.setNext(input);
			} else {
				System.out.println("Already on List");
			}
		}
	}

	/**
	 * Deletes a given ListNode object from the linked list, keeping the list in
	 * order
	 * 
	 * @param input
	 *            ListNode object to be removed if present
	 */
	public void delete(ListNode<E> input) {
		if (front == null) {
			System.out.println("List Empty");
		} else if (input.equals(front)) {
			front = front.getNext();
		} else {
			ListNode<E> current = front;
			ListNode<E> previous = null;
			while (current.getNext() != null && !input.equals(current)) {
				previous = current;
				current = current.getNext();
			}
			if (input.equals(current)) {
				if (current.getNext() == null) {
					previous.setNext(null);
				} else {
					previous.setNext(current.getNext());
				}
			} else {
				System.out.println("Not on List");
			}
		}
	}

	/**
	 * Clears the entire linked list
	 */
	public void deleteList() {
		front = null;
	}

	/**
	 * Reverses the linked list
	 * 
	 * @param reverseThis
	 *            front ListNode of the linked list to be reversed
	 * @return ListNode object, only used in the method for recursion
	 */
	public ListNode<E> reverseList(ListNode<E> reverseThis) {
		if (reverseThis == null || reverseThis.getNext() == null) {
			front = reverseThis;
			return reverseThis;
		}
		ListNode<E> temp = reverseList(reverseThis.getNext());
		reverseThis.getNext().setNext(reverseThis);
		reverseThis.setNext(null);
		return temp;
	}

	/**
	 * Prints out the linked list in a readable format
	 */
	public void printList() {
		if (front == null) {
			System.out.println("List is Empty");
		} else {
			{
				System.out.print("[ ");
				ListNode<E> n = front;
				while (n != null) {
					System.out.print(n.getData() + " ");
					n = n.getNext();
				}
				System.out.println("]");
			}
		}
	}

}