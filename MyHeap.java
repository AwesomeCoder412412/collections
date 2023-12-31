import java.util.*;
/**
 * An implementation of a heap.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyHeap<E extends Comparable<E>>
{
    private E[] elemArray;
    private int lastNode;
    private int maxSize;

    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap()
    {
        elemArray = (E[]) new Comparable[1];
        maxSize = 1;
        lastNode = -1;
    }

    /**
     * Adds element to heap.
     *
     * @param element element to add
     */
    public void add(E element) {
        if (lastNode == maxSize - 1) {
            elemArray = Arrays.copyOf(elemArray, maxSize * 2);
            maxSize *= 2;
        }

        lastNode++;
        elemArray[lastNode] = element;
        int childPos = lastNode;

        while (childPos != 0 && elemArray[(childPos - 1) / 2].compareTo(elemArray[childPos]) > 0) {
            E temp = elemArray[childPos];
            elemArray[childPos] = elemArray[(childPos - 1) / 2];
            elemArray[(childPos - 1) / 2] = temp;
            childPos = (childPos - 1) / 2;
        }
    }

    /**
     * Gets minimum element from heap.
     *
     * @return minimum element from heap
     */
    public E getMin() {
        return elemArray[0];
    }

    /**
     * Removes and returns minimum element from heap.
     *
     * @return minimum element from heap
     */
    public E removeMin() {
        E toReturn = getMin();
        elemArray[0] = elemArray[lastNode];
        elemArray[lastNode] = null;
        int parentPos = 0;
        int leftChildIndex = (parentPos * 2) + 1; 
        int rightChildIndex = (parentPos * 2) + 2;
        lastNode--;

        while (leftChildIndex <= lastNode && rightChildIndex <= lastNode + 1 && elemArray[leftChildIndex] != null && elemArray[rightChildIndex] != null
                && (elemArray[parentPos].compareTo(elemArray[leftChildIndex]) > 0 || elemArray[parentPos].compareTo(elemArray[rightChildIndex]) > 0)) {
            E temp = elemArray[parentPos];
            
            if (elemArray[leftChildIndex].compareTo(elemArray[rightChildIndex]) <= 0) {
                elemArray[parentPos] = elemArray[leftChildIndex];
                elemArray[leftChildIndex] = temp;
                parentPos = leftChildIndex;
            } else {
                elemArray[parentPos] = elemArray[rightChildIndex];
                elemArray[rightChildIndex] = temp;
                parentPos = rightChildIndex;
            }
            
            leftChildIndex = (parentPos * 2) + 1; 
            rightChildIndex = (parentPos * 2) + 2; 
        }
        
        return toReturn;
    }

    /**
     * Indicates whether heap is empty.
     *
     * @return whether heap is empty, otherwise false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns number of elements in heap.
     *
     * @return number of elements in heap
     */
    public int size() {
        return lastNode + 1;
    }

    /**
     * Returns the contents of the heap for testing purposes.
     *
     * @return contents of the heap
     */
    public String toString() {
        return Arrays.toString(elemArray);
    }

    /**
     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int depth = (int) (Math.log(lastNode + 1) / Math.log(2)) + 1;
        int maxSize = (int) Math.pow(2, depth) - 1;
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, depth - 1) * (maxElementWidth + 1);
        for (int i = 0; i < depth; i++) {
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
    private void printTree(String[] elements, int maxElementWidth) {
        for (int i = 0; i <= lastNode; i++) {
            elements[i] = elemArray[i].toString();
        }
    }

}
