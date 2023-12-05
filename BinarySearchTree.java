
/**
 * An implementation of a Binary Search Tree.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private int size;
    private BinarySearchTreeNode<E> root;

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }

    /**
     * Inserts element into BST.
     *
     * @param element element to insert
     */
    public void insert(E element) {
        if (isEmpty()) {
            root = new BinarySearchTreeNode<E>(element);
        } else {
            root.insert(element);
        }
        size++;
    }

    /**
     * Removes and returns matching element.
     *
     * @param element element to remove
     * @return the matching element
     */
    public E remove(E element) {
        if (search(element) == null) {
            return null;
        } else {
            E toReturn = search(element);
            root = root.remove(element);
            size--;
            return toReturn;
        }
    }

    /**
     * Searches for and return matching element.
     *
     * @param element element to search for
     * @return matching element
     */
    public E search(E element) {
        if (isEmpty()) {
            return null;
        } else {
            return root.search(element);
        }
    }

    /**
     * Returns the minimum element in BST.
     *
     * @return the minimum element in BST
     */
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMin();
        }
    }

    /**
     * Returns the maximum element in BST.
     *
     * @return the maximum element in BST
     */
    public E getMax() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMax();
        }
    }

    /**
     * Removes and returns the minimum element in BST.
     *
     * @return the minimum element in BST
     */
    public E removeMin() {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = root.getMin();
            size--;
            root = root.removeMin();
            return toReturn;
        }
    }

    /**
     * Removes and returns the maximum element in BST.
     *
     * @return the maximum element in BST
     */
    public E removeMax() {
        if (isEmpty()) {
            return null;
        } else {
            E toReturn = root.getMax();
            size--;
            root = root.removeMax();
            return toReturn;
        }
    }

    /**
     * Returns the number of elements in BST.
     *
     * @return the number of elements in BST
     */
    public int size() {
        return size;
    }

    /**
     * Indicates whether BST is empty.
     *
     * @return whether BST is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns number of levels in BST.
     *
     * @return the number of levels in BST
     */
    public int getDepth() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.getDepth();
        }
    }

    /**
     * Returns elements in sorted order.
     *
     * @return elements in sorted order
     */
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return root.toString();
        }
    }

    public void printTree(int i) {
        if (!isEmpty()) {
            root.printTree(i);
        }
    }
}
