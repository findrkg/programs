package mycode.dsalgo.linkedlist;

public class SwapAdjustNodesInList {

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		Node rhead = swapNodes(head);
		while(rhead != null) {
			System.out.print(rhead.data +">");
			rhead = rhead.next;
		}
	}

	static Node swapNodes(Node head) {
		Node current = head;
		Node next = null;
		while(current != null && current.next != null) {
			next = current.next;
			int data = current.data;
			current.data = next.data;
			next.data = data;
			current = next.next;
		}
		return head;
	}
}
