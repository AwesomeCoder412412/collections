/**
 * Write a description of class MyStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStack
{
    private int[] array;
    private int size;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack(int length)
    {
        array = new int[length];
        size = 0;
    }
    
    public void push(int element) {
        if (isFull()) {
            return;
        }
        array[size] = element;
        size++;
    }
    
    public int pop() {
        if (isEmpty()) {
            return 0;
        }
        size--;
        return array[size];
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    public int top() {
        if (isEmpty()) {
            return 0;
        }
        return array[size - 1];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isFull() {
        return size() >= array.length;
    }
    
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
