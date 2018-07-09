package mycode.dsalgo.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
	static int count[] = null;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

        System.out.println("Max width with level order is "+maxWidthUsingLevelOrderTraversal(root));
        System.out.println("Max width with pre order is "+maxWidthUsingPreOrderTraversal(root));
	}

	public static int maxWidthUsingLevelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int max = -1;
		while(!queue.isEmpty()) {
			int count = queue.size();
			//System.out.println("count "+count);
			if(count > max) {
				max = count;
			}
			while(count > 0) {
				TreeNode node = queue.remove();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
		return max;
	}
	
	//Time complexity O(N)
	public static int maxWidthUsingPreOrderTraversal(TreeNode node) {
        int width;
        int h = height(node);
  
        // Create an array that will store count of nodes at each level
        count = new int[h];
  
        int level = 0;
  
        // Fill the count array using preorder traversal
        getMaxWidthRecur(node, level);
  
        // Return the maximum value from count array
        return getMax(count);
    }
  
    // A function that fills count array with count of nodes at every
    // level of given binary tree
	public static void getMaxWidthRecur(TreeNode node, int level) 
    {
        if (node != null) 
        {
            count[level]++;
            getMaxWidthRecur(node.left, level + 1);
            getMaxWidthRecur(node.right, level + 1);
        }
    }

    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
	public static int height(TreeNode node) 
    {
        if (node == null) 
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lHeight = height(node.left);
            int rHeight = height(node.right);
              
            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }
      
    // Return the maximum value from count array
	public static int getMax(int arr[]) 
    {
        int max = arr[0];
        int i;
        for (i = 0; i < arr.length; i++) 
        {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
