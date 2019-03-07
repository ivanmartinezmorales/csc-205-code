import java.util.ArrayList;
import java.util.EmptyStackException;


/* Instructions: Write a class called ClassworkStack.
*               -Uses generics
*               -Implements push, pop(), peek(), isEmpty(), size()
*               - pop() and peek() throw a new EmptyStackException() if stack is empty
* ClassworkStack is due at the next class period at the end of class.*/


public class Stack<E> {
    // data
    private ArrayList<E> stack;

    // constructor - only uses default constructor
    public Stack() {
        this.stack = new ArrayList<>();
    }

    // methods - for peek and pop, if the arraylist is empty, then throw EmptyStackException
    // Push adds an element to the top of the stack.
    public void push(E element) {
        stack.add(element);
    }

    // Pop returns and removes the top item from the stack. Throws EmptyStackException
    // if the stack is empty.
    public E pop() throws EmptyStackException {
        if (stack.isEmpty())
            throw new EmptyStackException();

        // returns the top item by getting the last item in the stack.
        return stack.remove(stack.size()-1);
    }

    // Peek() - grabs the element of the stack at a given index, returning the object
    public E peek() throws EmptyStackException {
        int size = this.size();

        if (stack.isEmpty())
            throw new EmptyStackException();

        else
            return this.stack.get(size-1);
    }

    // isEmpty() - checks if the stack is empty, returns true if empty.
    public boolean isEmpty() {

        return stack.isEmpty();
    }

    // size() - checks the size of the stack and returns the value as an int.
    public int size() {

        return stack.size();
    }

}
