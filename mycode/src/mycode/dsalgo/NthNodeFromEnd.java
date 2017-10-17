package mycode.dsalgo;

public class NthNodeFromEnd {
	
	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		// TODO Auto-generated method stub
		System.out.println("nth node from end is "+getNode(head, 1));
		getNodeRecursion(head, 3);
		printNthFromLast(head, 2);
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
	
	static int counter = 0;
	public static void getNodeRecursion(Node head, int n) {
		if(head != null) {
			getNodeRecursion(head.getNext(), n);
			counter++;
			if(counter == n) {
				System.out.println("nth node is "+head.getData());
			}
		}
	}
	
	  static void printNthFromLast(Node head, int n)
	    {
	        Node main_ptr = head;
	        Node ref_ptr = head;	 
	        int count = 0;
	        if (head != null)
	        {
	            while (count < n)
	            {
	                if (ref_ptr == null)
	                {
	                    System.out.println(n+" is greater than the no of nodes in the list");
	                    return;
	                }
	                ref_ptr = ref_ptr.getNext();
	                count++;
	            }
	            while (ref_ptr != null)
	            {
	                main_ptr = main_ptr.getNext();
	                ref_ptr = ref_ptr.getNext();
	            }
	            System.out.println("Node no. "+n+" from last is "+ main_ptr.getData());
	        }
	    }
}
