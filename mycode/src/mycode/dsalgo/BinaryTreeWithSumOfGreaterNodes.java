package mycode.dsalgo;

public class BinaryTreeWithSumOfGreaterNodes {

	//https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
	//http://linearspacetime.blogspot.in/2012/05/sum-of-nodes-in-binary-search-tree.html
	public static void main(String[] args) {
		/*
		 * 	  50
           /      \     
         30        70
        /   \      /  \
      20    40    60   80 
      
  			  260
           /      \
         330        150
        /   \       /  \
      350   300    210   80
		 */
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		sumOfNodes(root, 0);
		TreeTraversal tree = new TreeTraversal();
		System.out.print("Level Order : ");
		tree.levelOrder(root);
	}

	public static int sumOfNodes(TreeNode root, int currSum) {
	    // Do a reverse in-order

	    // Get the sum of right sub tree
	    if (root.right != null)
	    	currSum = sumOfNodes(root.right, currSum);

	    // Set the current node's key value 
	    currSum = currSum + root.data;
	    root.data = currSum;

	    // Get the sum of left sub tree
	    if (root.left != null)
	    	currSum = sumOfNodes(root.left, currSum);

	    // Return the total
	    return currSum;
	}
}
