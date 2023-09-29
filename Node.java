
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int data;
    private Node next;
    
    /**
     * Constructor for objects of class Node
     */
    public Node(int element)
    {
        // initialise instance variables
        data = element;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getData()
    {
        // put your code here
        return data;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setData(int d) {
        data = d;
    }
    
    public void setNext(Node n) {
        next = n;
    }
    
}
