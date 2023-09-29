
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Creates a new Stack implementation that is used as a data structure
 * to organize and move data. A stack is performed in last in first out 
 * (LIFO) where the element is added to the top of the stack and the 
 * element is removed at the top of the stack.
 *
 * @author Jiun
 * @version 9/22
 */
public class MyStack<E> {

    private E[] stack;
    private int size;

    /**
     * Constructs a new Stack given a stack size
     * 
     * @param sizeStack the size of the stack
     */
    public MyStack() {
        size = 0;
        stack = (E[]) new Object[100];
    }

    /**
     * Puts a given element on the top of the stack     
     * 
     * @param element the element to be added to the stack
     */
    public void push(E element) throws IndexOutOfBoundsException{
        if (size == stack.length) {
            throw new IndexOutOfBoundsException();
        } else {
            stack[size] = element;
            size++;
        }
    }
    
    /**
     * Removes the top element in the stack
     * 
     * @return the integer of the removed object
     */
    public E pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            size--;
            E pop = stack[size];
            stack[size] = null;
            return pop;  
        }
    }
    
    /**
     * Checks if the stack is empty
     * 
     * @return true if the stack is empty and false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Gives the element that is on the top of the stack
     * 
     * @return the element at the top of the stack
     */
    public E top() {
        return stack[size];
    }
    
    /**
     * Returns the size of the stack
     * 
     * @return the size of the current stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Indicates if the stack cannot add more elements in the stack
     * 
     * @return true if the stack is full and false if not
     */
    public boolean isFull() {
        return size == stack.length;
    }
    
    /**
     * Returns the entire stack from top to bottom in a string
     * 
     * @return the elements in the stack from top to bottom as a string
     */
    public String toString() {
        String stringStack = "";
        int index = size - 1;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringStack += stack[index];
            } else {
                stringStack += ", " + stack[index].toString();
            }
            index--;
        }
        
        return stringStack;
        
    }
    
  
}
