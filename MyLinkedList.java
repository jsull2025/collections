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
     * Adds a new head node at the front of the list 
     *
     * @param elem the data of the added head
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
     * Gets the data of the node at the front of the list.
     *
     * @return the data of the head node
     */
    public E getHead() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head.getData();
        }
    }

    /**
     * Removes the node at the front of the list.
     *
     * @return the data of the removed node
     */
    public E removeHead() throws NoSuchElementException {
        if (head == null) {
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
     * Returns the size of the linked list
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty and false if the list is not
     *
     * @return true if list is empty and false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds a node at the back of the list.
     *
     * @param elem the data of the added tail node
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
     * Returns the linked list as a string of the data from head to tail.
     *
     * @return the linked list as a string
     */
    public String toString() {
        String s = "";
        if (head == null) {
            return s;
        } else {
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
}
