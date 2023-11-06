/**
 * Creates a new Node implementation that is used to store data and is able
 * to track the node in front of it and it's data.
 *
 * @author Jiun
 * @version 10/2/2023
 */
public class Node<E>
{
    private E data;
    private Node next;
    private Node prev;
    
    /**
     * Constructs a new Node that takes in a generic type.
     * 
     * @param the element to be the data of the node
     */
    public Node(E element) {
        data = element;
    }

    /**
     * Gets the data of this node.
     *
     * @return the node data
     */
    public E getData()
    {
        return data;
    }
    
    /**
     * Gets the data of the next node in front.
     *
     * @return the next node data
     */
    public Node<E> getNext() {
        return next;
    }
    
    /**
     * Gets the data of the prev node.
     *
     * @return the prev node data
     */
    public Node<E> getPrev() {
        return prev;
    }
    
    /**
     * Sets the data of this node to be d.
     *
     * @param d the element to be the data
     */
    public void setData(E d) {
        data = d;
    }
    
    /**
     * Sets another node to be the next node of this node
     * 
     * @param n the node to be the next node
     */
    public void setNext(Node n) {
        next = n;
    }
    
    /**
     * Sets another node to be the next node of this node
     * 
     * @param n the node to be the next node
     */
    public void setPrev(Node p) {
        prev = p;
    }
    
}
