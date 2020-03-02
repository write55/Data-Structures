
public class LinkedListProgram<E extends Comparable<E>> {

	private ListNode<E> front;

	public LinkedListProgram() {
		front = null;
	}

	public ListNode<E> getFront() {
		return front;
	}

	public void setFront(ListNode<E> front) {
		this.front = front;
	}

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

	public void deleteList() {
		front = null;
	}

	public ListNode<E> reverseList(ListNode<E> reverseThis) {
		if (reverseThis == null || reverseThis.getNext() == null) {
			return reverseThis;
		}
		ListNode<E> temp = reverseList(reverseThis.getNext());
		reverseThis.getNext().setNext(reverseThis);
		reverseThis.setNext(null);
		return temp;
	}

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