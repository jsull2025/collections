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
        if (head == null) { // empty use case
            head = newNode;   
            tail = newNode;
        } else { // not empty use case
           newNode.setNext(head);
           head.setPrev(newNode);
           head = newNode;
        }
        size++;
        integrityCheck();
    }
    
    /**
     * Adds element to back of list.
     *
     * @param elem the element at back of list
     */
    public void addTail(E elem) {
        if (head == null) { // empty use case
            addHead(elem);
        } else { // not empty use case
            Node<E> newNode = new Node(elem);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;   
        }
        integrityCheck();
    }
    
    /**
     * Inserts element at specified index.
     *
     * @param index the index of element
     * @param element the element added to list
     * @throws NoSuchElementException if index is outside the list
     */
    public void add(int index, E element) throws NoSuchElementException {
        if (index > size || index < 0) { // validation
            throw new NoSuchElementException();
        } else {
            if (index == 0) { // add to front use case
                addHead(element);
            } else if (index == size) { // add to back use case
                addTail(element);
            } else { // add in middle use case
                Node<E> cur = findNode(index - 1);
                size++;
                Node<E> newNode = new Node(element);
                newNode.setPrev(cur);
                newNode.setNext(cur.getNext());
                cur.setNext(newNode);
                newNode.getNext().setPrev(newNode);
            }
        }
        integrityCheck();
    }
    
    /**
     * Traverses the list to find node at certain index
     *
     * @param index the index of the node to be found
     * @return Node at that index in list
     */
    private Node findNode(int index) {
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
        integrityCheck();
        return cur;
    }
    
    private void integrityCheck() {
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (cur == head && cur == tail) {
                if (!((cur.getPrev() == null) && (cur.getNext() == null))) {
                    System.out.println("error");
                }
            } else if (cur == head) {
                if (!((cur.getPrev() == null) && (cur.getNext().getPrev() == cur))) {
                    System.out.println("error");
                }
            } else if (cur == tail) {
                if (!((cur.getNext() == null) && (cur.getPrev().getNext() == cur))) {
                    System.out.println("error");
                }
            } else {
                if (!((cur.getNext().getPrev() == cur) && (cur.getPrev().getNext() == cur))) {
                    System.out.println("error");
                }
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
        integrityCheck();
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
        integrityCheck();
    }
    
    /**
     * Removes element at front of list
     * 
     * @return removed element
     * @throws NoSuchElementException if list empty
     */
    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) { // empty list use case
            throw new NoSuchElementException();
        } else { 
            Node<E> temp = head;
            head = head.getNext();
            if (head == null) { // only 1 element use case
                tail = null;
            } else { // multiple element use case 
                head.setPrev(null);
            }
            size--;
            temp.setNext(null);
            E data = temp.getData();
            temp.setData(null);
            integrityCheck();
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
        if (index >= size || index < 0) { // validation
            throw new NoSuchElementException();
        } else {
            if (index == 0) { // remove front use case
                return removeHead();
            } else {
                Node<E> cur = findNode(index - 1);
                Node<E> temp = cur.getNext();
                E data = temp.getData();
                cur.setNext(cur.getNext().getNext());
                temp.setData(null);
                temp.setNext(null);
                temp.setPrev(null);
                if (temp == tail) { // remove back use case
                    tail = cur;
                } else {
                    cur.getNext().setPrev(cur);
                }
                size--;
                integrityCheck();
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
        while (!(index == size || element.compareTo(cur.getData()) == 0)) { 
            cur = cur.getNext();
            index++;
        }
        integrityCheck();
        if (index == size) { // not found use case
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
        if (isEmpty()) { // empty use case
            throw new NoSuchElementException();
        } else { // not empty use case
            integrityCheck();
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
        if (index >= size || index < 0) { // validation
            throw new NoSuchElementException();
        } else {
            Node<E> cur = findNode(index);
            integrityCheck();
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
        if (index >= size || index < 0) { // validation
            throw new NoSuchElementException();
        } else {
            Node<E> cur = findNode(index);
            cur.setData(element);  
        }
        integrityCheck();
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
        integrityCheck();
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
        integrityCheck();
        return s;
    }
}