/**
 * This class is responsible for creating, adding, sorting and printing 
 * the LinkedList
 * @author David Him
 *
 */
public class LinkedListTest {
	
	private Node head; // the head Node
	
	/**
	 * The no argument constructor
	 */
	public LinkedListTest(){
		head = new Node();
	}
	
	/**
	 * Add a Node object to the linked list
	 * The number value in the object will be compared to the values in the LinkedList
	 * and the object will be inserted in ascending order
	 * @param n the Node object to insert
	 */
	public void addSortedList(Node n){

		Node current = head;
		while(current.next != null){
			if(current.getData() < n.getData() && current.next.getData() > n.getData()
					|| current.getData() == n.getData()) {
				Node next = current.next;
				current.setNext(n);
				current.next.setNext(next);
				break;
			}
			else {
				current = current.next;
			}
		}
	current.next = current.setNext(n);
	}
	
	/**
	 * Iterate through the list and print out the number value
	 */
	public void printLinkedList(){
		while(head.next != null){
			System.out.println("Head: "+head.getData());
			//System.out.println("next: "+head.getNext().getData());
			
			head = head.next;
		}
		System.out.println("Head: "+head.getData());
	}

	public static void main(String[] args) throws InterruptedException {
		LinkedListTest list = new LinkedListTest();
		
		// happy path
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(8);
		
		// Test insert into middle of LinkedList
		Node n5 = new Node(4);
		Node n6 = new Node(7);
		Node n7 = new Node(6);
		
		// happy path test
		Node n8 = new Node(10);
		Node n9 = new Node(11);
		
		// Test duplicate values - I made an assumption that we wanted to duplicate values
		Node n10 = new Node(4);
		Node n11 = new Node(1);
		
		// Add nodes to the list
		list.addSortedList(n1);
		list.addSortedList(n2);
		list.addSortedList(n3);
		list.addSortedList(n4);
		list.addSortedList(n5);
		list.addSortedList(n6);
		list.addSortedList(n7);
		list.addSortedList(n8);
		list.addSortedList(n9);
		list.addSortedList(n10);
		list.addSortedList(n11);
		
		//Print out the number values in the list
		list.printLinkedList();
		
	}
}
