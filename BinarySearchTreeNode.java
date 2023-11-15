/**
 * Creates a BinarySearchTreeNode that is an individual node in a Binary
 * SearchTree. The Node will contain data and be able to access its right
 * and left subtrees.
 *
 * @author jiun
 * @version 11/17/2023
 */
public class BinarySearchTreeNode<E extends Comparable<E>>
{
    private E data;
    private BinarySearchTreeNode<E> right;
    private BinarySearchTreeNode<E> left;

    /**
     * Constructor for objects of class BinarySearchTreeNode
     */
    public BinarySearchTreeNode(E element)
    {
        data = element;
        right = null;
        left = null;
    }
    
    /**
     * Inserts element into BST using recursion
     *
     * @param  elem the element to be inserted
     */
    public void insert(E element) {
        if (element.compareTo(data) <= 0) {
            if (left == null) { // base case
                left = new BinarySearchTreeNode<E>(element);
            } else {
                left.insert(element);
            }
        } else {
            if (right == null) { // base case
                right = new BinarySearchTreeNode<E>(element);
            } else {
                right.insert(element);   
            }
        }
    }
    
    /**
     * Searches for and return matching element using recursion
     *
     * @param  elem the element to be searched
     * @return the searched element
     */
    public E search(E element) {
        if (data == element) { // base case
            return data;
        } else {
            if (element.compareTo(data) <= 0) {
                if (left != null) {
                    return left.search(element);
                }
            } else {
                if (right != null) {
                    return right.search(element); 
                }
            }
        }
        return null;
    }
    
    /**
     * Returns the minimum element in BST using recursion
     *
     * @return the minimum element
     */
    public E getMin() {
        if (left == null) { // base case
            return data;
        } else {
            return left.getMin();
        }
    }
    
    /**
     * Returns the maximum element in BST using recursion.
     *
     * @return the maximum element
     */
    public E getMax() {
        if (right == null) { // base case
            return data;
        } else {
            return right.getMax();
        }
    }
}
