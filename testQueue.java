
/**
 * Write a description of class testQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testQueue
{
    // instance variables - replace the example below with your own
    private MyQueue testQueue;


    /**
     * Constructor for objects of class testQueue
     */
    public testQueue()
    {
        // initialise instance variables
        testQueue = new MyQueue();
    }

    /**
     * Tests the implementation of the queue
     */
    public void testQueue() {
        System.out.println(testQueue.isEmpty());
        testQueue.enqueue(1);
        System.out.println(testQueue.toString());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.isFull());
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        testQueue.enqueue(5);
        System.out.println(testQueue.toString());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.isFull());
        System.out.println(testQueue.front());
        System.out.println(testQueue.dequeue());
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.enqueue(9);
        System.out.println(testQueue.toString());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.isFull());
        System.out.println(testQueue.front());
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        testQueue.enqueue(5);
        testQueue.dequeue();
        testQueue.dequeue();
        System.out.println(testQueue.toString());
        System.out.println(testQueue.isEmpty());
        System.out.println(testQueue.isFull());
        System.out.println(testQueue.front());
    }
}
