package mycode.dsalgo.linkedlist;

public class AddTwoLists {

	public static void main(String[] args) {
		// Numbers are represented in reverse order
		Node list1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null))))); // 12345
		Node list2 = new Node(9, new Node(6, new Node(3, null))); // 963
		Node head1 = reverseList(list1);
		Node head2 = reverseList(list2);
		Node result = sumLists(head1, head2, 0);
		Node.print(result);
	}
	
	static Node sumLists(Node list1, Node list2, int carry) {
		if(list1 == null && list2 == null) {
			return null;
		}

		Node result = new Node();
		int value = carry;
		if(list1 != null) {
			value += list1.data;
		}
		if(list2 != null) {
			value += list2.data;
		}
		result.data = value%10; // remainder, carry = value/10
		
		if(list1 != null || list2 != null) {
			Node more = sumLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, value/10 != 0 ? 1 : 0);
			result.next = more;
		}		
		return result;
	}
	
	static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node remaining = reverseList(head.next);
		head.next.next = head;
	    head.next = null;
		return remaining;
	}
}