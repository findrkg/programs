package mycode.dsalgo;

public class CheckBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(7);
		root.right = new TreeNode(39);
		root.left.right = new TreeNode(11);
		System.out.println("This tree is a BST "+isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(TreeNode root, int min, int max) {
	      /* an empty tree is BST */
        if (root == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (root.data < min || root.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(root.left, min, root.data-1) &&
                isBST(root.right, root.data+1, max));
	}
}
