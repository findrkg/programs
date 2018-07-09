package mycode.dsalgo.linkedlist;

public class ReverseList {
	static Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
	public static void main(String[] args) {		
		//Node rhead = reverse(head);
		Node rhead = reverseRec(head);
		print(rhead);
	}
	
	private static Node reverse(Node head) {
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
	
	private static Node reverseRec(Node current) {
		Node newHead = null;
		if(current.next == null) {
			return current;
		}
		newHead = reverseRec(current.next);
		current.next.next = current;
		current.next = null;
		return newHead;
	}
	
	private static void print(Node head) {
		while(head != null) {
			System.out.print(head.data +">");
			head = head.next;
		}
	}
}
