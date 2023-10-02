import java.util.NoSuchElementException;
/**
 * Implements a linked list of connected nodes.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyLinkedList<E>
{
    private Node<E> head;
    //private Node<E> tail;
    private int size;
    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        head = null;
        //tail = null;
        size = 0;
    }
    
    /**
     * Adds a node before the head of the list, becoming the new head
     *
     * @param element Node to become head of the list
     */
    public void addHead(E element) {
        size++;
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(head);
        head = newNode;
        // if (size == 1) {
            // tail = newNode;
        // }
    }
    
    /**
     * Adds a node after the tail of the list, becoming the new tail
     *
     * @param element Node to become tail of the list
     */
    public void addTail(E element) {
        size++;
        Node<E> newNode = new Node<E>(element);
        Node<E> currNode = head;
        if (!isEmpty()) {
            while (currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(newNode);
        } else {
            head = newNode;
        }
        
        
        //tail.setNext(newNode);
        //tail = newNode;
    }
    
    /**
     * Returns the value of the head of the list
     *
     * @return The value of the head of the list
     */
    public E getHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }
    
    /**
     * Returns if the list is empty or not
     *
     * @return If the list is empty or not
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Returns the size of the list
     *
     * @return The size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Removes the head node of the list
     *
     * @return The head node of the list
     */
    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Node<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    /**
     * Returns the list from head to tail
     *
     * @return The list from head to tail
     */
    public String toString() {
        String result = "";
        if (isEmpty()) {
            return result;
        }
        Node<E> currNode = head;
        result = result + currNode.getData();
        currNode = currNode.getNext();
        while (currNode != null) {
            result = result + ", " + currNode.getData();
            currNode = currNode.getNext();
        }
        return result;
    }

}
