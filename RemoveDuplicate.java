public class RemoveDuplicate {
	public class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	Node root = null;
	
	public Node getDistinct(Node root){
		Node newHead = new Node(0);
		Node newtravel = newHead;
		
		Node current = root;
		Node successor = root.next;
		
		int duplicate = 0;
		while(successor != null){
			if (current.val != successor.val){
				if (current.val != duplicate){
				newtravel.next = new Node(current.val);
				newtravel = newtravel.next;
				} 
			} else {
				duplicate = current.val;
			}
			current = successor;
			successor = successor.next;
		}
		
		return newHead.next;
	}

	public Node removeDuplicate(Node root) {
		Node current = root;
		Node travel = root.next;

		while (travel != null) {

			if (current.val == travel.val) {
//				while ( travel != null && current.val == travel.val ) {
//					travel = travel.next;
//				}
//				
//				if (travel != null){
//					current.next = travel;
//					current = travel;
//					travel = travel.next;
//				} else {
//					current.next = null;
//				}
				
				current.next = travel.next;
				travel = travel.next;
			
			} else {

				current = current.next;
				travel = travel.next;
			}

		}
		return root;
	}
	
	public String toString(Node root){
		Node travel = root;
		StringBuilder sb = new StringBuilder();
		 while ( travel != null){
			 sb.append(travel.val + "");
			 travel = travel.next;
		 }
		 return sb.toString();
	}

	public static void main(String[] args) {
		RemoveDuplicate rd = new RemoveDuplicate();
		rd.root = rd.new Node(1);

		Node a = rd.new Node(1);
		Node b = rd.new Node(2);
		Node c = rd.new Node(3);
		Node d = rd.new Node(4);
		Node e = rd.new Node(5);
		Node f = rd.new Node(5);
		Node g = rd.new Node(5);
		Node h = rd.new Node(5);
		//Node i = rd.new Node(4);

		rd.root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		//h.next = i;
	
		System.out.println(rd.toString(rd.root));
		//System.out.println(rd.toString(rd.removeDuplicate(rd.root)));
		System.out.println(rd.toString(rd.getDistinct(rd.root)));
	}
}
