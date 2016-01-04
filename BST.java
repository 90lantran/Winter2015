import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BST {

	public class Node {
		int value;
		Node left = null;
		Node right = null;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node root = null;

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);

		} else {
			root = insert(value, root);
		}
		return true;
	}

	public Node insert(int value, Node root) {
		if (root == null) {
			return root = new Node(value);
		}
		if (root.value > value) {
			root.left = insert(value, root.left);
		} else {
			root.right = insert(value, root.right);
		}
		return root;
	}

	public void toString(Node node) {

		if (node != null) {
			toString(node.left);
			System.out.println(node.value);
			toString(node.right);
		}

	}

	public boolean hasPathSum(Node root, int sum) {
		//if (root == null) return false;
		if (root == null) {
			return sum == 0;
		} else {
			int subsum = sum - root.value;
			return (hasPathSum(root.left, subsum) || hasPathSum(root.right,
					subsum));

		}
		
	}
	
	
	public int maxPathSum(Node root){
		int currentMax ;
		if (root != null){
			currentMax = root.value + Math.max(maxPathSum(root.left),maxPathSum(root.right));
		} else {
			return 0;
		}
		return currentMax;
	}
	
	public List<List<Integer>> path(Node node, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		path(node, sum, list, new ArrayList<Integer>());

		return list;
	}

	public void path(Node node, int sum,
			List<List<Integer>> list, List<Integer> l) {
		// int subsum = sum - node.value;
		// List<Integer> l = new ArrayList<Integer>();
		// l.add(node.value);
		if (node == null) return;
		int subsum = sum - node.value;
		l.add(node.value);
		
		if (node.left == null && node.right == null && subsum == 0) {
			list.add(l);
		} else {	
			
			path(node.left, subsum, list, new ArrayList<Integer>(l));
			path(node.right, subsum, list, new ArrayList<Integer>(l));
			
		}
		
	}
	
	
//	public List<List<Integer>> pathSum(Node root, int sum) {
//		List<List<Integer>> list = new ArrayList<>();
//		helper(root, sum, 0, list, new ArrayList<Integer>());
//
//		return list;
//	}
//
//	public void helper(Node root, int sum, int currentSum,
//			List<List<Integer>> list, List<Integer> path) {
//			    if (root == null) return;
//		path.add(root.value);
//		currentSum += root.value;
//		if (root.left == null && root.right == null && sum == currentSum) {
//			list.add(path);
//		}
//
//		if (root.left != null) {
//			helper(root.left, sum, currentSum, list, new ArrayList<>(path));
//		}
//
//		if (root.right != null) {
//			helper(root.right, sum, currentSum, list, new ArrayList<>(path));
//		}
//	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(4);
		bst.insert(8);
		bst.insert(13);
		bst.insert(0);
		bst.insert(7);
		bst.insert(11);
		bst.toString(bst.root);
		System.out.println(bst.hasPathSum(bst.root, 37));
		
		List<List<Integer>> l = bst.path(bst.root, 26);
		System.out.println(l.toString());
		
		int max = bst.maxPathSum(bst.root);
		List<List<Integer>> l2 = bst.path(bst.root, max);
		System.out.println(l2.toString());
	}

}
