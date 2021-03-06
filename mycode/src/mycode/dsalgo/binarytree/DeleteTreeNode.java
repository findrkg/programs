package mycode.dsalgo.binarytree;

public class DeleteTreeNode {
	
	public static TreeNode deleteNode(TreeNode root, int data) {
		if(root == null) {
			return root;
		}
		else if(data < root.data) {
			root.left = deleteNode(root.left, data);
		}
		else if(data > root.data) {
			root.right = deleteNode(root.right, data);
		}
		else if(data == root.data) {// found the node, ready to delete
			//CASE 1 : if there is no child (no left or right)
			if(root.left == null && root.right == null) {
				root = null;
			}
			//CASE 2 : if there is one child (left or right)
			else if(root.left != null && root.right == null) {
				//delete the left child 
				root = root.left;
				root.left = null;
			}
			else if(root.right != null && root.left == null) {
				//delete the right child 
				root = root.right;
				root.right = null;
			}
			//CASE 3 : if there are 2 children
			else if (root.left != null && root.right != null) {
				// find min from right child
				TreeNode minNode = findMin(root.right);
				root.data = minNode.data;
				root.right = deleteNode(root.right, minNode.data);
			}
		}
		return root;
	}

	public static TreeNode findMin(TreeNode root) {
		if(root.left == null) {
			return root;
		}
		else {
			return findMin(root.left);
		}
	}

	public static TreeNode findMax(TreeNode root) {
		if(root.right == null) {
			return root;
		}
		return findMax(root.right);
	}

	public static void inorderTraversal(TreeNode root) {
		// left - root - right
		if(root != null) {
			if(root.left != null) {
				inorderTraversal(root.left);
			}
			System.out.print(root.data + " ");
			if(root.right != null) {
				inorderTraversal(root.right);
			}
		}
	}

	public static void main(String[] args) {
		// Binary tree
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(17);
		
		//TreeNode t = findMin(root.left.right);
		//System.out.println("min is "+t.data);
		System.out.println("Before deletetion : ");
		inorderTraversal(root);
		System.out.println("");
		System.out.println("After deletetion : ");
		inorderTraversal(deleteNode(root, 15));
	}

}
