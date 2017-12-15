package mycode.dsalgo;

import java.util.Hashtable;

public class DeleteDuplicateFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(3, new Node(4, null)))));
		Node current = deleteDuplicate(head);
		while(current != null) {
			System.out.print(current.data+">");
			current = current.next;
		}
	}

	public static Node deleteDuplicate(Node head) {
		Hashtable<Integer, Boolean> table = new Hashtable<>();
		Node current = null;
		Node newhead = head;
		while(head != null) {
			if(table.containsKey(head.data)) {
				current.next = head.next;
			}
			else {
				table.put(head.data, true);
				current = head;
			}
			head = head.next;
		}
		return newhead;
	}
}
