
public class PartitionList {
	/*
	 * For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 */

	public class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	Node root = null;

	public Node partition(Node root, int target) {
		Node travel = root;
		Node previous = null;
		while (travel != null) {
			int currentVal = travel.val;
			if (currentVal < target) {
				// Remove travel.val
				if (previous != null) {
					previous.next = travel.next;
					travel = travel.next; // may get null here
				} else {
					travel = travel.next;
				}
				
				root = insertBeforeNode(root, currentVal, target);

				// Insert it back to the list
			}
			previous = travel;
			travel = travel.next;

		}

		return root;
	}

	public Node insertBeforeNode(Node root, int val, int target){
		Node travel = root;
		Node previous = null;
		
		while(travel!= null && travel.val < target){
			previous = travel;
			travel = travel.next;
		}
		// travel == null, dont need to do anything
		if (travel != null){
			if (previous == null){
				Node newNode = new Node(val);
				newNode.next = root;
				root = newNode;
			} else {
			Node newNode = new Node(val);
			newNode.next = travel;
			previous.next = newNode;
			}
		}
		return root;
	}
	
	public String toString(Node root) {
		Node travel = root;
		StringBuilder sb = new StringBuilder();
		while (travel != null) {
			sb.append(travel.val + " ");
			travel = travel.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		PartitionList rd = new PartitionList();
		rd.root = rd.new Node(100);

		Node a = rd.new Node(12);
		Node b = rd.new Node(10);
		Node c = rd.new Node(8);
		Node d = rd.new Node(11);
		Node e = rd.new Node(6);
		Node f = rd.new Node(19);

		rd.root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;

		System.out.println(rd.toString(rd.root));
		System.out.println(rd.toString(rd.partition(rd.root, 11)));

	}
}
