
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree<E>
{
    // instance variables - replace the example below with your own
    private E data;
    private Tree right;
    private Tree left;

    /**
     * Constructor for objects of class Tree
     */
    public Tree(E element)
    {
        // initialise instance variables
        data = element;
        right = null;
        left = null;
    }

    public E getData()
    {
        return data;
    }
    
    /**
     * Gets the data of the next node in front.
     *
     * @return the next node data
     */
    public Tree<E> getNext() {
        return right;
    }
    
    /**
     * Gets the data of the prev node.
     *
     * @return the prev node data
     */
    public Tree<E> getPrev() {
        return left;
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
    public void setNext(Tree n) {
        right = n;
    }
    
    /**
     * Sets another node to be the next node of this node
     * 
     * @param n the node to be the next node
     */
    public void setPrev(Tree p) {
        left = p;
    }
    
    public void insert(E element) {
        
    }
}
