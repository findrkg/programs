package mycode.dsalgo;

public class TreeNode {

	int data = 0;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}

	TreeNode(int data) {
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
