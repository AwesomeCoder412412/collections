
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
    
    /**
     * Removes and returns matching element.
     *
     * @param element element to remove
     * @return the matching element
     */
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
    
    /**
     * Returns number of levels in BST.
     *
     * @return the number of levels in BST.
     */
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
     * Returns elements in sorted order.
     *
     * @return elements in sorted order
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
    
    
    
    /**
     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int maxSize = (int) Math.pow(2, (getDepth() + 1));
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, 0, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, getDepth()) * (maxElementWidth + 1);
        for (int i = 0; i < getDepth() + 1; i++) {
            String connectionsLevel = "";
            String elementsLevel = "";

            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1; j++) {

                // Process arrows for this level
                String arrow = "  ";
                int elementLength = arrow.length();
                if (elements[j] != null) {
                    if (j % 2 == 1) { // Odd is left child
                        arrow = " /";
                    } else { // Even is right child
                        arrow = "\\ ";
                    }
                }

                // Center within maxElementWidth
                String leftPadStr = ""; // Default
                String rightPadStr = ""; // Default
                int leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                int rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }
                connectionsLevel += leftPadStr + arrow + rightPadStr;

                // Process elements for this level
                elementLength = 0;
                if (elements[j] != null) {
                    elementLength = elements[j].toString().length();
                }

                // Center within maxElementWidth
                leftPadStr = ""; // Default
                rightPadStr = ""; // Default
                leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }

                if (elements[j] != null) {
                    elementsLevel += leftPadStr + elements[j] + rightPadStr;
                } else {
                    elementsLevel += leftPadStr + rightPadStr;
                }
            }

            if (i > 0) { // Do not print arrows for root
                System.out.println(connectionsLevel);
            }
            System.out.println(elementsLevel);
        }
    }

    // build array of element strings
    private void printTree(String[] elements, int nodeNum, int maxElementWidth) {
        elements[nodeNum] = data.toString();
        if (elements[nodeNum].length() > maxElementWidth) {
            elements[nodeNum] = elements[nodeNum].substring(0, maxElementWidth);
        }
        if (leftChild != null) {
            leftChild.printTree(elements, (nodeNum + 1) * 2 - 1, maxElementWidth);
        }
        if (rightChild != null) {
            rightChild.printTree(elements, (nodeNum + 1) * 2, maxElementWidth);
        }
    }
}
