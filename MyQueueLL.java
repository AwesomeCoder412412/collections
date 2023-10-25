import java.util.NoSuchElementException;
/**
 * An implementation of a queue using a linked list.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyQueueLL<E extends Comparable<E>>
{
    private MyLinkedList<E> list;

    /**
     * Constructor for objects of class MyQueue
     */
    public MyQueueLL()
    {
        list = new MyLinkedList<E>();
    }
    
    /**
     * Adds element to back of queue.
     *
     * @param element element to add
     */
    public void enqueue(E element) {
       list.addTail(element); 
    }
    
    /**
     * Removes element from front of queue.
     *
     * @return element to remove
     */
    public E dequeue() {
        return list.removeHead();
    }
    
    /**
     * Returns if queue is empty.
     *
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * Reads element at front of queue.
     *
     * @return element at front of queue
     */
    public E front() {
        return list.getHead();
    }
    
    /**
     * Returns size of queue.
     *
     * @return size of queue
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns contents of queue from front to back.
     *
     * @return contents of queue from front to back
     */
    public String toString() {
        return list.toString();
    }

}
