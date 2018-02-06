package mycode.dsalgo;

//https://github.com/rshaghoulian/HackerRank_solutions
public class BinaryTreeTopView {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		topView(root);
	}

	static void topView(TreeNode root) {
		TreeNode root1 = root;
		TreeNode root2 = root;
		if (root != null) {
			printLeft(root.left);
		    System.out.print(root.data+" ");
		    printRight(root.right);
		}
	}
	
	static void printLeft(TreeNode node) {
		if(node != null) {
			printLeft(node.left);
			System.out.print(node.data+" ");
		}
	}

	static void printRight(TreeNode node) {
		if(node != null) {			
			System.out.print(node.data+" ");
			printRight(node.right);
		}
	}

}
