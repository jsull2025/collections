import java.util.NoSuchElementException;

/**
 * Creates a new MyLinkedList implementation with a generic type that is 
 * used as a data structure to organize, move and change data. This list 
 * can create nodes at the front and the back of the list and removes the
 * node at the front. This is a doubly Linked list, meaning each node will
 * be able to traverse backwards and forwards.
 *
 * @author Jiun
 * @version 11/13/2023
 */
public class MyLinkedList<E extends Comparable<E>>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs a new MyLinkedList as an empty list.
     */
    public MyLinkedList()
    {
        head = null;
        tail = null;
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
            tail = newNode;
        } else {
           newNode.setNext(head);
           head.setPrev(newNode);
           head = newNode;
        }
        size++;
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
            Node<E> newNode = new Node(elem);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;   
        }
    }
    
    /**
     * Inserts element at specified index.
     *
     * @param index the index of element
     * @param element the element added to list
     * @throws NoSuchElementException if index is outside the list
     */
    public void add(int index, E element) throws NoSuchElementException {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else {
            if (index == 0) {
                addHead(element);
            } else if (index == size) {
                addTail(element);
            } else {
                Node<E> cur = findIndexNode(index - 1);
                size++;
                Node<E> newNode = new Node(element);
                newNode.setPrev(cur);
                newNode.setNext(cur.getNext());
                cur.setNext(newNode);
                newNode.getNext().setPrev(newNode);
            }
        }
    }
    
    /**
     * Adds element to end of list
     *
     * @param elem the element added
     */
    public void add(E element) {
        addTail(element);
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
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            size--;
            temp.setNext(null);
            E data = temp.getData();
            temp.setData(null);
            return data;
        }
    }
    
    /**
     * Removes and returns element at specified index.
     *
     * @param index the index of element
     * @return element that is removed
     * @throws NoSuchElementException if index is outside the list
     */
    public E remove(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            if (index == 0) {
                return removeHead();
            } else {
                
                Node<E> cur = findIndexNode(index - 1);
                Node<E> temp = cur.getNext();
                E data = temp.getData();
                cur.setNext(cur.getNext().getNext());
                temp.setData(null);
                temp.setNext(null);
                temp.setPrev(null);
                if (temp == tail) {
                    tail = cur;
                } else {
                    cur.getNext().setPrev(cur);
                }
                size--;
                return data;
            }
        } 
    }
    
    /**
     * Removes and returns first occurrence of matching element.
     *
     * @param element the element to be removed
     * @return element that is removed
     */
    public E remove(E element) {
        Node<E> cur = head;
        int index = 0;
        while (!(element.compareTo(cur.getData()) == 0 || index == size)) {
            cur = cur.getNext();
            index++;
        }
        if (index == size) {
            return null;
        }
        return remove(index);
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
     * Returns element at specified index.
     *
     * @param index the index of element
     * @return element at specific index
     * @throws NoSuchElementException if index is outside the list
     */
    public E get(int index) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            
            Node<E> cur = findIndexNode(index);
            return cur.getData();   
        }
    }
    
    /**
     * Replaces existing element at specified index.
     *
     * @param index the index of element
     * @param element the element to replace
     * @throws NoSuchElementException if index is outside the list
     */
    public void set(int index, E element) throws NoSuchElementException {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Node<E> cur = findIndexNode(index);
            cur.setData(element);  
        }
    }
    
    private Node findIndexNode(int index) {
        Node<E> cur = head;
        if (size/2 > index) {
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
        } else {
            cur = tail;
            for (int i = size() - 1; i > index; i--) {
                cur = cur.getPrev();
            }
        }
        return cur;
    }
    
    /**
     * Inserts element into list.
     *
     * @param element the element insorted in order
     */
    public void insertSorted(E element) {
        Node<E> cur = head;
        int index = 0;
        while (cur != null && element.compareTo(cur.getData()) > 0) {
            cur = cur.getNext();
            index++;
        }
        add(index, element);
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
