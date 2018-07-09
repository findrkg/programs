package mycode.dsalgo.linkedlist;

public class FindMiddleInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));
		findMiddle(head);
	}

	public static void findMiddle(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getNext() != null ) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		System.out.println("Middle is "+slow.getData());
	}
}
