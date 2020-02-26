
public class LinkedListProgram<E extends Comparable<E>> {

	private ListNode<E> front;

	public LinkedListProgram() {
		front = null;
	}

	public void add(ListNode<E> input, int index) {
		if (inList(input)) {
			System.out.println("Already in List");
		} else {
			if (front == null) {
				front = input;
			} else if (input.getData().compareTo(front.getData()) < 0) {
				// is that compare thing right?
				input.setNext(front);
				front = input;
			} else {
				ListNode<E> previous = null;
				ListNode<E> current = front;
				while (current != null && input.getData().compareTo(current.getData()) < 0) {
					// is this compare thing right?
					
				}
			}
		}

	}

	public void addFront(ListNode<E> input) {
		if (inList(input)) {
			System.out.println("Already in List");
		} else {
			if (front == null) {
				front = input;
			} else {
				input.setNext(front);
				front = input;
			}
		}
	}

	public void addEnd(ListNode<E> input) {
		if (inList(input)) {
			System.out.println("Already in List");
		} else {
			if (front == null) {

			}
		}

	}

	public boolean inList(ListNode<E> input) {
		if (front != null) {
			ListNode<E> temp = front;
			while (temp.getNext() != null) {
				if (temp.getData() == input.getData()) {
					return true;
				}
				temp = temp.getNext();
			}
		}
		return false;
	}
}
