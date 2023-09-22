/**
 * An implementation of a queue, an ADT
 *
 * @Jack Segil
 * @version 1.0
 */
public class MyQueue
{
    private int[] array;
    private int frontIndex;
    private int backIndex;
    private int size;

    /**
     * Constructor for objects of class MyQueue
     */
    public MyQueue(int length)
    {
        array = new int[length];
        frontIndex = 0;
        backIndex = -1;
        size = 0;
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            return;
        }
        size++;
        backIndex = (backIndex + 1) % array.length;
        array[backIndex] = element;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            return 0;
        }
        size--;
        int temp = array[frontIndex];
        frontIndex++;
        return temp;
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    public int front() {
        if (isEmpty()) {
            return 0;
        }
        return array[frontIndex];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isFull() {
        return size() >= array.length;
    }
    
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
