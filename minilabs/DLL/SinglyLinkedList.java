public class SinglyLinkedList<E> {


    // DATA
    protected int size;
    protected Node head;

    // CONSTRUCTORS
    public SinglyLinkedList() {

	head = null;
	size = 0;
    }

    public boolean add(E element) {
	
	if (head == null) {
	    head = new Node(element);
	}

	Node node = head;
    }

    // METHODS
    












    protected class Node {
	protected E data;
	protected Node next;

	public Node(E data) {

	    this.data = data;
	    this.next = null;
	}

	@SuppressWarnings('unused')
	public Node(E data, Node next) {
	    
	    this.data = data;
	    this.next = next;

	}

	public String toString() {
	    
	    return "Node(" + data.toString() + ")";
	
	}
    }

}
