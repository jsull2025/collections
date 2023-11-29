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
        if (root == null) {
            return null;
        } else {
            return root.getMin();
        }
    }
    
    /**
     * Returns the maximum element in BST.
     *
     * @return the maximum element
     */
    public E getMax() {
        if (root == null) {
            return null;
        } else {
            return root.getMax();
        }
    }
    
    /**
     * Prints the tree
     */
    public void printTree() {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            root.printTree(2);   
        }
    }
    
    /**
     * Removes and returns matching element.
     *
     * @param element to be removed
     * @return removed element
     */
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
     * Removes and returns the minimum element.
     *
     * @return minimum element
     */
    public E removeMin() {
        if (root == null) {
            return null;
        } else {
            E removeElement = root.search(getMin());
            remove(getMin());
            return removeElement;
        }
    }
    
    /**
     * Removes and returns the maximum element.
     *
     * @return maximum element
     */
    public E removeMax() {
        if (root == null) {
            return null;
        } else {
            E removeElement = root.search(getMax());
            remove(getMax());
            return removeElement;   
        }
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
    
    /**
     * Returns elements in sorted order.
     *
     * @return the elements in the tree in sorted order
     */
    public String toString() {
        if (root == null) {
            return "";
        } else {
            return root.toString();   
        }
    }
    
    /**
     * Returns number of levels in BST.
     *
     * @return the levels in BST
     */
    public int getDepth() {
        if (root == null) {
            return 0;
        } else {
            return root.getDepth();    
        }
    }
}
