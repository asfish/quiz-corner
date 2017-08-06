package quizs.from.geeksforgeeks.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Find k-th smallest element in BST (Order Statistics in BST)
 * Given root of binary search tree and K as input, find K-th smallest element in BST.

 * For example, in the following BST, if k = 3, then output should be 10, and if k = 5, then
 * output should be 14.
 *
 **
 *                      20
 *                    /    \
 *                   8      22
 *                 /   \
 *                4    12
 *                    /   \
 *                  10    14
 *
 *
 * Created by agebriel on 8/5/17.
 */
public class K_thSmallestElementInBST
{
	private static class Node
	{
		int key;
		Node left, right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	// Root of Binary Tree
	Node root;

	K_thSmallestElementInBST()
	{
		root = null;
	}

	/* Given a binary tree, print its nodes according to the
	  "bottom-up" postorder traversal. */
	void printPostorder(Node node)
	{
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder*/
	void printInorder(Node node)
	{
		if (node == null)
			return;

        /* first recur on left child */
		printInorder(node.left);

        /* then print the data of node */
		System.out.print(node.key + " ");

        /* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder*/
	void printPreorder(Node node)
	{
		if (node == null)
			return;

        /* first print data of node */
		System.out.print(node.key + " ");

        /* then recur on left sutree */
		printPreorder(node.left);

        /* now recur on right subtree */
		printPreorder(node.right);
	}

	static void printKthSmallestElement(Node node, List<Integer> arr)
	{
		if (node == null)
			return;
        /* first recur on left child */
		printKthSmallestElement(node.left, arr);
			arr.add(node.key);
        /* now recur on right child */
		printKthSmallestElement(node.right, arr);
	}

	public static void main(String[] args)
	{
		K_thSmallestElementInBST tree = new K_thSmallestElementInBST();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);

		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(tree.root);

		int kth = 5;
		List<Integer> arr = new ArrayList<Integer>();
		printKthSmallestElement(tree.root, arr);
		System.out.println("\nkth smallest element is " + arr.get(kth-1));

	}
}
