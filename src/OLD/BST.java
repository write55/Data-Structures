package OLD;

public class BST<E extends Comparable<E>> {

    /**
     * reference to the root node of the binary search tree, initially set to null
     */
    private BTNode<E> root = null;

    /**
     * Checks if the tree is empty
     *
     * @return boolean value, true if tree is not empty, false if it is empty
     */
    public boolean treeIsNotEmpty() {
        return root != null;
    }

    /**
     * Prints out the binary search tree using inorder traversal
     */
    public void inOrder() {
        if (treeIsNotEmpty()) {
            System.out.println("InOrder Traversal: ");
            System.out.print("[ ");
            inOrderRecursive(root);
            System.out.println("]\n");
        } else {
            System.out.println("Tree empty\n");
        }
    }

    /**
     * Helper method for inorder traversal
     *
     * @param node Initially called at the root of the tree, then using recursion
     */
    private void inOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderRecursive(node.getRight());
    }

    /**
     * Prints out the binary search tree using preorder traversal
     */
    public void preOrder() {
        if (treeIsNotEmpty()) {
            System.out.println("PreOrder Traversal: ");
            System.out.print("[ ");
            preOrderRecursive(root);
            System.out.println("]\n");
        } else {
            System.out.println("Tree empty\n");
        }
    }

    /**
     * Helper method for preorder traversal
     *
     * @param node Initially called at the root of the tree, then using recursion
     */
    private void preOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
    }

    /**
     * Prints out the binary search tree using postorder traversal
     */
    public void postOrder() {
        if (treeIsNotEmpty()) {
            System.out.println("PostOrder Traversal: ");
            System.out.print("[ ");
            postOrderRecursive(root);
            System.out.println("]\n");
        } else {
            System.out.println("Tree empty\n");
        }
    }

    /**
     * Helper method for postorder traversal
     *
     * @param node Initially called at the root of the tree, then using recursion
     */
    private void postOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        postOrderRecursive(node.getLeft());
        postOrderRecursive(node.getRight());
        System.out.print(node.getData() + " ");
    }

    /**
     * Adds a node with the given data value to the binary search tree in the correct position
     *
     * @param data Data value to be added to the binary search tree
     */
    public void add(E data) {
        if (treeIsNotEmpty()) {
            addRecursive(root, new BTNode<E>(data));
        } else {
            root = new BTNode<E>(data);
            System.out.println(root.getData().toString() + " added");
        }
    }

    /**
     * Uses recursion to find the proper location of the new node, then adds it to the tree
     *
     * @param node    Initially called at the root of the tree, then using recursion to travel the tree
     * @param newNode New node to be added to the tree
     * @return returns the new node if it is successfully added (or the next node to travel to using recursion)
     */
    private BTNode<E> addRecursive(BTNode<E> node, BTNode<E> newNode) {
        if (node != null) {
            if (newNode.compareTo(node) < 0) {
                node.setLeft(addRecursive(node.getLeft(), newNode));
            } else if (newNode.compareTo(node) > 0) {
                node.setRight((addRecursive(node.getRight(), newNode)));
            } else {
                System.out.println("Node already in tree");
            }
        } else {
            System.out.println(newNode.getData().toString() + " added");
            return newNode;
        }
        return node;
    }

    /**
     * Removes the given data value from the binary search tree if it is present
     *
     * @param data Data value to be located and removed from the binary search tree
     */
    public void delete(E data) {
        if (treeIsNotEmpty()) {
            root = deleteRecursive(root, new BTNode<E>(data));
        } else {
            System.out.println("Tree already empty\n");
        }
    }

    /**
     * Uses recursion to locate a node with a given data value, and deletes it if it is present
     *
     * @param node   Initially called at the root of the tree, then using recursion to travel the tree
     * @param target node to be deleted from the tree
     * @return returns null if the data value is not present, returns the deleted node if it was present (or the next node to travel to using recursion)
     */
    private BTNode<E> deleteRecursive(BTNode<E> node, BTNode<E> target) {
        if (node != null) {
            if (target.compareTo(node) < 0) {
                node.setLeft(deleteRecursive(node.getLeft(), target));
            } else if (target.compareTo(node) > 0) {
                node.setRight((deleteRecursive(node.getRight(), target)));
            } else {
                if (node.getLeft() == null) {
                    return node.getRight();
                } else if (node.getRight() == null) {
                    return node.getLeft();
                }
                node.setData(inOrderSuccessor(node.getRight()));
                node.setRight(deleteRecursive(node.getRight(), node));
            }
            System.out.println(node.getData().toString() + " deleted");
            return node;
        } else {
            System.out.println("Data not in tree");
            return null;
        }
    }

    /**
     * Helper method for delete method, finds the inorder successor of the given node and returns its data
     *
     * @param node method finds the inorder successor of this node
     * @return Data value of the inorder successor
     */
    private E inOrderSuccessor(BTNode<E> node) {
        E min = node.getData();
        while (node.getLeft() != null) {
            min = node.getLeft().getData();
            node = node.getLeft();
        }
        return min;
    }


}
