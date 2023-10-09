/**
 * Creates a new Queue implementation that is used as a data structure
 * to organize and move data using nodes. A queue is performed in first in 
 * first out (FIFO) where the element is added to the back of the queue 
 * and the element is removed at the front of the queue.
 *
 * @author Jiun
 * @version 10/9/23
 */
public class MyQueueLL<E>
{
    
    private MyLinkedList<E> list;

    /**
     * Constructs a new queue
     */
    public MyQueueLL()
    {
        list = new MyLinkedList();
    }

    /**
     * Adds an element to back of queue
     *
     * @param element to be added to back of queue
     */
    public void enqueue(E element) {
        list.addTail(element);
    }

    /**
     * Removes an element from the front of the queue
     *
     * @return the removed element
     */
    public E dequeue() {
        return list.removeHead();
    }

    /**
     * Reads the element at the front of the queue
     *
     * @return the front element
     */
    public E front() {
        return list.getHead();
    }

    /**
     * Indicates whether queue contains any elements
     *
     * @return true if empty or if not empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Indicates whether the queue has exhausted its available storage
     *
     * @return true if full or false if not full
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Returns the number of elements stored in the queue
     *
     * @return size of queue
     */
    public int size() {
        return list.size();
    }
     
    /**
     * Returns the contents of the queue from front to back
     *
     * @return contents of queue as string from front to back
     */
    public String toString() {
        return list.toString();
    }
}
