
public class ListNode<E extends Comparable<E>> implements Comparable<ListNode<E>> {

	private E data;
	private ListNode<E> next;

	public ListNode(E input, ListNode<E> next) {
		this.data = input;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public ListNode<E> getNext() {
		return next;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	public int compareTo(ListNode<E> input) {
		return data.compareTo(input.getData());
	}

	public boolean equals(ListNode<E> input) {
		return data.equals(input.getData());
	}
}