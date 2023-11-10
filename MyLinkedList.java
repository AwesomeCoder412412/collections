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
     * Returns node at specified index.
     *
     * @param index index of node to return
     * @return node located at provided index
     */
    private Node<E> getNode(int index) {
        if (index < (size / 2)){
            Node<E> toReturn = head;

            for (int i = 0; i < index; i++) {
                toReturn = toReturn.getNext();
            }
            return toReturn;
        } else {
            Node<E> toReturn = tail;

            for (int i = size - 1; i > index; i--) {
                toReturn = toReturn.getPrev();
            }
            return toReturn;
        }
    }

    /**
     * Returns element at specified index.
     *
     * @param index index of element to return
     * @return element located at provided index
     * @throw NoSuchElementException if index is invalid
     */
    public E get(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            return getNode(index).getData();
        }
    }

    /**
     * Removes and returns element at specified index.
     *
     * @param index index of element to remove 
     * @return removed element
     * @throw NoSuchElementException if index is invalid
     */
    public E remove(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            return removeHead();
        } else {
            Node<E> toRemove = getNode(index);

            if (index == size - 1) {
                tail = toRemove.getPrev();
                tail.setNext(null);
            } else {
                toRemove.getPrev().setNext(toRemove.getNext());
                toRemove.getNext().setPrev(toRemove.getPrev());
            }

            E toReturn = toRemove.getData();
            toRemove.setData(null);
            toRemove.setNext(null);
            toRemove.setPrev(null);
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
        Node<E> toRemove = head;
        int index = 0;

        while (toRemove != null && toRemove.getData().compareTo(element) != 0) {
            toRemove = toRemove.getNext();
            index++;
        }

        if (toRemove == null) {
            return null;
        } else if (index == 0) {
            return removeHead();
        } else {       
            if (index == size - 1) {
                tail = toRemove.getPrev();
                tail.setNext(null);
            } else {
                toRemove.getPrev().setNext(toRemove.getNext());
                toRemove.getNext().setPrev(toRemove.getPrev());
            }

            E toReturn = toRemove.getData();
            toRemove.setData(null);
            toRemove.setNext(null);
            toRemove.setPrev(null);
            size--;
            return toReturn;
        }
    }

    /**
     * Inserts element at specified index.
     *
     * @param index index to insert element at
     * @param element element to insert
     * @throw NoSuchElementException if index is invalid
     */
    public void add(int index, E element) throws NoSuchElementException {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else {
            if (index == 0) { // If it's empty, index will be 0
                addHead(element);
            } else if (index == size) {
                addTail(element);
            } else {
                Node<E> newNode = new Node<E>(element);
                Node<E> nextNode = getNode(index);
                size++;

                newNode.setNext(nextNode);
                newNode.setPrev(nextNode.getPrev());
                nextNode.setPrev(newNode);
                newNode.getPrev().setNext(newNode);
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
     * @throw NoSuchElementException if index is invalid
     */
    public void set(int index, E element) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            getNode(index).setData(element);
        }
    }

    /**
     * Inserts element before first occurence of larger element in list.
     *
     * @param element a parameter
     */
    public void insertSorted(E element) {
        Node<E> nextNode = head;
        int index = 0;

        while (nextNode != null && nextNode.getData().compareTo(element) < 0) {
            nextNode = nextNode.getNext();
            index++;
        }

        if (index == 0) { // If it's empty, index will be 0
            addHead(element);
        } else if (index == size) {
            addTail(element);
        } else {
            Node<E> newNode = new Node<E>(element);
            size++;

            newNode.setNext(nextNode);
            newNode.setPrev(nextNode.getPrev());
            nextNode.setPrev(newNode);
            newNode.getPrev().setNext(newNode);
        }

    }

    /**
     * Adds element to start of list.
     *
     * @param element element to be added
     */
    public void addHead(E element) {
        Node<E> newNode = new Node<E>(element);
        
        if (isEmpty()) { 
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        size++;
        head = newNode;
    }

    /**
     * Removes and returns head element of list.
     *
     * @return head element
     * @throw NoSuch ElementException if list is empty
     */
    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<E> temp = head;
            
            if (size == 1) { // Removing only node
                tail = null;
                head = null;
            } else { // Not last node
                head.getNext().setPrev(null);
                head = head.getNext(); 
            }
            size--;
            temp.setNext(null);
            return temp.getData();
        }
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
        } else {
            return head.getData();
        }
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
            newNode.setPrev(tail);
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
