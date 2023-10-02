
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
    /**
     * Constructor for objects of class Node
     */
    public Node(E dataToStore)
    {
        data = dataToStore;
        next = null;
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
     * Returns the data stored in this node
     *
     * @return The data stored in this node
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

}