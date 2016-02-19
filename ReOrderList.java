
public class ReOrderList {
	public class Node{
		int val;
		Node next;
		
		public Node(int val){
			this.val = val;
			next = null;
		}
	}
	
	Node root = null;
	
	public Node getMiddle(Node root){
		Node slow = root;
		Node fast = root;
		
		while (fast != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public String toString(Node root){
		StringBuilder sb = new StringBuilder();
		while(root != null){
			sb.append(root.val + " ");
			root = root.next;
		}
		
		return sb.toString();
	}
	public Node reOrderLisr(Node root){
		Node middle = getMiddle(root);
		Node end = reverseList(middle);
		
		Node newRoot = root;
		
		
		while (end.next!= null){
			Node temp1 = root.next;
			Node temp2 = end.next;
			
			root.next = end;
			end.next = temp1;
			
			root = temp1;
			end = temp2;
		}
		root.next = end;
		return newRoot;
	}
	
	
	public Node reverseList(Node root){
		Node previous = null;
		Node travel = root; 
		
		while( root.next!= null){
			travel = root.next;
			root.next = previous;
			previous = root;
			root = travel;
		}
		
		root.next = previous;
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReOrderList rol = new ReOrderList();
		
		Node a = rol.new Node(1);
		Node b = rol.new Node(2);
		Node c = rol.new Node(3);
		Node d = rol.new Node(4);
		Node e = rol.new Node(5);
		Node f = rol.new Node(6);
		
		rol.root = a;
		
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		//d.next = e;
//		System.out.println(rol.toString(a));
//		System.out.println(rol.toString(rol.getMiddle(a)));
//		
//		System.out.println(rol.toString(rol.reverseList(rol.getMiddle(a))));
		
		
		System.out.println(rol.toString(rol.reOrderLisr(a)));
	}

}
