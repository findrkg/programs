package mycode.dsalgo;

public class LinkedListToBST {
	static Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
	public static void main(String[] args) {
		Node ihead = head;
		// convert to Balanced BST
		TreeNode troot = sortedListToBST(ihead);
		printInOrder(troot);
	}

	// get list length
	public static int getLength(Node head) {
		int length = 0;
		Node current = head;
 
		while(current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	public static TreeNode sortedListToBST(Node thead) {
		// Time O(N)
		if (head == null)
			return null;
		int len = getLength(thead);
		return sortedListToBST(0, len - 1);
	}

	public static TreeNode sortedListToBST(int start, int end) {
		//Bottom up approach
		if (start > end) {
			return null;
		}
		int mid = start+(end-start)/2;
		TreeNode left = sortedListToBST(start, mid-1);
		TreeNode root = new TreeNode(head.data);		
		head = head.getNext();
		TreeNode right = sortedListToBST(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}

	public static void printInOrder(TreeNode root) {
		if (root != null) {
			// Visit the node means Printing the node data			
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}

}
