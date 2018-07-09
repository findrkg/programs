package mycode.dsalgo.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BootomViewOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printTopView(root);
	}

	static void printTopView(TreeNode root) {
		if(root == null) {
			return;
		}
		// Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
 
        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
 
         // Queue to store tree nodes in level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        root.hd = hd;
        queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode node = queue.remove();
        	hd = node.hd;
        	if(!map.containsKey(hd)) {
        		map.put(hd, node.data);
        	}
        	if(node.left != null) {
        		node.left.hd = hd - 1;
        		queue.add(node.left);
        	}
        	if(node.right != null) {
        		node.right.hd = hd + 1;
        		queue.add(node.right);
        	}
        }
        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Entry<Integer, Integer> entry = it.next();
        	System.out.print(entry.getValue() + " ");
        }
	}
	
	static void printBottomView(TreeNode root) {
		if(root == null) {
			return;
		}
		// Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
 
        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
 
         // Queue to store tree nodes in level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        root.hd = hd;
        queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode node = queue.remove();
        	hd = node.hd;
        	map.put(hd, node.data);
        	if(node.left != null) {
        		node.left.hd = hd - 1;
        		queue.add(node.left);
        	}
        	if(node.right != null) {
        		node.right.hd = hd + 1;
        		queue.add(node.right);
        	}
        }
        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Entry<Integer, Integer> entry = it.next();
        	System.out.print(entry.getValue() + " ");
        }
	}

}
