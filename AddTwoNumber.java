public class AddTwoNumber {

	public class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			next = null;
		}
		
	}

	Node fake = new Node(0);
	Node travel = fake;
	private static Node temp1;
	
	
	
	public Node addTwoNumber(Node one, Node two) {
		
		if (one == null)
			return two;
		if (two == null)
			return one;
		int carryOver = 0;
		while (one != null && two != null) {
			int sum = one.val + two.val;
			travel.next = new Node((sum + carryOver) % 10);
			carryOver = (sum + carryOver) / 10;
			one = one.next;
			two = two.next;
			travel = travel.next;
		}
		
		
		if (two != null) {
			two.val = two.val + carryOver;
			travel.next = two;
		} else if (one != null) {
			one.val = one.val + carryOver;
			travel.next = one;
		}
		return fake.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumber atn = new AddTwoNumber();
		Node a = atn.new Node(2);
		Node b = atn.new Node(4);
		Node c = atn.new Node(3);
		a.next = b;
		b.next = c;
		
		Node d = atn.new Node(5);
		Node e = atn.new Node(6);
		Node f = atn.new Node(4);
		
		d.next = e;
		//e.next = f;
		
		Node result = atn.addTwoNumber(a, d);
		
		while (result != null){
			System.out.println(result.val);
			result = result.next;
		}
		
		
		

	}

}
