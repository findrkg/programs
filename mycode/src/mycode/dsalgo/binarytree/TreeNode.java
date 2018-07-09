package mycode.dsalgo.binarytree;

public class TreeNode {

	public int data = 0;
	public int hd = 0; // horizontal distance
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode() {
		this.data = 0;
		this.hd = Integer.MAX_VALUE;;
		this.left = null;
		this.right = null;
	}

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
	}

}
