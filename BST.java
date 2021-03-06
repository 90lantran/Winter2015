import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.naming.LimitExceededException;
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
	
	
	public void printAllPaths(Node root){
		printAllPaths(root, "");
	}
	
	public void printAllPaths(Node root, String s){
		if (root == null){
			return;
		}
		s += root.value ;
		if (root.left == null && root.right == null){
			System.out.println(s);
		} else {
			printAllPaths(root.left, s + " " );
			printAllPaths(root.right, s + " ");
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
	public static void increaseByOne(Node root){
		
		
		if (root != null){
			root.value = root.value +1;
			increaseByOne(root.left);
			increaseByOne(root.right);
		}
		
	}
	
	public int max(){
		
		return maxHelper(0,0,root);
	}
	
	public int maxHelper(int currentmax,int run, Node node){
		if (node == null){
			currentmax = currentmax >= run ? currentmax:run;
		}else {
			run += node.value;
			currentmax =maxHelper(currentmax, run, node.left);
			currentmax =maxHelper(currentmax, run,node.left);
		}
		return currentmax;
	}
	
	public void limitPathSum(int limit){
		root = limitPathSum(limit, root);
	}
	
	public Node limitPathSum(int limit, Node node){
		if (node == null || node.value > limit) {
			node = null;
			return node;
		}
	
			
		
		limit = limit - node.value;
		node.left = limitPathSum(limit, node.left);
		node.right = limitPathSum(limit, node.right);
		
		return node;
				
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(4);
		bst.insert(8);
		bst.insert(13);
		bst.insert(0);
		bst.insert(7);
		bst.insert(11);
//		System.out.println("At the begining");
//		bst.toString(bst.root);
		System.out.println(bst.hasPathSum(bst.root, 37));
		
		System.out.println(bst.max());
		
		List<List<Integer>> l = bst.path(bst.root, 26);
		System.out.println(l.toString());
		
		int max = bst.maxPathSum(bst.root);
		List<List<Integer>> l2 = bst.path(bst.root, max);
		System.out.println(l2.toString());
		
		bst.printAllPaths(bst.root);
		
		System.out.println("At the begining:");
		bst.toString(bst.root);
		increaseByOne(bst.root);
		System.out.println("After increasing: ");
		bst.toString(bst.root);
		
		
		System.out.println("testing limit pathSum");
		BST tree = new BST();
		Node a = tree.new Node(29);
		Node b = tree.new Node(17);
		Node c = tree.new Node(15);
		Node d = tree.new Node(-7);
		Node e = tree.new Node(37);
		Node f = tree.new Node(11);
		Node g = tree.new Node(12);
		Node h = tree.new Node(16);
		Node i = tree.new Node(4);
		Node j = tree.new Node(14);
		Node k = tree.new Node(-9);
		Node m = tree.new Node(19);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = f;
		d.right = g;
		e.right = h;
		
		c.left = i;
		c.right = j;
		j.left = k;
		j.right =m;
		tree.root = a;
		
		tree.limitPathSum(28);
		
		tree.toString(tree.root);
		
		
	}

}
