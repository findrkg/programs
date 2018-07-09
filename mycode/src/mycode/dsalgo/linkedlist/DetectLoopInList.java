package mycode.dsalgo.linkedlist;

public class DetectLoopInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		   
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n5);
		System.out.println("Loop detected : "+detectLoop(n1));
		System.out.println("Loop start at : "+findStartOfLoop(n1).getData());
		Node head = n1;
		detectAndRemoveLoopInLinkedList(head);
		while(head!=null){
		   System.out.print(head.getData() + " " ); 
		   head=head.getNext();
		}
	}

	public static boolean detectLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			//System.out.println(slow.getData() +" ");
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}

	/* 
	 * l = length of loop
	Distance covered by slow pointer = d = x + p*l + y
	Distance covered by fast pointer = 2d = x + q*l + y
	2(x + p*l + y) = x + q*l + y
	x + y = (q-2p)*l // q >p and x+y is integer multiple of loop length 
	http://javabypatel.blogspot.in/2017/05/remove-loop-from-linked-list-in-java.html
	Tortoise pointer was moving one node at a time and hare pointer was moving 2 nodes at same time.
	So we can say, when tortoise pointer has moved distance "d" 
	then hare pointer has moved distance "2d".
	From the above image, the length of loop is q+r.
	When tortoise and hare meet,  tortoise has covered distance  d = p+q and hare has covered distance 2*d = p+q+r+q

	2*d = p + q + r + q
	2(p+q) = p + 2q + r
	2p + 2q = p + 2q + r
	p = r 
	(It means distance from head node to the start of loop node is same as distance 
	between meeting point of the pointers to the start of loop node) 
	*/
	
	public static Node findStartOfLoop(Node head) {		
		Node slow = head;
		Node fast = head;
		boolean isLoopDetected = false;
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			//System.out.println(slow.getData() +" - "+fast.getData());
			if(fast == slow) {
				isLoopDetected = true;
				break;
			}
		}
		if(isLoopDetected) {
			//After meet, moving slowPointer to start node of list.
			slow = head;
			//Moving slowPointer and fastPointer one node at a time till the time they meet at common point
			while(slow != fast) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			 //returning start node of loop.
			return slow;
		}
		return null;		
	}

	private static Node detectAndRemoveLoopInLinkedList(Node startNode) {
		  Node slowPointer=startNode;
		  Node fastPointer=startNode;
		  Node previousPointer=null;
		   
		  while(fastPointer!=null && fastPointer.getNext()!=null){
			  slowPointer = slowPointer.getNext();
			  previousPointer = fastPointer.getNext(); // For capturing just previous node of loop node for setting it to null for breaking loop.
			  fastPointer = fastPointer.getNext().getNext();
		    
			   if(slowPointer==fastPointer){ // Loop identified.
				   slowPointer = startNode;
			  
				    //If loop start node is starting at the root Node, then we slowpointer, fastpointer and head all point at same location. 
				    //we already capture previous node, just setting it to null will work in this case.
				    if(slowPointer == fastPointer){
				    	previousPointer.setNext(null);		      
				    }
				    else{
				    	// We need to first identify the start of loop node and then by setting just previous node of loop node next to null.  
				    	while(slowPointer.getNext()!=fastPointer.getNext()){
				    		slowPointer = slowPointer.getNext();
				    		fastPointer = fastPointer.getNext();
				    	}
				    	fastPointer.setNext(null);
				    }
			   }
		  }
		  return startNode; 
		 }
}
