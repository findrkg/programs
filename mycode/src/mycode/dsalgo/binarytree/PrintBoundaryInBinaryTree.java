package mycode.dsalgo.binarytree;

import java.util.HashMap;

public class PrintBoundaryInBinaryTree {

	public static void main(String[] args) {
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
		printBoundary(root);
	}

	private static void printBoundary(TreeNode node) {
		TreeNode left = node;
		TreeNode right = node;
		HashMap<Integer, TreeNode> map = new HashMap<>();
		//print root
		if(node != null) {
			map.put(node.data, node);
			System.out.print(node.data+ " ");
		}
		
		//print left nodes		
		printLeft(left, map);
		//print right nodes
		printRight(right, map);
		//print leaves nodes
		printLeaf(right, map);
	}
	
	private static void printLeft(TreeNode node, HashMap map) {
		while(node != null) {			
			if(node.left != null) {
				int data = node.left.data;				
				if(!map.containsKey(data)) {
					map.put(data, node.left);
					System.out.print(data+ " ");
				}				
			}
			node = node.left;
		}		
	}
	
	private static void printRight(TreeNode node, HashMap map) {
		while(node != null) {			
			if(node.right != null) {
				int data = node.right.data;
				if(!map.containsKey(data)) {
					map.put(data, node.right);
					System.out.print(data+ " ");					
				}
			}
			node = node.right;
		}
	}
	
	private static void printLeaf(TreeNode node, HashMap map) {
		if(node != null) {
			int data = node.data;
				printLeaf(node.left, map);
				if(!map.containsKey(data)) {
					map.put(data, node);
					System.out.print(node.data+ " ");
				}				
				printLeaf(node.right, map);				
		}
	}
}
