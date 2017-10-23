package mycode.dsalgo;
import static java.lang.Math.*;

public class ArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 6, 5, 4, 3, 2, 1};
		TreeNode root = buildBST(arr, 0, arr.length-1);
		inorder(root);
	}
	
	public static TreeNode buildBST(int[] arr, int start, int end) {
		 if (start > end) {
			 return null;
		 }
		 // same as (start+end)/2, avoids overflow.
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildBST(arr, start, mid-1);
		root.right = buildBST(arr, mid+1, end);
		return root;
	}

	public static void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
