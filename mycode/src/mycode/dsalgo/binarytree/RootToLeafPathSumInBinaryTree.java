package mycode.dsalgo.binarytree;

public class RootToLeafPathSumInBinaryTree {

	public static void main(String[] args) {
		int sum = 21;
        
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
  
        if (hasPathSum(root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
	}

	/*
    Given a tree and a sum, return true if there is a path from the root
    down to a leaf, such that adding up all the values along the path
    equals the given sum.
  
    Strategy: subtract the node value from the sum when recurring down,
    and check to see if the sum is 0 when you run out of tree.
    */ 
	static boolean hasPathSum(TreeNode node, int sum) 
	{
       if (node == null) {
           return (sum == 0);
       }
       else
       {
           boolean ans = false; 
           /* otherwise check both subtrees */
           int subsum = sum - node.data;
           if (subsum == 0 && node.left == null && node.right == null) {
        	   return true;
           }               
           if (node.left != null) {
               ans = ans || hasPathSum(node.left, subsum);
           }
           if (node.right != null) {
               ans = ans || hasPathSum(node.right, subsum);
           }
           return ans;
       }
   }
}
