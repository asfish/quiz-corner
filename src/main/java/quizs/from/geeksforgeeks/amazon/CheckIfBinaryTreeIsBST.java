package quizs.from.geeksforgeeks.amazon;

/**
 *
 * A program to check if a binary tree is BST or not
 * A binary search tree (BST) is a node based binary tree data structure which has the following
 * properties.
	 • The left subtree of a node contains only nodes with keys less than the node’s key.
	 • The right subtree of a node contains only nodes with keys greater than the node’s key.
	 • Both the left and right subtrees must also be binary search trees.

 * From the above properties it naturally follows that:
        • Each node (item in the tree) has a distinct key.
 *
 *
 * Method 2 above runs slowly since it traverses over some parts of the tree many times.
 * A better solution looks at each node only once. The trick is to write a utility helper
 * function isBSTUtil(struct node* node, int min, int max) that traverses down the tree
 * keeping track of the narrowing min and max allowed values as it goes, looking at each
 * node only once. The initial values for min and max should be INT_MIN and INT_MAX — they
 * narrow from there.
 *
 *
 * Created by agebriel on 8/5/17.
 */
public class CheckIfBinaryTreeIsBST
{
	//Java implementation to check if given Binary tree
//is a BST or not

	/* Class containing left and right child of current
	 node and key value*/
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
		//Root of the Binary Tree
		static Node root;

    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */

		/* returns true if given search tree is binary
		 search tree (efficient version) */
		private static boolean isBST()  {
			return isBSTUtil(root, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
		}

		/* Returns true if the given tree is a BST and its
		  values are >= min and <= max. */
		private static boolean isBSTUtil(Node node, int min, int max)
		{
        /* an empty tree is BST */
			if (node == null)
				return true;

        /* false if this node violates the min/max constraints */
			if (node.data < min || node.data > max)
				return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
			// Allow only distinct values
			return (isBSTUtil(node.left, min, node.data-1) &&
				isBSTUtil(node.right, node.data+1, max));
		}

		/* Driver program to test above functions */
		public static void main(String args[])
		{
			CheckIfBinaryTreeIsBST tree = new CheckIfBinaryTreeIsBST();
			tree.root = new Node(4);
			tree.root.left = new Node(2);
			tree.root.right = new Node(5);
			tree.root.left.left = new Node(1);
			tree.root.left.right = new Node(3);

			if (tree.isBST())
				System.out.println("IS BST");
			else
				System.out.println("Not a BST");
		}
}
