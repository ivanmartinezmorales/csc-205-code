/*
This demo will implement (and explain) a Queue class.
A Queue is a common data structure.
	-	it is basically a "line"
	-	in Computer Science, it is known as FIFO ("First in, first out")
	-	our version has Generics; whoever declares an instance can also
		put in what type it will hold.  Our   Queue<E>   will hold type E
		(or any subclass of it).
	-	So the driver might create     Queue<Term> myQ = new Queue<Term>();
	-	Our Queue class will use an ArrayList to hold its contentsAL.  Most of the
		Queue methods will be implemented by just calling ArrayList methods
		to do the work.
*/

import java.util.*;

public class Queue<E>
{
	//---------- data - an ArrayList to hold the contentsAL

	private ArrayList<E> contentsAL;

	//---------- constructor(s)

	public       Queue()
	{
		contentsAL = new ArrayList<E>();
	}

	//---------- methods

	//insert - puts elt at the back of the "line" (last position in the ArrayList)
	public void insert(E elt)
	{
		contentsAL.add(elt);
	}

	//remove - removes the first element and return it
	public E remove()
	{
		if (contentsAL.size() == 0)
			throw new NoSuchElementException("can't remove from empty queue");

		return contentsAL.remove(0);  //return whatever the AL's method gives us
	}

	//peek - get the first element and return (don't remove it)
	public E peek()
	{
		if (contentsAL.isEmpty())
			throw new NoSuchElementException("can't peek at empty queue");

		return contentsAL.get(0);
	}

	//size - returns  the size of the queue
	public int size()
	{
		return contentsAL.size();
	}

	//toString - 	returns its representation as a String.
	public String toString()
	{
		return contentsAL.toString();   	//NOTE: this only works if our code inserts
														//into the back of the ArrayList and removes
														//from the front.  Otherwise, it would be backwards.
	}

	//position - returns the 0-based position in the "line"
	//					if the Queue is empty, just return -1 (just like ArrayList does)
	public int position(E elt)
	{
		return contentsAL.indexOf(elt);   //uses ArrayList's .indexOf method
	}

	//contains - returns true if the element received is in the queue
						//NOTE: this only works if the the type E that is in the
						//ArrayList has a correct, working .equals method!!!
	public boolean contains(E elt)
	{
		return contentsAL.contains(elt);
	}
}

