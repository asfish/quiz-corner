package quizs.from.geeksforgeeks.amazon;

/**
 * Print middle level of perfect binary tree without finding height
 * Given a perfect binary tree, print nodes of middle level without computing its height. A perfect
 * binary tree is a binary tree in which all interior nodes have two children and all leaves have
 * the same depth or same level.
 *
 * http://www.geeksforgeeks.org/print-middle-level-perfect-binary-tree-without-finding-height/
 *
 *
 * The idea is similar to method 2 of finding middle of singly linked list.

 * Use fast and slow (or tortoise) pointers in each route of a the tree.
	 1. Advance fast pointer towards leaf by 2.
	 2. Advance slow pointer towards lead by 1.
	 3. If fast pointer reaches the leaf print value at slow pointer
	 4. Call recursively the next route.
 *
 * Created by agebriel on 8/4/17.
 */
public class MiddleLevelOfPerfectBinaryTree
{
	private static class Node
	{
		public int data;
		public Node left;
		public Node right;
		public Node(int val)
		{
			this.left = null;
			this.right = null;
			this.data = val;
		}
	}

	// Takes two parameters - same initially and
	// calls recursively
	private static void printMiddleLevelUtil(Node a, Node b)
	{
		// Base case e
		if (a == null || b == null)
			return;

		// Fast pointer has reached the leaf so print
		// value at slow pointer
		if ((b.left == null) && (b.right == null))
		{
			System.out.print(a.data + " ");
			return;
		}

		// Recursive call
		// root.left.left and root.left.right will print same value
		// root.right.left and root.right.right will print same value
		// So we use any one of the condition
		printMiddleLevelUtil(a.left, b.left.left);
		printMiddleLevelUtil(a.right, b.left.left);
	}

	// Main printing method that take a Tree as input
	public static void printMiddleLevel(Node node)
	{
		printMiddleLevelUtil(node, node);
	}

	public static void main(String[] args)
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n1.left = n2;
		n1.right = n3;

		printMiddleLevel(n1);
	}
}
