package mycode.dsalgo.linkedlist;

public class SumTwoLists {

	public static void main(String[] args) {
		// Numbers are represented in normal order
		Node list1 = new Node(3, new Node(2, new Node(3, new Node(4, null)))); // 3224
		Node list2 = new Node(2, new Node(1, new Node(9, null))); // 219
		Node result = sumLists(list1, list2, 0);
		Node.print(result);
	}
	
	static Node sumLists(Node list1, Node list2, int carry) {
		if(list1 == null && list2 == null) {
			return null;
		}

		Node result = new Node();
		int value = carry;
		if(list1 != null) {
			value += list1.data;
		}
		if(list2 != null) {
			value += list2.data;
		}
		result.data = value%10;
		
		if(list1 != null || list2 != null) {
			Node more = sumLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, value > 10 ? 1 : 0);
			result.next = more;
		}		
		return result;
	}
}