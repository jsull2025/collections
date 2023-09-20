import java.util.Arrays;
/**
 * Write a description of class MyQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue
{
    // instance variables - replace the example below with your own
    private int[] queue;
    private int size;
    private int maxSize;
    private int back;
    private int front;

    /**
     * Constructor for objects of class MyQueue
     */
    public MyQueue(int queueSize)
    {
        // initialise instance variables
        queue = new int[queueSize];
        size = 0;
        maxSize = queueSize;
        back = 0;
        front = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void enqueue(int element) {
        if (back == maxSize) {
            back = 0;
        }
        queue[back] = element;
        size++;
        back++;
    }
    
    public int dequeue() {
        if (front == maxSize) {
            front = 0;
        }
        int popNum = queue[front];
        front++;
        size--;
        return popNum;
    }
    
    public boolean isEmpty() {
        
        if (size == 0) {
            return true;
        } else {
            return false;
        }
        
        
    }
    
    public int front() {
        return queue[front];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isFull() {
        if (size == maxSize) {
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        int[] newArr = new int[size];
        int cur = front;
        for (int i = 0; i < size; i++) {
            if (cur == maxSize) {
                cur = 0;
            }
            newArr[i] = queue[cur];
            cur++;
        }
        
        return Arrays.toString(newArr);
    }
     public void testQueue() {
        System.out.println(isEmpty());
        enqueue(1);
        System.out.println(toString());
        System.out.println(isEmpty());
        System.out.println(isFull());
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        System.out.println(toString());
        System.out.println(isEmpty());
        System.out.println(isFull());
        System.out.println(front());
        int i = dequeue();
        System.out.println(i);
        dequeue();
        dequeue();
        enqueue(9);
        System.out.println(toString());
        System.out.println(isEmpty());
        System.out.println(isFull());
        System.out.println(front());
        dequeue();
        dequeue();
        dequeue();
        enqueue(3);
        enqueue(4);
        enqueue(5);
        dequeue();
        dequeue();
        System.out.println(toString());
        System.out.println(isEmpty());
        System.out.println(isFull());
        System.out.println(front());
    }
}
