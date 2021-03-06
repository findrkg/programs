package mycode.dsalgo.linkedlist;

public class Node {
	public int data;
	public Node next;
	public Node() {
		this.data = 0;
		this.next = null;
	}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.data +">");
			head = head.next;
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
//		while(head != null) {
//			System.out.print(head.data +">");
//			head = head.next;
//		}
		print(head);
	}
}
