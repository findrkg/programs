package mycode.dsalgo.linkedlist;

public class ReverseLinkedList {

	static Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
	public static void main(String[] args) {		
		Node thead = head;
		Node phead = head;
		System.out.println("Before reversal : ");
		while(head != null) {
			System.out.print(head.data +">");
			head = head.next;
		}
		System.out.println("");
		System.out.println("After reversal : ");
		head = reverseIterative(thead);
//		reverseRecursive(phead);
		while(head != null) {
			System.out.print(head.data +">");
			head = head.next;
		}
	}
	
	public static Node reverseIterative(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void reverseRecursive(Node current) {
		if(current == null) {
			return;
		}
		if(current.next == null) {
			head = current;
			return;
		}
		reverseRecursive(current.next);
		current.next.next = current;
		current.next = null;
	}

}
