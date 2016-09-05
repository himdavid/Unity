
/**
 * This class will be used with the LinkedListTest class
 * to create a LinkedList of Nodes with a number value
 * @author David Him
 *
 */
public class Node {
	
	private int number; //The number
	Node next; //A reference to the next node
	
	/**
	 * A no argument constructor
	 */
	public Node(){
		
	}
	
	/**
	 * The constructor with an integer parameter
	 * @param number, an integer value
	 */
	public Node(int number){
		this.number = number;
		next = null;
	}
	
	/**
	 * Get the next node
	 * @return the next node
	 */
	public Node getNext(){
		return next;
	}
	
	/**
	 * Set the next node
	 * @param nextValue the next node to set
	 * @return the next node
	 */
	public Node setNext(Node nextValue){
		return next = nextValue;
	}
	
	/**
	 * Get the number
	 * @return the number
	 */
	public int getData(){
		return number;
	}

}
