package mycode.dsalgo.linkedlist;

import java.util.HashSet;

public class RemoveDuplicateFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(3, new Node(2, new Node(9, null))))));
		//removeDuplicate(head);
		deleteDups(head);
		while(head != null) {
			System.out.print(head.data+"->");
			head = head.next;			
		}
	}

	static void removeDuplicate(Node current) {
		//O(N*N)
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}				
			}
			current = current.next;
		}
	}
	
	static void deleteDups(Node current) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while (current != null) {
			if (set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
	}
}
