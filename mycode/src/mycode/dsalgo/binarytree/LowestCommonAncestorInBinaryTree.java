package mycode.dsalgo.binarytree;

public class LowestCommonAncestorInBinaryTree {

	public static void main(String[] args) {
	    /* Constructed binary tree is
	        10
	       /  \
	     8     12
	    / \   / \
	   6   9 11  13
	  */
	
	  TreeNode root = new TreeNode(10);
	  root.left = new TreeNode(8);
	  root.right = new TreeNode(12);
	  root.left.left = new TreeNode(6);
	  root.left.right = new TreeNode(9);
	  root.right.left = new TreeNode(11);
	  root.right.right = new TreeNode(13);

	  System.out.println("lcaRecur is "+lca(root, 12, 8).data);
	  System.out.println("lcaItr is "+lcaItrative(root, 12, 8).data);

	}

	/*Time complexity O(n)
	 * Space complexity O(h)
	 */
	static TreeNode lca(TreeNode root,  int n1, int n2) 
    {
        if (root == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > n1 && root.data > n2)
            return lca(root.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < n1 && root.data < n2) 
            return lca(root.right, n1, n2);
  
        return root;
    }

	static TreeNode lcaItrative(TreeNode root, int a, int b) {
		while(root!=null)
		{
			if(root.data>a && root.data > b)
			{
				root=root.left;
			}
			else if(root.data < a && root.data < b)
			{
				root=root.right;
			}
			else
			{
				return root;
			}
		} 
		return root;
	}
}
