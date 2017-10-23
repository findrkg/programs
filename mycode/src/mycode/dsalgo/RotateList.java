package mycode.dsalgo;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
//		Node newHead = rotateClockwise(head, 2, true);
//		System.out.print("Clockwise : ");
//		while(newHead != null) {
//			System.out.print(newHead.data +">");
//			newHead = newHead.next;
//		}
		System.out.println("");
		Node newHead1 = rotateClockwise(head, 3, false);
		System.out.print("Anti clockwise : ");
		while(newHead1 != null) {
			System.out.print(newHead1.data +">");
			newHead1 = newHead1.next;
		}
	}

	public static Node rotateClockwise(Node head, int k, boolean isClockwise) {
		if(head == null || head.next == null) {
			return head;
		}
		Node current = head;
		int len = 1;
		while(current.next != null) {
			current = current.next;
			len++;
		}
		current.next = head;
		int m = 0;
		if(!isClockwise) {
			k = len - k;
		}
		for(int i=1; i < (len-k%len); i++) {
			head = head.next;
		}
		Node newhead = head.next;
		head.next = null;
		return newhead;
	}
	
}
