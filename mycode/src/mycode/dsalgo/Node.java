package mycode.dsalgo;

public class Node {
	private int data;
	private Node next;
	Node() {
		this.data = 0;
		this.next = null;
	}
	
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
		while(head != null) {
			System.out.print(head.data +">");
			head = head.next;			
		}		
	}
}
