import java.util.NoSuchElementException;
/**
 * Write a description of class MyLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyLinkedList
{
    private Node head;
    private int size;
    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        head = null;
    }
    
    public void addHead(int element) {
        size++;
        Node newNode = new Node(element);
        newNode.setNext(head);
        head = newNode;
    }
    
    public int getHead() {
        return head.getData();
    }
    
    public int size() {
        return size;
    }
    
    public int removeHead() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
        size--;
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    public String toString() {
        String result = "";
        if (head == null) {
            return result;
        }
        Node currNode = head;
        result = result + currNode.getData();
        currNode = currNode.getNext();
        while (currNode != null) {
            result = result + ", " + currNode.getData();
            currNode = currNode.getNext();
        }
        return result;
    }

}
