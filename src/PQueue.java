import java.util.ArrayList;

public class PQueue<E extends Comparable<E>> implements MyQueue<E> {

    private ArrayList<E> heap;

    public PQueue() {
        heap = new ArrayList<E>();
    }

    /**
     * Checks if queue is empty
     *
     * @return boolean, true if queue is empty
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Adds a new object to the heap, keeping the order
     *
     * @param obj Generic type object to be added to the queue
     */
    public void enqueue(E obj) {
        heap.add(obj);
        // swap the node with the parent until the parent isn't higher priority
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Returns object at the front of the queue without changing the queue
     *
     * @return object at the front of the queue
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return heap.get(0);
        }
    }

    /**
     * Removes an object from the front of the queue and returns it
     *
     * @return object which was at the front of the queue
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E root = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            fixHeap(0);
            return root;
        }
    }

    /**
     * Restores the min-heap property, starting at the root and moving down the tree if necessary
     *
     * @param i index of the current node
     */
    private void fixHeap(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int priority; // highest priority node between left and right children and parent at each fork
        if (left < heap.size() && heap.get(left).compareTo(heap.get(i)) < 0) {
            priority = left;
        } else {
            priority = i;
        } // ensures you have the highest priority node of the left and middle before checking the right
        if (right < heap.size() && heap.get(right).compareTo(heap.get(priority)) < 0) {
            priority = right;
        }
        // If highest priority isn't the middle one, swap the nodes
        if (priority != i) { // keep going down the tree
            swap(i, priority);
            fixHeap(priority);
        }
    }

    /**
     * Swaps the position of two nodes in the heap
     *
     * @param i index of first node
     * @param j index of second node
     */
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Return the index of the left child of the given node
     *
     * @param i index of given node (parent node)
     * @return index of left child of the given node
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }


    /**
     * Return the index of the right child of the given node
     *
     * @param i index of given node (parent node)
     * @return the index of the right child of the given node
     */
    private static int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Return the index of the parent of the given node
     *
     * @param i index of the given node
     * @return index of the parent of the given node
     */
    private static int parent(int i) {
        return (i - 1) / 2;
    }

}
