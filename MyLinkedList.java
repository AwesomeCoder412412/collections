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
     * Adds element to start of list.
     *
     * @param element element to be added
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
     * Removes head element of list.
     *
     * @return head element
     * 
     * @throw NoSuchElementException if list is empty
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
     * Returns value of head of list.
     *
     * @return value of head of list
     * 
     * @throw NoSuchElementException if list is empty
     */
    public E getHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    /**
     * Adds element at end of list.
     *
     * @param element element to be added
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
     * Returns size of list.
     *
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * Returns if list is empty.
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns list from head to tail.
     *
     * @return list from head to tail
     */
    public String toString() {
        String result = "";
        
        if (isEmpty()) {
            return result;
        }
        
        //Don't print comma with first node
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
