package mycode.dsalgo.linkedlist;

public class InterweaveLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(7, new Node(8, new Node(9, null))))));
		//a1->b1->a2->b2-> ->an->bn
		Node rhead = interweave(head);
		while(rhead != null) {
			System.out.print(rhead.data+"->");
			rhead = rhead.next;			
		}
	}

	public static Node interweave(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getNext() != null ) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		//System.out.print(slow.data);
		//interweaving
		fast = head; // reset fast pointer to start
		
		Node temp = new Node();
		boolean isSlowData = false;
		while(slow != null) {
			if(isSlowData) {
				appendToTail(temp, slow.data);
				slow = slow.next;
				isSlowData = false;
			}
			else {
				appendToTail(temp, fast.data);
				fast = fast.next;
				isSlowData = true;				
			}
		}
		return temp.next;
	}
	
	static void appendToTail(Node head, int d) {
		Node end = new Node(d);
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
