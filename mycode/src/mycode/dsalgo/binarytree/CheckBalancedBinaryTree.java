package mycode.dsalgo.binarytree;

public class CheckBalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
		if(isTreeBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
	}

	private static boolean isTreeBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		if((Math.abs(leftHeight - rightHeight) <= 1) 
				&& isTreeBalanced(root.left) && isTreeBalanced(root.right)) {
			return true;
		}
		return false;
	}
	
	private static int getHeight(TreeNode node) 
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
  
        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
