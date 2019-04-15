/**
 * This program was written to convert a Singly Linked List into a doubly linked list.
 * This program was written by Ivan Martinez Morales and is due on April 4, 2019.
 * 
 * The program includes the following methods:
 *  1.  addFirst - adding an element to the top of the list.
    2.  removeFirst - removing the head of the list.
    3.  removeLast - removing the last element in the list.
    4.  add - Adding an element to position n
    5.  TODO: remove - removing n element from the list.
 */

import java.util.NoSuchElementException;

public class DLList<E> {

    // DATA
   protected DLLNode<E> head;
   protected DLLNode<E> tail;

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
       
       DLLNode<E> temp = new DLLNode<E>(data);
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

       DLLNode<E> temp = new DLLNode<E>(data);

       // CASE 1: The list is empty.
       if (head == null) {

           head = tail = temp;

       } 

       // CASE 2: The list contains elements. 
       else {
           
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
   public E removeFirst() {
       
       // CASE 1: the list is empty
       if (head == null) {

           throw new NoSuchElementException("The list is empty, I can't remove anything from it.");
       }

       // CASE 2: the list contains one element
       else if (size() == 1) {

           E savedElement = head.data;
           head = tail = null;
           return savedElement;
       }

       // CASE 3: the list contains many elements
       else {

           E savedElement = head.data;
           head = head.next;
           head.prev = null;
           return savedElement;
       }   
   }

   /**
    * Removes the last element in the Doubly Linked List.
    * @return savedElement
    * @throws NoSuchElementException
    */
   public E removeLast() throws NoSuchElementException {

       // CASE 1: The list is empty
       if (tail == null) {

           throw new NoSuchElementException("The element does not exist.");
       }

       // CASE 2: The list contains one element.
       else if (size() == 1) {

           E savedElement = tail.data;
           head = tail = null;
           
           return savedElement;
       }
       
       // CASE 3: The list contains many elements.
       else {

           E savedElement = tail.data;
           tail = tail.prev;
           tail.next = null;

           return savedElement;
       }
   }
   
   
   /*
   * remove removes a given object from the list, if the item is contained in the list.
   * @return boolean True if the item was found and removed.
   * 
   */
   public boolean remove(Object obj) {
   
       // CASE 1: the element is not in the list.
       if (!this.contains(obj)) {
           return false;
       }
       
       // CASE 2: Is the head equal to the item?
       else if (head.data.equals(obj)) {
           this.removeFirst();
           return true;
       }
       
       // CASE 3: Is the tail equal to the item?
       else if (tail.data.equals(obj)) {
           this.removeLast();
           return true;
       }
       
       // CASE 4: Element is in the list, but is not in the head or tail.
       else {
           DLLNode<E> removedElement = head;
           // TRAVERSE THE LIST UNTIL WE FIND OUR TARGET.
           while (!removedElement.data.equals(obj)) {
               removedElement = removedElement.next;
           }
           
           // NOW THAT WE FOUND OUR TARGET, GO AHEAD AND FIND THE NODE IN FRONT OF IT.
           DLLNode<E> inFrontOf = head;
           while (inFrontOf.next != removedElement) {
               inFrontOf = inFrontOf.next;
           }
           
           // NOW, LET'S FIX THOSE POINTERS AND BERID OURSELVES OF OUR BELOVED ELEMENT.
           
           return true;
       }
   }
   

   /**
    * Adds the element to the list if the index is within the bounds of the list.
    */
   public void add(int index, E element) {

       // CASE 1: is the index in the bounds of the list?
       if (index < 0 || index > size()) {
           throw new IllegalArgumentException("The index is out of bounds!");
       }

       // CASE 2: is the index 0?
       else if (index == 0) {
           addFirst(element);
       }

       // CASE 3: Is the index at the end of the list?
       else if (index == size()) {
           addLast(element);
       }
      
       // CASE 4: The element is deep inside the list... time to infiltrate
       else {
           DLLNode<E> temp = new DLLNode<E>(element);
           
           DLLNode<E> cursor = head;
           for (int i=1; i<index; i++) {
               cursor = cursor.next;
           }

           temp.next = cursor.next;
           cursor.next = temp;
           temp.prev = cursor;
           temp.next.prev = temp;
        //    temp.next = cursor.next;
        //    cursor.next = temp;
        //    cursor.next.next.prev = temp; 
        //    temp.prev = cursor;

       }

   }

   /**
    * Measures the size of the Doubly Linked List and returns it as an integer.
    * @return the size of the Doubly Linked List.
    */
   public int size() {

       int size = 0;
       DLLNode<E> cursor = head;

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
       return head.data;
   }

   /**
    * @return tail.data - the last element in the list.
    */
   public E getLast() {
       return tail.data;
   }

   /**
    * toString() returns a string representation of the Doubly Linked List.
    * @return Returns a string representation of the object.
    */
   public String toString() {

       String answer = null;
       DLLNode<E> cursor = head;

       while (cursor != null) {
           answer = answer + cursor.toString() + "-->";
           cursor = cursor.next;
       }

       // Appending null to the end of the list.
       answer.concat("(null)");
       return answer;
   }

   /**
    * Contains finds if an object is in the Doubly Linked List.
    * @param obj
    * @return true if the object is in 
    */
   public boolean contains(Object obj) {

       DLLNode<E> cursor = head;
       while (cursor != null) {
           if (cursor.data.equals(obj)) {
               return true;
           }
           cursor = cursor.next;
       }
       
       return false;
   }
   
   
   /**************************************************************
    * Inner class Node is used to create the Doubly Linked List.
    **************************************************************/
   protected class DLLNode<E> {

       // DATA
       protected E data;
       protected DLLNode<E> next;
       protected DLLNode<E> prev;

       //CONSTRUCTORS
       public DLLNode(E data) {
           this.data = data;
           this.next = this.prev = null;
       }

       // METHODS
       public String toString() {
           return this.data.toString();
       }
   }
}