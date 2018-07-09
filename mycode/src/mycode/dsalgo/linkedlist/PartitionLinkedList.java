package mycode.dsalgo.linkedlist;

public class PartitionLinkedList {

	public static void main(String[] args) {
		Node head = new Node(3, new Node(5, new Node(8, new Node(5, new Node(10, new Node(2, new Node(1, null)))))));
		// partition around 5. all smaller numbers before 5 and larger after 5
		head = partition(head, 4);
		while(head != null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

	// does not preserve order
	static Node partition(Node node, int x) {
		// create a list, add lesser no to head and bigger no to tail
		Node head = node; // start of new list
		Node tail = node; // end of new list
		while(node != null) { // traverse through original list
			Node next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	// create smaller and greater list
	static Node partitionPreserveOrder(Node head, int x) {
		Node smallerHead = null;
		Node smallerTail = null;
		Node greaterHead = null;
		Node greaterTail = null;

		while(head != null) {
			if(head.data < x) {
				if(smallerHead == null) {
					smallerHead = head;
					smallerTail = smallerHead;
				}
				else {
					smallerHead.next = head;
					smallerTail = head;
				}
			}
			else {
				if(greaterHead == null) {
					greaterHead = head;
					greaterTail = greaterHead;
				}
				else {
					greaterHead.next = head;
					greaterTail = head;					
				}				
			}
			head = head.next;
		}
		
		if (greaterTail != null) {
			greaterTail.next = null;
		}	        
		if(smallerHead == null) {
			return greaterHead;
		}
		/* Merge before list and after list */
		smallerTail.next = greaterHead;
		return smallerHead;
	}
}
