package mycode.dsalgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeTraversal {

	void levelOrder(TreeNode root) {
		if(root==null) return; 
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

	void zigzagOrder(TreeNode root) {
		if(root==null) return;
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		boolean directionFlag = true;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			if(!directionFlag) {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);				
			}
			else {
				if (node.right != null)
					queue.add(node.right);				
				if (node.left != null)
					queue.add(node.left);
			}
			directionFlag = !directionFlag;
		}
	}

	void verticalSum(TreeNode root, int level, TreeMap levelSumMap) {
		if(root == null) {
			return;
		}
		verticalSum(root.left, level-1, levelSumMap);
		if(levelSumMap.get(level) != null) {
			int sum = (Integer)levelSumMap.get(level) + root.data;
			levelSumMap.put(level, sum);
		}
		else {
			levelSumMap.put(level, root.data);
		}
		verticalSum(root.right, level+1, levelSumMap);
	}

	void preOrder(TreeNode root) {
		if (root != null) {
			// Visit the node-Printing the node data
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			// Visit the node-Printing the node data			
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
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

	public void inOrderIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode node = st.peek();
			if(node.left != null) {
				st.push(node.left);
				node.left = null;
			}
			else {
				System.out.print(node.data+ " ");
				st.pop();
				if(node.right != null) {
					st.push(node.right);
					node.right = null;
				}				
			}
		}
	}

	public void preOrderIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			System.out.print(node.data+ " ");
			if(node.right != null) {
				st.push(node.right);
			}
			if(node.left != null) {
				st.push(node.left);
			}
		}
	}

	public void postOrderIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode node = st.peek();
	        if(node.left == null && node.right == null) {
	            TreeNode n = st.pop();
	            System.out.print(n.data+" ");
	        }
	        else {
	            if(node.right != null) {
	                st.push(node.right);
	                node.right = null;
	            }
	            if(node.left != null) {
	                st.push(node.left);
	                node.left = null;
	            }
	        }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 		 1 
		 * 	  2      3 
		 * 4    5  6   7
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeTraversal tree = new TreeTraversal();
//		System.out.print("Level Order : ");
//		tree.levelOrder(root);
//		System.out.println("");
//		System.out.print("Pre Order : ");
//		tree.preOrder(root);
//		System.out.println("");
//		System.out.print("Post Order : ");
//		tree.postOrder(root);
//		System.out.println("");
//		System.out.print("Zigzag Order : ");
//		tree.zigzagOrder(root);
//		System.out.println("");
//		System.out.print("Vertical sum : ");
//		TreeMap<Integer, Integer> levelSumMap = new TreeMap<>();
//		tree.verticalSum(root, 0, levelSumMap);
//		
//		for(Entry<Integer,Integer> entry: levelSumMap.entrySet()) {
//			System.out.print(entry.getValue()+ " ");
//		}
		
		System.out.print("Post Order Iterative : ");		
		tree.postOrderIterative(root);
//		tree.inOrderIterative(root);
//		System.out.println("In Order : ");
//		tree.preOrder(root);

	}

}
