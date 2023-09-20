
import java.util.Arrays;
/**
 * Write a description of class MyStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStack
{
    // instance variables - replace the example below with your own
    private int[] stack;
    private int size;
    private int maxSize;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack(int sizeStack)
    {
        // initialise instance variables
        stack = new int[sizeStack];
        size = 0;
        maxSize = sizeStack;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void push(int element) {
        stack[size] = element;
        size++;
    }
    
    public int pop() {
        size--;
        int popNum = stack[size];
        return popNum;
    }
    
    public boolean isEmpty() {
        
        if (size == 0) {
            return true;
        } else {
            return false;
        }
        
        
    }
    
    public int top() {
        return stack[size];
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
        int index = size - 1;
        for (int i = 0; i < size; i++) {
            newArr[i] = stack[index];
            index--;
        }
        
        return Arrays.toString(newArr);
    }
    
    public void testStack() {
        System.out.println(isEmpty());
        push(3);
        System.out.println(isEmpty());
        push(4);
        System.out.println(isFull());
        push(3);
        push(4);
        push(5);
        System.out.println(isFull());
        int pop = pop();
        System.out.println(pop);
        System.out.println(toString());
        
        
    }
}
