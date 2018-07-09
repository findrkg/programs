package mycode.dsalgo.binarytree;

public class CheckBinaryTreeMaxHeap {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
 
        if(isHeap(root))
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");

	}

	static int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	static boolean isHeap(TreeNode root) {
		if(root == null) {
			return true;			
		}
		int nodeCount = countNodes(root);
		if(checkComplete(root, 0, nodeCount) && checkHeap(root)) {
			return true;
		}
		return false;
	}

	static boolean checkComplete(TreeNode root, int index, int nodeCount) {
		if(root == null) {
			return true;
		}
		if(index > nodeCount) {
			return false;
		}
		return checkComplete(root.left, 2*index+1, nodeCount) && checkComplete(root.right, 2*index+2, nodeCount);
	}

	static boolean checkHeap(TreeNode root) {
		// single node or leaf node
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.right == null) {
			return root.data >= root.left.data;
		}
		else {
			if(root.data >= root.left.data && root.data >= root.right.data) {
				return checkHeap(root.left) && checkHeap(root.right);
			}
		}
		return false;
	}

}
