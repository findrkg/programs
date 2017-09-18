package mycode.dsalgo;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeTraversal {

	void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data + " > ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			//queue.remove();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeTraversal tree = new TreeTraversal();
		tree.printLevelOrder(root);
	}

}
