package mycode.dsalgo;

public class NthNodeFromEnd {
	
	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		// TODO Auto-generated method stub
		System.out.println("nth node from end is "+getNode(head, 4));
	}

	public static int getNode(Node head, int n) {
		int length = 0;
		Node current = head;
		while(current != null) {
			current = current.getNext();
			length++;
		}
		current = head;
		int i = 1;
		while(i != (length - n +1)) {
			current = current.getNext();
			i++;
		}
		return current.getData();
	}
}
