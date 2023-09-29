
/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class MyLinkedList
{
    // instance variables - replace the example below with your own
    private Node head;
    private int size;

    /**
     * Constructor for objects of class LinkedList
     */
    public MyLinkedList()
    {
        // initialise instance variables
        head = null;
        size = 0;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addHead(int elem)
    {
        // put your code here
        
        Node newNode = new Node(elem);
        if (head == null) {
            head = newNode;   
        } else {
            
           newNode.setNext(head);
           head = newNode;
            
        }
        size++;
        
    }
    
    public int getHead() {
        return head.getData();
    }
    
    public int removeHead() {
        Node temp = head;
        if (head.getNext() == null) {
            head = null;
        } else {
            head = head.getNext();
        }
        size--;
        return temp.getData();
    }
    
    public int getSize() {
        return size;
    }
    
    
    
    public String toString() {
        String s = "";
        if (head == null) {
            return s;
        } 
        Node cur = head;
        
        while (cur != null) {
            if (cur == head) {
                s += cur.getData();
            } else {
                s += ", " + cur.getData(); 
            }
            
            cur = cur.getNext();
        }
        
        return s;
    }
}
