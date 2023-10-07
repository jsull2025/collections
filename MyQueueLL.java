
/**
 * Write a description of class MyStackLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueueLL<E>
{
    
    private MyLinkedList<E> list;

    /**
     * Constructor for objects of class MyStackLL
     */
    public MyQueueLL()
    {
        list = new MyLinkedList();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void enqueue(E element) {
        list.addTail(element);
    }
    
    public E dequeue() {
        return list.removeHead();
    }
    
    public E front() {
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
