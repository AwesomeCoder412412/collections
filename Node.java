
/**
 * Implements a node for use in a linked list.
 *
 * @author Jack Segil
 * @version 1.0
 */
public class Node<E>
{
    private E data;
    private Node<E> next;
    private Node<E> prev;
    /**
     * Constructor for objects of class Node
     */
    public Node(E dataToStore)
    {
        data = dataToStore;
        next = null;
        prev = null;
    }
    
    /**
     * Sets the node that this node points to.
     *
     * @param nextNode the next node in the list
     */
    public void setNext(Node nextNode) {
        next = nextNode;
    }
    
    /**
     * Sets the previous node.
     *
     * @param prevNode the next node in the list
     */
    public void setPrev(Node prevNode) {
        prev = prevNode;
    }
    
    public void setData (E dataToStore) {
        data = dataToStore;
    }
    
    /**
     * Returns the data stored in this node
     *
     * @return the data stored in this node
     */
    public E getData() {
        return data;
    }
    
    /**
     * Returns the next node in the list
     *
     * @return The next node in the list
     */
    public Node<E> getNext() {
        return next;
    }
    
    /**
     * Returns the previous node in the list
     *
     * @return the previous node in the list
     */
    public Node<E> getPrev() {
        return prev;
    }

}