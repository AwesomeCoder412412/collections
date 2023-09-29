import java.util.NoSuchElementException;
/**
 * An implementation of a queue, an ADT
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyQueue<E>
{
    private E[] array;
    private int frontIndex;
    private int backIndex;
    private int size;

    /**
     * Constructor for objects of class MyQueue
     */
    public MyQueue()
    {
        array = (E[]) new Object[5];
        frontIndex = 0;
        backIndex = -1;
        size = 0;
    }
    
    /**
     * Adds an element to the back of the queue
     *
     * @param element The element to add to the back of the queue
     */
    public void enqueue(E element) throws IndexOutOfBoundsException {
        if (isFull()) {
            throw new IndexOutOfBoundsException(); 
        } else {
            size++;
            backIndex = (backIndex + 1) % array.length;
            array[backIndex] = element;
        }
    }
    
    /**
     * Removes an element from the front of the queue
     *
     * @return The element at the front of the queue
     */
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        } else {
            size--;
            E temp = array[frontIndex];
            array[frontIndex] = null;
            frontIndex++;
            return temp;
        }
    }
    
    /**
     * Indicates whether the queue contains any elements
     *
     * @return Whether the queue contains any elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Reads the element at the front of the queue
     *
     * @return The element at the front of the queue
     */
    public E front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        } else {
            return array[frontIndex];
        }
    }
    
    /**
     * Returns the number of elements stored in the queue
     *
     * @return The number of elements stored in the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Indicates whether the queue has exhausted its available storage
     *
     * @return Whether the queue has exhausted its available storage
     */
    public boolean isFull() {
        return size() == array.length;
    }
    
    /**
     * Returns the contents of the queue from front to back
     *
     * @return The contents of the queue from front to back
     */
    public String toString() {
        String result = "";
        if (size == 0) {
            return result;
        }
        for (int i = frontIndex; i < frontIndex + size; i++) {
            if (i % array.length == backIndex) {
                result = result + array[i % array.length];
            }
            else {
                result = result + array[i % array.length] + ", ";
            }
        }
        return result;
    }

}
