
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
    
    // need remove max for duplicates
    public BinarySearchTreeNode<E> remove(E element) {
        if (element.compareTo(data) > 0) {
            if (rightChild == null) {
                return this;
            } else {
                rightChild = rightChild.remove(element);
                return this;
            }
        } else if (element.compareTo(data) < 0) {
            if (leftChild == null) {
                return this;
            } else {
                leftChild = leftChild.remove(element);
                return this;
            }
        } else {
            if (leftChild == null && rightChild == null) {
                return null;
            } else if (rightChild == null) {
                return leftChild;
            } else if (leftChild == null) {
                return rightChild;
            } else {
                E temp = leftChild.getMax();
                remove(leftChild.getMax());
                data = temp;
                return this;
            }
        }
    }
    
    /**
     * Searches for and return matching element, assumes that this node is the root node.
     *
     * @param element element to search for
     * @return matching element
     */
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
    
    /**
     * Returns the minimum element in BST, assumes that this node is the root node.
     *
     * @return the minimum element in BST
     */
    public E getMin() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.getMin();
        }
    }
    
    /**
     * Returns the maximum element in BST, assumes that this node is the root node.
     *
     * @return the maximum element in BST
     */
    public E getMax() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.getMax();
        }
    }
    
    public int getDepth() {
        if (leftChild == null && rightChild == null) {
            return 1;
        } else if (rightChild == null) {
            return leftChild.getDepth() + 1;
        } else if (leftChild == null) {
            return rightChild.getDepth() + 1;
        } else {
            if (leftChild.getDepth() >= rightChild.getDepth()) {
                return leftChild.getDepth() + 1;
            } else {
                return rightChild.getDepth() + 1;
            }
        }
    }
    
    /**
     * Returns the BST in ascending order, assumes that this node is the root node.
     *
     * @return the BST in ascending order
     */
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
