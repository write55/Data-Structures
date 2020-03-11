
public class LinkedListProgram<E extends Comparable<E>> {

    /**
     * front - first ListNode object in linked list
     */
    private ListNode<E> front;
    /**
     * back - last ListNode object
     */
    private ListNode<E> back;

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
     * @param input ListNode object to be added in order
     */
    public void add(ListNode<E> input, ListNode<E> mid) {
        if (front == null && back == null) {
            front = input;
            back = input;
        } else if (input.compareTo(front) < 0) {
            input.setNext(front);
            front = input;
            input.getNext().setPrevious(front);
        } else if (input.compareTo(back) > 0) {
            input.setPrevious(back);
            back = input;
            input.getPrevious().setNext(back);
        } else if (input.equals(front) || input.equals(back)) {
            System.out.println("Already on List");
        } else {
            if (input.compareTo(mid) <= 0) {
                forwardsAdd(input);
            } else {
                backwardsAdd(input);
            }
        }
    }

    /**
     *
     * @param input
     */
    public void forwardsAdd(ListNode<E> input) {
        ListNode<E> current = front;
        ListNode<E> previous = null;
        while (input.compareTo(current) > 0) {
            previous = current;
            current = current.getNext();
        }
        if (input.equals(current)) {
            System.out.println("Already on List");
        } else {
            input.setNext(current);
            current.setPrevious(input);
            input.setPrevious(previous);
            if (previous != null) {
                previous.setNext(input);
            }
        }
    }

    /**
     *
     * @param input
     */
    public void backwardsAdd(ListNode<E> input) {
        ListNode<E> current = back;
        ListNode<E> previous = null;
        while (input.compareTo(current) < 0) {
            previous = current;
            current = current.getPrevious();
        }
        if (input.equals(current)) {
            System.out.println("Already on List");
        } else {
            input.setPrevious(current);
            current.setNext(input);
            input.setNext(previous);
            if (previous != null) {
                previous.setPrevious(input);
            }
        }
    }

    /**
     * Deletes a given ListNode object from the linked list, keeping the list in
     * order
     *
     * @param input ListNode object to be removed if present
     */
//    public void delete(ListNode<E> input) {
//        if (front == null) {
//            System.out.println("List Empty");
//        } else if (input.equals(front)) {
//            front = front.getNext();
//        } else {
//            ListNode<E> current = front;
//            ListNode<E> previous = null;
//            while (current.getNext() != null && !input.equals(current)) {
//                previous = current;
//                current = current.getNext();
//            }
//            if (input.equals(current)) {
//                if (current.getNext() == null) {
//                    previous.setNext(null);
//                } else {
//                    previous.setNext(current.getNext());
//                }
//            } else {
//                System.out.println("Not on List");
//            }
//        }
//    }

    /**
     * Clears the entire linked list
     */
    public void deleteList() {
        front = null;
        back = null;
    }

    /**
     * Reverses the linked list
     *
     * @param reverseThis front ListNode of the linked list to be reversed
     * @return ListNode object, only used in the method for recursion
     */
//    public ListNode<E> reverseList(ListNode<E> reverseThis) {
//        if (reverseThis == null || reverseThis.getNext() == null) {
//            front = reverseThis;
//            return reverseThis;
//        }
//        ListNode<E> temp = reverseList(reverseThis.getNext());
//        reverseThis.getNext().setNext(reverseThis);
//        reverseThis.setNext(null);
//        return temp;
//    }

    /**
     * Prints out the linked list in a readable format
     */
    public void printList() {
        if (front == null && back == null) {
            System.out.println("List is Empty");
        } else {
            ListNode<E> n = front;
            while (n != null) {
                System.out.println(n.getData().toString() + "\n");
                n = n.getNext();
            }
        }
    }

    /**
     *
     */
    public void printReverseList() {
        if (front == null && back == null) {
            System.out.println("List is Empty");
        } else {
            ListNode<E> n = back;
            while (n != null) {
                System.out.println(n.getData().toString() + "\n");
                n = n.getPrevious();
            }
        }

    }

    public static void main(String[] args) {
        LinkedListProgram<Integer> asdf = new LinkedListProgram<Integer>();
        ListNode<Integer> mid = new ListNode<Integer>(5, null, null);
        asdf.add(new ListNode<Integer>(1, null, null), mid);
        asdf.add(new ListNode<Integer>(2, null, null), mid);
        asdf.add(new ListNode<Integer>(3, null, null), mid);
        asdf.add(new ListNode<Integer>(4, null, null), mid);
        asdf.add(new ListNode<Integer>(5, null, null), mid);
        asdf.add(new ListNode<Integer>(6, null, null), mid);
        asdf.add(new ListNode<Integer>(7, null, null), mid);
        asdf.add(new ListNode<Integer>(8, null, null), mid);
        asdf.add(new ListNode<Integer>(9, null, null), mid);
        asdf.add(new ListNode<Integer>(10, null, null), mid);

        System.out.println("Original List:");
        asdf.printList();
        System.out.println("Reversed List:");
        asdf.printReverseList();
    }

}