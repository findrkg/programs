package mycode.dsalgo;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		System.out.println("Diameter is "+diameterOfBinaryTree(root));

	}
    public static int diameterOfBinaryTree(TreeNode node)
    {
    	/*
    	 * Time T(N) = 2 * NlogN + 2 * T(N/2) + cN ==> NlogN
    	 * Space =  O(logN) for stack
    	 */
        if (node == null)
        {
            return 0;
        }
 
        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);
 
        //Diameter of the node itself including
        int nodeDiameter = leftHeight + rightHeight + 1;
        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);
 
        return Math.max(nodeDiameter,
            Math.max(leftDiameter, rightDiameter));
    }
 
    public static int heightOfBinaryTree(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(heightOfBinaryTree(node.left),
                heightOfBinaryTree(node.right));
        }
    }

}
