
/**
 * Write a description of class MyHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeap<E extends Comparable<E>>
{
    private E[] elemArray;
    private int lastNode;
    
    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap()
    {
        elemArray = (E[]) new Comparable[16];
        lastNode = -1;
    }
    
    public void add(E element) {
        lastNode++;
        elemArray[lastNode] = element;
        int childPos = lastNode;
        while (elemArray[(childPos - 1) / 2].compareTo(elemArray[childPos]) < 0) {
            E temp = elemArray[childPos];
            elemArray[childPos] = elemArray[(childPos - 1) / 2];
            elemArray[(childPos - 1) / 2] = temp;
        }
        
    }
    
    public E getMin() {
        return null;
    }
    
    public E removeMin() {
        return null;
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public int size() {
        return 0;
    }
    
    public String toString() {
        return null;
    }
    
}
