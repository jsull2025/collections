import java.awt.RenderingHints;
import java.util.EmptyStackException;

/**
 * Write a description of class testStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testStack
{
    // instance variables - replace the example below with your own
    private MyStack testStack;

    /**
     * Constructor for objects of class testStack
     */
    public testStack()
    {
        // initialise instance variables
        testStack = new MyStack();
    }

     /**
     * Tests the implementation of the stack
     */
    public void testStack() {
       System.out.println(testStack.isEmpty());
       testStack.push(3);
       System.out.println(testStack.toString());
       testStack.push(4);
       testStack.push(5);
       testStack.push(6);
       System.out.println(testStack.isFull());
       System.out.println(testStack.isEmpty());
       testStack.push(7);
       testStack.push(8);
       testStack.push(9);
       testStack.push(10);
       System.out.println(testStack.toString()); 
       System.out.println(testStack.pop()); 
       testStack.pop();
       testStack.pop();
       testStack.pop();
       System.out.println(testStack.toString()); 
       
       
    }
    public static void tester() {
        MyStack<String> stack = new MyStack();
        
        try {
            System.out.println(stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("pop too many times");
        }
        System.out.println("hi");
    }
}
