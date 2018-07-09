package mycode.dsalgo.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

//https://github.com/rshaghoulian/HackerRank_solutions
public class BinaryTreeTopView {
	static Map<Integer, TreeNode> hdmap = new TreeMap<Integer, TreeNode>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

//		TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.left.right.right = new TreeNode(5);
//        root.left.right.right.right = new TreeNode(6);
		printTopView(root);
	}

	static void printTopView(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(root, 0));
		while(!queue.isEmpty()) {
			QItem item = queue.remove();
			int hd = item.hd;
			TreeNode node = item.node;
			if(!set.contains(hd)) {
				set.add(hd);
				System.out.print(node.data+" ");
			}
			if(node.left != null) {
				queue.add(new QItem(node.left, hd-1));
			}
			if(node.right != null) {
				queue.add(new QItem(node.right, hd+1));
			}
		}
    }
}

class QItem {
	TreeNode node;
	int hd;
	QItem(TreeNode node, int hd) {
		super();
		this.node = node;
		this.hd = hd;
	}
}
