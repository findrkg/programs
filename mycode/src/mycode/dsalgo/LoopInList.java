package mycode.dsalgo;

public class LoopInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
		head.next.next.next = head;
		System.out.println("Loop detected : "+detectLoop(head));
	}

	public static boolean detectLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			System.out.println(slow.getData() +" ");
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
}
