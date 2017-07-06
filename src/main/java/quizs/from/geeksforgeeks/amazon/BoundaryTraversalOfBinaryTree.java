package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting
 * from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”
 *
 *                       20
 *                     /   \
 *                    8    22
 *                  /  \     \
 *                4     12    25
 *                     /  \
 *                   10    14
 *
 *
 *We break the problem in 3 parts:
        1. Print the left boundary in top-down manner.
        2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
            2.1 Print all leaf nodes of left sub-tree from left to right.
            2.2 Print all leaf nodes of right subtree from left to right.
        3. Print the right boundary in bottom-up manner.

 *We need to take care of one thing that nodes are not printed again. e.g. The left most node is
 *also the leaf node of the tree.
 *
 * Created by agebriel on 7/5/17.
 */
public class BoundaryTraversalOfBinaryTree
{
	/* A binary tree node has data, pointer to left child
   and a pointer to right child */
	private static class Node
	{
		int data;
		Node left, right;

		Node(int item)
		{
			data = item;
			left = right = null;
		}
	}

	Node root;

	// A simple function to print leaf nodes of a binary tree
	void printLeaves(Node node)
	{
		if (node != null)
		{
			printLeaves(node.left);

			// Print it if it is a leaf node
			if (node.left == null && node.right == null)
				System.out.print(node.data + " ");
			printLeaves(node.right);
		}
	}

	// A function to print all left boundry nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	void printBoundaryLeft(Node node)
	{
		if (node != null)
		{
			if (node.left != null)
			{

				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			}
			else if (node.right != null)
			{
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to print all right boundry nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	void printBoundaryRight(Node node)
	{
		if (node != null)
		{
			if (node.right != null)
			{
				// to ensure bottom up order, first call for right
				//  subtree, then print this node
				printBoundaryRight(node.right);
				System.out.print(node.data + " ");
			}
			else if (node.left != null)
			{
				printBoundaryRight(node.left);
				System.out.print(node.data + " ");
			}
			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to do boundary traversal of a given binary tree
	void printBoundary(Node node)
	{
		if (node != null)
		{
			System.out.print(node.data + " ");

			// Print the left boundary in top-down manner.
			printBoundaryLeft(node.left);

			// Print all leaf nodes
			printLeaves(node.left);
			printLeaves(node.right);

			// Print the right boundary in bottom-up manner
			printBoundaryRight(node.right);
		}
	}

	// Driver program to test above functions
	public static void main(String args[])
	{
		BoundaryTraversalOfBinaryTree tree = new BoundaryTraversalOfBinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.printBoundary(tree.root);

	}

}
