
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void push(E element) {
        list.addHead(element);
    }
    
    public E pop() {
        return list.removeHead();
    }
    
    public E top() {
        return list.getHead();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean isFull() {
        return false;
    }
    
    public int size() {
        return list.size();
    }
    
    public String toString() {
        return list.toString();
    }
    
    
    
    
    
    
}
