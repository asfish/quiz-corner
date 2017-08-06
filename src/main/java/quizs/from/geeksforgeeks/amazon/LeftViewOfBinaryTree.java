package quizs.from.geeksforgeeks.amazon;

/**
 * Print Left View of a Binary Tree
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set
 * of nodes visible when tree is visited from left side. Left view of following
 * tree is 12, 10, 25.

			    12
			 /     \
		   10       30
		           /   \
				 25     40

 *
 *
 * Created by agebriel on 8/6/17.
 */
public class LeftViewOfBinaryTree
{
	private static class Node
	{
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = right = null;
		}
	}

	Node root;
	static int  max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node node, int level)
	{
		// Base Case
		if (node==null) return;

		// If this is the first node of its level
		if (max_level < level)
		{
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level+1);
		leftViewUtil(node.right, level+1);
	}

	// A wrapper over leftViewUtil()
	void leftView()
	{
		leftViewUtil(root, 1);
	}

	/* testing for example nodes */
	public static void main(String args[])
	{
    /* creating a binary tree and entering the nodes */
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		tree.leftView();
	}

}
