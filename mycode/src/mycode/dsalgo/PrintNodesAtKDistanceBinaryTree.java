package mycode.dsalgo;

public class PrintNodesAtKDistanceBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		// print nodes at k distance from root
		printNodesAtLevel(root, 2);
	}

	private static void printNodesAtLevel(TreeNode rootNode, int level) {
		/*Do a Pre-Order traversal of Tree and and decrement K each time you move to left or right.
		When K = 0, it means that is the level we are interested in. 
		So print the Node and return */

        if(rootNode==null){
            return;
        }
        if(level == 0){
            System.out.print(rootNode.data + " ");
            return;
        }
        printNodesAtLevel(rootNode.left, level - 1);
        printNodesAtLevel(rootNode.right, level - 1);
    }
}
