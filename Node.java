
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    private int data;
    private Node next;
    /**
     * Constructor for objects of class Node
     */
    public Node(int dataToStore)
    {
        data = dataToStore;
        next = null;
    }
    
    public void setNext(Node nextNode) {
        next = nextNode;
    }
    
    public int getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }

}