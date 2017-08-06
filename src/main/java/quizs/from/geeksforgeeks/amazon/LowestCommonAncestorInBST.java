package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Lowest Common Ancestor in a Binary Search Tree.
 * Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common
 * Ancestor (LCA). You may assume that both the values exist in the tree.
 *
 *                      20
 *                    /    \
 *                   8      22
 *                 /   \
 *                4    12
 *                    /   \
 *                  10    14
 *
 *      LCA of 10 and 14 is 12
 *      LCA of 14 and 8 is 8
 *      LCA of 10 and 22 is 20
 *
 *
 * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as
 * the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a
 * descendant of itself).

 * The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from
 * the root. Computation of lowest common ancestors may be useful, for instance, as part of a
 * procedure for determining the distance between pairs of nodes in a tree: the distance from n1
 * to n2 can be computed as the distance from the root to n1, plus the distance from the root to
 * n2, minus twice the distance from the root to their lowest common ancestor.
 *
 * If we are given a BST where every node has parent pointer, then LCA can be easily determined
 * by traversing up using parent pointer and printing the first intersecting node.
 *
 * We can solve this problem using BST properties. We can recursively traverse the BST from root.
 * The main idea of the solution is, while traversing from top to bottom, the first node n we
 * encounter with value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or n2, is
 * LCA of n1 and n2 (assuming that n1 < n2). So just recursively traverse the BST in, if node’s
 * value is greater than both n1 and n2 then our LCA lies in left side of the node, if it’s is
 * smaller than both n1 and n2, then LCA lies on right side. Otherwise root is LCA (assuming
 * that both n1 and n2 are present in BST)
 *
 *
 * Created by agebriel on 8/5/17.
 */
public class LowestCommonAncestorInBST
{
	// Recursive Java program to print lca of two nodes
	// A binary tree node
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

	/* Function to find LCA of n1 and n2. The function assumes that both
	   n1 and n2 are present in BST */
	Node lca(Node node, int n1, int n2)
	{
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	/* Driver program to test lca() */
	public static void main(String args[])
	{
		// Let us construct the BST shown in the above figure
		LowestCommonAncestorInBST tree = new LowestCommonAncestorInBST();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}
}
