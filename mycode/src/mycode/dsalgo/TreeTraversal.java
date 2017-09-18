package mycode.dsalgo;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeTraversal {

	void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	void preOrder(TreeNode root) {
		if (root != null) {
			// Visit the node-Printing the node data
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			// Visit the node by Printing the node data
			System.out.printf("%d ", root.data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 		1 
		 * 	  2     3 
		 * 4    5  6  7
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeTraversal tree = new TreeTraversal();
		System.out.print("Level Order : ");
		tree.levelOrder(root);
		System.out.println("");
		System.out.print("Pre Order : ");
		tree.preOrder(root);
		System.out.println("");
		System.out.print("Post Order : ");
		tree.postOrder(root);

	}

}
