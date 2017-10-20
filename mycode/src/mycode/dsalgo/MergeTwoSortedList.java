package mycode.dsalgo;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1, new Node(3, new Node(5, new Node(7, null))));
		Node head2 = new Node(2, new Node(4, new Node(6, new Node(8, null))));
		Node head = merge(head1, head2);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;			
		}
	}

	public static Node merge(Node head1, Node head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		Node head = null;
		if(head1.getData() < head2.getData()) {
			head = head1;
			head.next = merge(head1.next, head2);
		}
		else {
			head = head2;
			head.next = merge(head2.next, head1);			
		}
		return head;
	}

}
