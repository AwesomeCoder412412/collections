import java.util.EmptyStackException;
/**
 * An implementation of a stack using a linked list.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyStackLL<E>
{
    private MyLinkedList<E> list;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStackLL()
    {
        list = new MyLinkedList<E>();
    }
    
    /**
     * Pushes element onto stack.
     *
     * @param element Element to push
     */
    public void push(E element) {
        list.addHead(element);
    }
    
    /**
     * Pops top element off stack.
     *
     * @return element
     */
    public E pop() {
        return list.removeHead();
    }
    
    /**
     * Returns top element of stack.
     *
     * @return element
     */
    public E top() {
        return list.getHead();
    }
    
    /**
     * Returns size of stack.
     *
     * @return size of stack
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns if stack is empty.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * Returns contents of stack from top to bottom.
     *
     * @return contents of stack from top to bottom
     */
    public String toString() {
       return list.toString();
    }

}
