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
    
      /**     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int maxSize = (int) Math.pow(2, (getDepth() + 1));
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, 0, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, getDepth()) * (maxElementWidth + 1);
        for (int i = 0; i < getDepth() + 1; i++) {
            String connectionsLevel = "";
            String elementsLevel = "";

            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1; j++) {

                // Process arrows for this level
                String arrow = "  ";
                int elementLength = arrow.length();
                if (elements[j] != null) {
                    if (j % 2 == 1) { // Odd is left child
                        arrow = " /";
                    } else { // Even is right child
                        arrow = "\\ ";
                    }
                }

                // Center within maxElementWidth
                String leftPadStr = ""; // Default
                String rightPadStr = ""; // Default
                int leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                int rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }
                connectionsLevel += leftPadStr + arrow + rightPadStr;

                // Process elements for this level
                elementLength = 0;
                if (elements[j] != null) {
                    elementLength = elements[j].toString().length();
                }

                // Center within maxElementWidth
                leftPadStr = ""; // Default
                rightPadStr = ""; // Default
                leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }

                if (elements[j] != null) {
                    elementsLevel += leftPadStr + elements[j] + rightPadStr;
                } else {
                    elementsLevel += leftPadStr + rightPadStr;
                }
            }

            if (i > 0) { // Do not print arrows for root
                System.out.println(connectionsLevel);
            }
            System.out.println(elementsLevel);
        }
    }

    // build array of element strings
    private void printTree(String[] elements, int nodeNum, int maxElementWidth) {
        elements[nodeNum] = data.toString();
        if (elements[nodeNum].length() > maxElementWidth) {
            elements[nodeNum] = elements[nodeNum].substring(0, maxElementWidth);
        }
        if (left != null) {
            left.printTree(elements, (nodeNum + 1) * 2 - 1, maxElementWidth);
        }
        if (right != null) {
            right.printTree(elements, (nodeNum + 1) * 2, maxElementWidth);
        }
    }
    
    public BinarySearchTreeNode removeMax() {
        if (right == null) { // base case
            if (left == null) {
                data = null;
                return null;
            } else {
                return left;
            }
        } else {
            return right.removeMax();
        }
    }
    
    public BinarySearchTreeNode remove(E element) {
        if (data == element) { // base case
            if (left == null && right == null) {
                return null;
            } else if (left != null && right == null) {
                return left;
            } else if (left == null && right != null){
                return right;
            } else { // 2 children
                data = left.getMax();
                return left.removeMax();
            }
        } else {
            if (element.compareTo(data) <= 0) {
                if (left != null) {
                    left = left.remove(element);
                }
            } else {
                if (right != null) {
                    right = right.remove(element); 
                }
            }
        }
        
        return this;
    }
    
    public int getDepth() {
        int depth = 1;
        if (left == null && right == null) {
            return depth;
        } else if (left != null && (right == null || 
                        left.getDepth() > right.getDepth())) {
            return depth + left.getDepth();
        } else {
            return depth + right.getDepth();
        }
    }
    
    public String toString() {
        String s = "";
        if (left != null) {
            s += left.toString() + ", ";
        } 
        s += data;
        if (right != null) {
            s += ", " + right.toString();
        } 
        return s;
    }
    
}
