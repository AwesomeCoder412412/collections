import java.util.NoSuchElementException;
/**
 * Implements a linked list of connected nodes.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class MyLinkedList<E extends Comparable<E>>
{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns element at specified index.
     *
     * @param index index of element to return
     * @return element located at provided index
     */
    public E get(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Node<E> toReturn = head;
    
            for (int i = 0; i < index; i++) {
                toReturn = toReturn.getNext();
            }
            return toReturn.getData();
        }
    }

    /**
     * Removes and returns element at specified index.
     *
     * @param index index of element to remove 
     * @return removed element
     */
    public E remove(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            return removeHead();
        } else {
            Node<E> currNode = head;
    
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            Node<E> next = currNode.getNext();
    
            if (index == size - 1) {
                currNode.setNext(null);
                tail = currNode;
            } else {
                currNode.setNext(next.getNext());
            }
            
            E toReturn = next.getData();
            next.setData(null);
            next.setNext(null);
            size--;
            return toReturn;
        }
    }

    /**
     * Removes and returns first occurrence of matching element.
     *
     * @param element element to remove
     * @return removed element
     */
    public E remove(E element) {
        Node<E> currNode = head;
        int index = 0;

        while (currNode != null && currNode.getData().compareTo(element) != 0) {
            currNode = currNode.getNext();
            index++;
        }
        if (currNode == null) {
            return null;
        }
        return remove(index);
    }

    /**
     * Inserts element at specified index.
     *
     * @param index index to insert element at
     * @param element element to insert
     */
    public void add(int index, E element) throws NoSuchElementException {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Node<E> currNode = head;
            Node<E> newNode = new Node<E>(element);
            
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            if (size == 0 || index == 0) {
                addHead(element);
            } else if (index == size) {
                addTail(element);
            } else {
                size++;
                newNode.setNext(currNode.getNext());
                currNode.setNext(newNode);
            }
        }

    }

    /**
     * Adds element to end of list.
     *
     * @param element element to add
     */
    public void add(E element) {
        addTail(element);
    }

    /**
     * Replaces existing element at specified index.
     *
     * @param index index of element to replace
     * @param element element to replace with
     */
    public void set(int index, E element) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Node<E> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            currNode.setData(element);
        }
    }

    /**
     * Inserts element before first occurence of larger element in list.
     *
     * @param element A parameter
     */
    public void insertSorted(E element) {
        Node<E> currNode = head;
        int index = 0;

        while (currNode != null && currNode.getData().compareTo(element) < 0) {
            currNode = currNode.getNext();
            index++;
        }
        add(index, element);
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
        if (size == 1) {
            tail = newNode;
        }
    }

    /**
     * Removes and returns head element of list.
     *
     * @return head element
     * 
     * @throw NoSuchElementException if list is empty
     */
    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            tail = null;
        }
        size--;
        Node<E> temp = head;
        
        //Works whether last element or not
        head = head.getNext();
        temp.setNext(null);
        return temp.getData();
    }

    /**
     * Returns element of head of list.
     *
     * @return element of head of list
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

        if (!isEmpty()) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            tail = newNode;
            head = tail;
        }

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
     * Indicates whether list is empty.
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
