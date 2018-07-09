package mycode.dsalgo.linkedlist;

public class PairWiseSwapLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null)))))); // 12345
		//Node newHead = pairWiseSwap(head);
		Node newHead = reverseInPairs(head);
		while(newHead != null) {
			System.out.print(newHead.data+"->");
			newHead = newHead.next;
		}
	}

	/*
	 * Recursive approach
	 * */
	static Node pairWiseSwap(Node head) {
		// Base Case: The list is empty or has only one node
		if(head == null || head.next == null) {
			return head;
		}
		// Store head of list after two nodes
        Node remaing = head.next.next;

        // Change the head
		Node newHead = head.next;

		// Change next of second node. make 2->1
		head.next.next = head;

		// Recur for remaining list and change next of head
        head.next = pairWiseSwap(remaing);

		return newHead;
	}
	
	/*
	 * Iterative approach, 1->2->3->4->5->6
	 * */
	static Node reverseInPairs(Node head) {
		 
		Node temp=null;
		Node newHead =null;
		while (head != null && head.next != null) {
 			if (temp != null) {
				// This is important step
				temp.next.next = head.next;//link 1->4
			}
 			// swap the links
			temp=head.next; // save 2
			head.next=temp.next; // link 1->3
			temp.next=head; // link 2->1

			if (newHead == null) {
				newHead = temp;
			}				
			head=head.next;
		}     
		return newHead;
	}
}
