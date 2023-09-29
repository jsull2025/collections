import java.util.Arrays;
/**
 * Creates a new Queue implementation that is used as a data structure
 * to organize and move data. A queue is performed in first in first out 
 * (FIFO) where the element is added to the back of the queue and the 
 * element is removed at the front of the queue.
 *
 * @author Jiun
 * @version 9/22
 */
public class MyQueue<E>
{
    private E[] queue; 
    private int size;
    private int back;
    private int front;

    /**
     * Constructs a new Queue given a queue size
     * 
     * @param queueSize the size of the queue
     */
    public MyQueue() {
        queue = (E[]) new Object[100];
        size = 0;
        back = 0;
        front = 0;
    }

    /**
     * Puts a given element into the back of the queue
     *
     * @param element the element to be added to the queue
     */
    public void enqueue(E element) throws IndexOutOfBoundsException {
        if (size == queue.length) {
            throw new IndexOutOfBoundsException();
        } else {
            if (back == queue.length) {
                back = 0;
            }
            queue[back] = element;
            size++;
            back++;
        }
    }
    
    /**
     * Removes the front element in the queue
     * 
     * @return the integer of the removed object
     */
    public E dequeue() {
        if (front == queue.length) {
            front = 0;
        }
        front++;
        size--;
        E dequeue = queue[front];
        queue[front] = null;
        return dequeue;
    }
    
    /**
     * Checks if the queue is empty
     * 
     * @return true if the queue is empty and false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Gives the element that is in the front of the queue
     * 
     * @return the element at the front of the queue
     */
    public E front() {
        return queue[front];
    }
    
    /**
     * Returns the size of the queue
     * 
     * @return the size of the current queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Indicates if the queue cannot add more elements in the queue
     * 
     * @return true if the queue is full and false if not
     */
    public boolean isFull() {
        return size == queue.length;
    }
    
    /**
     * Returns the entire queue from front to back in a string
     * 
     * @return the elements in the queue from front to back as a string
     */
    public String toString() {
        String printQueue = "";
        int cur = front;
        for (int i = 0; i < size; i++) {
            if (cur == queue.length) {
                cur = 0;
            }
            if (i == 0) {
                printQueue += queue[cur];
            } else {
                printQueue += ", " + queue[cur];
            }
            cur++;
        }
        
        return printQueue;
    }
    
}
