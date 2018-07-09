package mycode.dsalgo.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeafPath {
	static List nodeList = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printPaths(root);
	}

	public static void printPaths(TreeNode root) {
		if(root == null) {
			return;
		}
		nodeList.add(root.data);
		//if it is a leaf node, print the path array
		if(root.left == null && root.right == null) {
			System.out.println(nodeList);
		}
		else {
			//recurse for left and right subtree
			printPaths(root.left);
			printPaths(root.right);			
		}
		// remove the last node
		nodeList.remove(nodeList.size()-1);
	}
}
