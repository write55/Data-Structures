public class BST<E extends Comparable<E>> {

    private BTNode<E> root = null;

    public boolean treeIsNotEmpty() {
        return root != null;
    }

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

    private void inOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderRecursive(node.getRight());
    }

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

    private void preOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
    }

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

    private void postOrderRecursive(BTNode<E> node) {
        if (node == null) {
            return;
        }
        postOrderRecursive(node.getLeft());
        postOrderRecursive(node.getRight());
        System.out.print(node.getData() + " ");
    }


    public void add(E data) {
        if (treeIsNotEmpty()) {
            addRecursive(root, new BTNode<E>(data));
        } else {
            root = new BTNode<E>(data);
        }
    }

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

    public void delete(E data) {
        if (treeIsNotEmpty()) {
            root = deleteRecursive(root, new BTNode<E>(data));
        } else {
            System.out.println("Tree already empty\n");
        }
    }

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

    private E inOrderSuccessor(BTNode<E> node) {
        E min = node.getData();
        while (node.getLeft() != null) {
            min = node.getLeft().getData();
            node = node.getLeft();
        }
        return min;
    }


}
