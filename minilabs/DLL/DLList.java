/**
 * This program was written to convert a Singly Linked List into a doubly linked list.
 * This program was written by Ivan Martinez Morales and is due on April 4, 2019.
 * 
 * The program includes the following methods:
 *  1.  addFirst - adding an element to the top of the list.
    2.  TODO: removeFirst - removing the head of the list.
    3.  TODO: removeLast - removing the last element in the list.
    4.  TODO: add - Adding an element to position n
    5.  TODO: remove - removing n element from the list.
 */

 import java.util.NoSuchElementException;

 public class DLList {

     // DATA
    protected Node<E> head;
    protected Node<E> tail;

     // CONSTRUCTORS
     /**
      * Basic DLL constructor features an empty linked list.
      */
    public DLList() {
        head = tail = null;
    }

     // METHODS
     /**
      * addFirst adds an element to the front of the list.
      * @param data - data to be placed into the list.
      */
    public void addFirst(E data) {
        
        Node<E> temp = new Node<E>(data);
        // CASE 1. List is empty
        if (head==null) {

            head = tail = temp;
            temp.prev = null; // Make the previous term null.

        } else {

            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    /**
     * addLast - appends a node to the end of the list.
     * @param data
     */
    public void addLast(E data) {

        Node<E> temp = new Node<E>(data);

        // CASE 1: The list is empty.
        if (head == null) {

            head = tail = temp;

        } else { // CASE 2: the list contains elements.
            
            temp.prev = tail;
            tail.next = temp;
            tail = temp;

        }
    }

    /**
     * Removes the first element in the Doubly Linked List and returns it.
     * @return formerHead
     * @throws NoSuchElementException if the list is empty.
     */
    public E removeFirst() throws NoSuchElementException {
        
        // CASE 1: the list is empty
        if (head == null) {
            throw NoSuchElementException;
        }
        // CASE 2: the list contains one element
        else if (size() == 1)
        // CASE 3: the list contains many elements
        return E;
    }

    /**
     * Measures the size of the Doubly Linked List and returns it as an integer.
     * @return the size of the Doubly Linked List.
     */
    public int size() {
        int size = 0;
        Node<E> cursor = head;

        while (cursor != null) {
            size++;
            cursor = cursor.next;
        }

        return size;
    }

    /**
     * Checks to see if the list is empty based on if the head is null.
     * @returns Returns whether or not the list is empty.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Finds and returns the first element in the Doubly Linked List.
     * @return head.data - the first element in the list.
     */
    public E getFirst() {
        
    }

    /**
     * Finds and returns the last element in the list.
     */
    /**************************************************************
     * Inner class Node is used to create the Doubly Linked List.
     **************************************************************/
    private class Node<E> {
        // DATA
        protected E data;
        protected Node<E> next;
        protected Node<E> prev;
        //CONSTRUCTORS
        public Node(E data) {
            this.data = data;
            this.next = this.prev = null;
        }
        // METHODS
        public String toString() {
            return this.data.toString();
        }
    }
}



/**
 * import java.util.NoSuchElementException;

public class DLList<E> {

    protected DLLNode<E> head;
    protected DLLNode<E> tail;

    // constructor:
    public DLList() {
        head = tail = null;
    }

    // methods:
    // addFirst() - adds a new DLLNode to the front of the list
    public void addFirst(E theData) {
        // first, create a new node for the data
        DLLNode<E> theNode = new DLLNode<E>(theData);

        // case 1: is the list empty?
        if (head == null) {
            head = tail = theNode;
            theNode.prev = null; // make the previous term null
        }

        // case 2: if its not empty, put the node in the front and slide over
        else {
            theNode.next = head;
            head.prev = theNode;
            head = theNode;
        }
    }
    // addLast() - adds a new DLLNode to the end of the list.
    public void addLast(E theData) {
        DLLNode<E> theNode = new DLLNode<E>(theData);
        DLLNode<E> cursor = head;

        if (tail == null) {
            head = tail = theNode;
            theNode.next = theNode.prev = null;
        } else {
            theNode.prev = tail;
            tail.next = theNode;
            tail = theNode;
        }
    }
    // remove() - remove
    public boolean remove(Object elt) {
        // case 1: is it on the list?
        if (!this.contains(elt)) {
            return false;
        }
        // case 2: if the size of the linked list is 1
        //         and the elt is in our linked list,
        //         we can safely assume that it is the head
        //         so we remove it, and return true.
        if (size() == 1) {
            head = tail = null;
            return true;
        }
        // case 3: if the head is equal to the element, then we can call removeFirst
        if (head.data.equals(elt)) {
            removeFirst();
        }

        // case 4: if the tail is equal to the element, then we can remove it
        else if (tail.data.equals(elt)) {
            removeLast();
        }
        // case 5: now if it is not in the head or tail, then traverse list
        else {
            DLLNode<E> cursor = head;
            while(!elt.equals(cursor.next.data)) {
                cursor = cursor.next;
            }
        }
        return true;
    }
    // removeFirst() - removes the first element in the DLL and returns it.
    public E removeFirst() {
        // case 1: list is empty
        if (head == null) {

            throw new NoSuchElementException("Can't remove an element that doesn't exist!");
        }
        // case 2: the list has one element
        else if (size() == 1) {

            E savedElt = head.data;
            head = tail = null;
            return savedElt;
        }
        // case 3: the list has many elements
        else {

            E savedElt = head.data;
            head = head.next;
            head.prev = null;
            return savedElt;
        }
    }
    // removeLast() - removes the last element in the DLL and returns it
    public E removeLast() {
        // case 1: is there even a list?
        if (head == null)
            throw new NoSuchElementException("Can't remove what doesn't exist!");

        // case 2: does the list have only one element?
        else if (size() == 1) {
            E savedElt = tail.data;
            head = tail = null;
            return savedElt;
        }
        else {

        }
        return null;
    }
    // size() - returns an integer with the length of the DLL
    public int size() {
        int size = 0;
        DLLNode<E> cursor = head;
        while (cursor != null) {
            size++;
            cursor = cursor.next;
        }
        return size;
    }
    // isEmpty() - returns a boolean that determines if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    //getFirst() - returns the first element in the list
    public E getFirst() {
        // case 1: check if empty
        if (head == null)
            throw new NoSuchElementException("can't get first element!");
        return head.data;
    }
    //getLast() - returns the last element in the list
    public E getLast() {
        // case 1: is list empty?
        if (head == null) {
            throw new NoSuchElementException("The element does not exist - the list is empty");
        }

        return tail.data;
    }
    // contains() - returns true if list contains the element that is recieved
    public boolean contains(Object elt) {
        DLLNode<E> cursor = null;
        while (cursor != null) {
            if (cursor.data.equals(elt))
                return true; // found the element
            cursor = cursor.next;
        }
        return false;
    }
    // add() - inserts an element at specified index
    public void add(int index, E elt) {
        // case 1: is index within reason?
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("Index" + index + "is out of bounds!");
        }

        // case 2: is index 0?
        if (index == 0)
            addFirst(elt);
        // case 3: is index the size of the list?
        else if (index == size())
            addLast(elt);
        else {
            DLLNode<E> theNode = new DLLNode<E>(elt);
            DLLNode<E> cursor = head;

            for (int i=1; i < index; i++) {
                cursor = cursor.next;

            }
            theNode.prev = cursor;
            theNode.next = cursor.next;
            cursor.next = theNode;

        }
    }
    // toString() - returns DLL representation as a String
    public String toString() {
        String answer = "";

        DLLNode<E> cursor = head;
        while (cursor!= null) {
            answer = answer + cursor.toString() + "-->";
            cursor = cursor.next;

        }

        answer = answer + "(null)";

        return answer;
    }
    // inner class - DLLNode
    class DLLNode<E> {
        // data
        protected E data;
        protected DLLNode<E> prev;
        protected DLLNode<E> next;

        // constructor
        public DLLNode(E theData) {
            data = theData;
            next = null;
            prev = null;
        }

        // methods
        // toString() - returns string representation of Node.
        public String toString() { return this.data.toString();}

    } // end of DLLNode class.
}

 */