import java.util.EmptyStackException;
/**
 * An implementation of a stack, an ADT
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyStack<E>
{
    private E[] array;
    private int size;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        array = (E[]) new Object[5];
        size = 0;
    }
    
    /**
     * Pushes element onto the stack
     *
     * @param element Element to push onto the Stack
     */
    public void push(E element) throws IndexOutOfBoundsException {
        if (isFull()) {
            throw new IndexOutOfBoundsException(); 
        } else {
            array[size] = element;
            size++;
        }
    }
    
    /**
     * Pops element off the stack
     *
     * @return Element on the top of the stack
     */
    public E pop() throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException(); 
        } else {
            size--;
            E temp = array[size];
            array[size] = null;
            return temp;
        }
    }
    
    /**
     * Returns if the stack is empty
     *
     * @return If the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Looks at the element on the top of the stack
     *
     * @return Element on the top of the stack
     */
    public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException(); 
        } 
        else {
            return array[size - 1];
        }
    }
    
    /**
     * Returns the size of the array
     *
     * @return Size of the array
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns if the array is full
     *
     * @return If the array is full
     */
    public boolean isFull() {
        return size() == array.length;
    }
    
    /**
     * Returns the contents of the stack from top to bottom
     *
     * @return The contents of the stack from top to bottom
     */
    public String toString() {
        String result = "";
        for (int i = size - 1; i >= 0; i--) {
            if (i == 0) {
                result = result + array[i];
            }
            else {
                result = result + array[i] + ", ";
            }
        }
        return result;
    }

}
