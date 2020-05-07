
public class BTNode<E extends Comparable<E>> {

    /**
     * Generic object to hold data
     */
    private E data;
    /**
     * Reference to the left child
     */
    private BTNode<E> left;
    /**
     * Reference to the right child
     */
    private BTNode<E> right;

    /**
     * Constructor to create new binary tree node that contains a given data value, sets left and right child to null
     *
     * @param data generic object to hold data for the newly created node
     */
    public BTNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    // GETTERS
    public E getData() {
        return data;
    }

    public BTNode<E> getLeft() {
        return left;
    }

    public BTNode<E> getRight() {
        return right;
    }

    // SETTERS
    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    public void setRight(BTNode<E> right) {
        this.right = right;
    }

    /**
     * Compare to method that calls the compareTo method on the data stored in the given nodes
     *
     * @param input binary search tree node, the data of this node will be used in the method
     * @return integer, positive if input is less, negative if input is greater
     */
    public int compareTo(BTNode<E> input) {
        return data.compareTo(input.getData());
    }

}
