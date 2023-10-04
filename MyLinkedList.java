import java.util.NoSuchElementException;

/**
 * Creates a new MyLinkedList implementation with a generic type that is 
 * used as a data structure to organize, move and change data. This list 
 * can create nodes at the front and the back of the list and removes the
 * node at the front.
 *
 * @author Jiun
 * @version 10/2/2023
 */
public class MyLinkedList<E>
{
    
    private Node<E> head;
    private int size;

    /**
     * Constructs a new MyLinkedList as an empty list.
     */
    public MyLinkedList()
    {
        head = null;
        size = 0;
    }

    /**
     * Adds element at front of list 
     *
     * @param elem the element at front of list
     */
    public void addHead(E elem) {
        Node<E> newNode = new Node(elem);
        if (head == null) {
            head = newNode;   
        } else {
           newNode.setNext(head);
           head = newNode;
        }
        size++;
    }
    
    /**
     * Removes element at front of list
     * 
     * @return removed element
     * @throws NoSuchElementException if list empty
     */
    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<E> temp = head;
            if (head.getNext() == null) {
                head = null;
            } else {
                head = head.getNext();
            }
            size--;
            temp.setNext(null);
            return temp.getData();
        }
    }
    
    /**
     * Get element at front of list
     *
     * @return data at front of list
     * @throws NoSuchElementException if list empty
     */
    public E getHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getData();
        }
    }
    
    /**
     * Adds element to back of list.
     *
     * @param elem the element at back of list
     */
    public void addTail(E elem) {
        if (head == null) {
            addHead(elem);
        } else {
            Node<E> cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            Node<E> newNode = new Node(elem);
            cur.setNext(newNode);
            size++;   
        }
    }

    /**
     * Returns size of list
     *
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if list empty or false if not
     *
     * @return true if list empty or false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns list as string of elements from front to back.
     *
     * @return list as string from front to back
     */
    public String toString() {
        String s = "";
        Node<E> cur = head;
        while (cur != null) {
            if (cur == head) {
                s += cur.getData();
            } else {
                s += ", " + cur.getData(); 
            }
            cur = cur.getNext();
        }
        return s;
    }
}
