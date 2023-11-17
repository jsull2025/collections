/**
 * Creates a new BinarySearchTree implementation with a generic type 
 * that is used as a data structure to insert and search elements. 
 * This tree will have smaller elements to the left and bigger elements 
 * to the right as it is inserted
 *
 * @author jiun
 * @version 11/17/2023
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private BinarySearchTreeNode<E> root;
    private int size;

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }

    /**
     * Inserts element into BST
     *
     * @param  elem the element to be inserted
     */
    public void insert(E elem) {
        if (root == null) {
            root = new BinarySearchTreeNode<E>(elem);
        } else {
            root.insert(elem);
        }
        size++;
    }
    
    /**
     * Searches for and return matching element.
     *
     * @param  elem the element to be searched
     * @return the searched element
     */
    public E search(E elem) {
        if (root == null) {
            return null;
        } else {
            return root.search(elem);
        }
    }
    
    /**
     * Returns the minimum element in BST.
     *
     * @return the minimum element
     */
    public E getMin() {
        return root.getMin();
    }
    
    /**
     * Returns the maximum element in BST.
     *
     * @return the maximum element
     */
    public E getMax() {
        return root.getMax();
    }
    
    public E remove(E element) {
        if (root == null) {
            return null;
        } else if (search(element) == null) {
            return null;
        }
        E removeElement = root.search(element); 
        root = root.remove(element);
        size--;
        return removeElement;
        
    }
    
    /**
     * Indicates whether BST is empty.
     *
     * @return true if empty and false if not empty
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Returns the number of elements in BST.
     *
     * @return size of BST
     */
    public int size() {
        return size;
    }
    
    public String toString() {
        return root.toString();
    }
    
    public int getDepth() {
        return root.getDepth();
    }
}
