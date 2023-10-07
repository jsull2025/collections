
/**
 * Write a description of class MyStackLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStackLL<E>
{
    
    private MyLinkedList<E> list;

    /**
     * Constructor for objects of class MyStackLL
     */
    public MyStackLL()
    {
        list = new MyLinkedList();
    }

    /**
     * Put given element on top of stack     
     * 
     * @param element added to top of stack
     */
    public void push(E element) {
        list.addHead(element);
    }
    
    /**
     * Remove top element in stack
     * 
     * @return element of removed top element
     */
    public E pop() {
        return list.removeHead();
    }
    
    /**
     * Return element at top of stack
     * 
     * @return element at top of stack
     */
    public E top() {
        return list.getHead();
    }
    
    /**
     * Checks if stack is empty
     * 
     * @return true if stack is empty or false if not
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * Indicates whether stack has exhausted its available storage
     * 
     * @return true if stack is full or false if not
     */
    public boolean isFull() {
        return false;
    }
    
    /**
     * Returns size of stack
     * 
     * @return size of stack
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns contents of stack from top to bottom
     * 
     * @return contents of stack from top to bottom
     */
    public String toString() {
        return list.toString();
    }
}
