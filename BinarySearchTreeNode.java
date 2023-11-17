
/**
 * An implementation of a node of a Binary Search Tree.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class BinarySearchTreeNode<E extends Comparable<E>>
{
    private BinarySearchTreeNode<E> leftChild;
    private BinarySearchTreeNode<E> rightChild;
    private E data;
    
    /**
     * Constructor for objects of class BinarySearchTreeNode
     */
    public BinarySearchTreeNode(E element)
    {
        leftChild = null;
        rightChild = null;
        data = element;
    }
    
    /**
     * Inserts element into the BST, assumes that this node is the root node
     *
     * @param element element to insert
     */
    public void insert(E element) {
        if (element.compareTo(data) >= 0) {
            if (rightChild == null) {
                rightChild = new BinarySearchTreeNode<E>(element);
            } else {
                rightChild.insert(element);
            }
        } else {
            if (leftChild == null) {
                leftChild = new BinarySearchTreeNode<E>(element);
            } else {
                leftChild.insert(element);
            }
        }
    }
    
    public E search(E element) {
        if (element.compareTo(data) > 0) {
            if (rightChild == null) {
                return null;
            } else {
                return rightChild.search(element);
            }
        } else if (element.compareTo(data) < 0) {
            if (leftChild == null) {
                return null;
            } else {
                return leftChild.search(element);
            }
        } else {
            return data;
        }
    }
    
    public E getMin() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.getMin();
        }
    }
    
    public E getMax() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.getMax();
        }
    }
    
    public String toString() {
        String toReturn = "";
        if (leftChild != null) {
            toReturn = leftChild.toString() + ", ";
        } 
        toReturn = toReturn + data.toString();
        if (rightChild != null) {
            toReturn = toReturn + ", " + rightChild.toString();
        }
        return toReturn;
    }
}
