package mycode.dsalgo;

public class LowestCommonAncestorInBinaryTree {

	public static void main(String[] args) {
	    /* Constructed binary tree is
	        10
	       /  \
	     8     2
	    / \   /
	   3   5 2
	  */
	
	  TreeNode root = new TreeNode(10);
	  root.left = new TreeNode(8);
	  root.right = new TreeNode(2);
	  root.left.left = new TreeNode(3);
	  root.left.right = new TreeNode(5);
	  root.right.left = new TreeNode(2);

	  TreeNode result = lca(root, root.left.left, root.left.right);
	  System.out.println("lca is "+result.data);

	}

	/*Time complexity O(n)
	 * Space complexity O(h)
	 */
	public static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null) {
			return null;
		}
		if(root == n1 || root == n2) {
			return root;
		}
		
		TreeNode left = lca(root.left, n1, n2);
		TreeNode right = lca(root.right, n1, n2);
		if(left != null && right != null) {
			return root;
		}
		if(left != null) {
			return left;
		}
		else {
			return right;
		}
	}
}
