
public class LinkedListProgram<E extends Comparable<E>> {

    private ListNode<E> front;

    public LinkedListProgram() {
        front = null;
    }

    public void add(ListNode<E> input) {
        if (front == null) {
            front = input;
        } else if (input.getData().compareTo(front.getData()) < 0) {
            input.setNext(front);
            front = input;
        } else if (input.getData().equals(front.getData())) {
            System.out.println("Already on List");
        } else {
            ListNode<E> current = front;
            ListNode<E> previous = null;
            while (current != null && input.getData().compareTo(current.getData()) > 0) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                previous.setNext(input);
            } else if (!input.getData().equals(current.getData())) {
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
        } else if (input.getData().equals(front.getData())) {
            front = front.getNext();
        } else {
            ListNode<E> current = front;
            ListNode<E> previous = null;
            while (current.getNext() != null && !input.getData().equals(current.getData())) {
                previous = current;
                current = current.getNext();
            }
            if (input.getData().equals(current.getData())) {
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
