
/**
 * Write a description of class MyHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeap<E extends Comparable<E>>
{
    private E[] arr;
    private int lastNode;

    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap() {
        // initialise instance variables
        arr = (E[]) new Comparable[100];
        lastNode = -1;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void add(E elem) {
        if (isEmpty()) {
            arr[0] = elem;
            lastNode++;
        } else {
            lastNode++;
            int child = lastNode;
            int parent = (child - 1)/2;
            arr[lastNode] = elem;
            while (child != 0 && (elem.compareTo(arr[parent]) < 0)) {
                E temp = arr[parent];
                arr[parent] = elem;
                arr[child] = temp;
                child = parent;
                parent = (child - 1)/2;
            }
        }
    }
    
    public E getMin() {
        return arr[0];
    }
    
    public E removeMin() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            E data = arr[0];
            arr[0] = arr[lastNode];
            arr[lastNode] = null;
            lastNode--;
            int parent = 0;
            int leftChild = 1;
            int rightChild = 2;
            while ((arr[leftChild] != null && 
                    arr[parent].compareTo(arr[leftChild]) > 0) || 
                   (arr[rightChild] != null && 
                    arr[parent].compareTo(arr[rightChild]) > 0)) {
                        
                if (arr[rightChild] == null ||
                    arr[leftChild].compareTo(arr[rightChild]) < 0) {
                    E temp = arr[parent];
                    arr[parent] = arr[leftChild];
                    arr[leftChild] = temp;
                    parent = leftChild;
                } else {
                    E temp = arr[parent];
                    arr[parent] = arr[rightChild];
                    arr[rightChild] = temp;
                    parent = rightChild;
                }
                leftChild = (parent*2) + 1;
                rightChild = (parent*2) + 2;
            }
            return data;
        }
    }
    
    /**
     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int depth = (int) (Math.log(lastNode + 1) / Math.log(2)) + 1;
        int maxSize = (int) Math.pow(2, depth) - 1;
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, depth - 1) * (maxElementWidth + 1);
        for (int i = 0; i < depth; i++) {
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
    private void printTree(String[] elements, int maxElementWidth) {
        for (int i = 0; i <= lastNode; i++) {
            elements[i] = arr[i].toString();
        }
    }
    
    public int size() {
        return lastNode + 1;
    }
    
    public boolean isEmpty() {
        return lastNode == -1;
    }
    
    public String toString() {
        String string = "";
        for (int i = 0; i < size(); i++) {
            if (i == 0) {
                string += arr[i];
            } else {
                string += ", " + arr[i];
            }
        }
        return string;
    }
}
