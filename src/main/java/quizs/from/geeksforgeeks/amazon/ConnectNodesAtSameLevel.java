package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Connect nodes at same level
 * ===========================
 * Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure
 * of the given Binary Tree node is like following.

    struct node{
        int data;
        struct node* left;
        struct node* right;
        struct node* nextRight;
    }

 * Initially, all the nextRight pointers point to garbage values. Your function should set these pointers
 * to point next right for each node.

 * Example
 * -------

    Input Tree
         A
        / \
      B    C
    /  \   \
   D   E   F


    Output Tree
        A--->NULL
       / \
      B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
 *
 *
 *
 * Solution:
 * ---------
 *      Method 1 (Extend Level Order Traversal or BFS)
 *          Consider the method 2 of Level Order Traversal. The method 2 can easily be extended to
 *          connect nodes of same level. We can augment queue entries to contain level of nodes also
 *          which is 0 for root, 1 for root’s children and so on. So a queue node will now contain a
 *          pointer to a tree node and an integer level. When we enqueue a node, we make sure that
 *          correct level value for node is being set in queue. To set nextRight, for every node N,
 *          we dequeue the next node from queue, if the level number of next node is same, we set the
 *          nextRight of N as address of the dequeued node, otherwise we set nextRight of N as NULL.
 *
 *          Time Complexity: O(n)

 *      Method 2 (Extend Pre Order Traversal)
 *          This approach works only for Complete Binary Trees. In this method we set nextRight in Pre
 *          Order fashion to make sure that the nextRight of parent is set before its children. When we
 *          are at node p, we set the nextRight of its left and right children. Since the tree is complete
 *          tree, nextRight of p’s left child (p->left->nextRight) will always be p’s right child, and
 *          nextRight of p’s right child (p->right->nextRight) will always be left child of p’s nextRight
 *          (if p is not the rightmost node at its level). If p is the rightmost node, then nextRight of
 *          p’s right child will be NULL.
 *
 *          Time Complexity: O(n)
 *
 *          http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 * Created by agebriel on 7/5/17.
 */
public class ConnectNodesAtSameLevel
{
	private static class Node
	{
		int data;
		Node left, right, nextRight;

		Node(int item)
		{
			data = item;
			left = right = nextRight = null;
		}
	}

	Node root;

	// Sets the nextRight of root and calls connectRecur() for other nodes
	void connect(Node p)
	{

		// Set the nextRight for root
		p.nextRight = null;

		// Set the next right for rest of the nodes (other than root)
		connectRecur(p);
	}

	/* Set next right of all descendents of p.
	   Assumption:  p is a compete binary tree */
	void connectRecur(Node p)
	{
		// Base case
		if (p == null)
			return;

		// Set the nextRight pointer for p's left child
		if (p.left != null)
			p.left.nextRight = p.right;

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child
		// at its level
		if (p.right != null)
			p.right.nextRight = (p.nextRight != null) ?
				p.nextRight.left : null;

		// Set nextRight for other nodes in pre order fashion
		connectRecur(p.left);
		connectRecur(p.right);
	}

	// Driver program to test above functions
	public static void main(String args[])
	{
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);

		// Populates nextRight pointer in all nodes
		tree.connect(tree.root);

		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in "
			+ "the tree" + "(-1 is printed if there is no nextRight)");
		int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.data + " is "
			+ a);
		int b = tree.root.left.nextRight != null ?
			tree.root.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.data + " is "
			+ b);
		int c = tree.root.right.nextRight != null ?
			tree.root.right.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.right.data + " is "
			+ c);
		int d = tree.root.left.left.nextRight != null ?
			tree.root.left.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.left.data + " is "
			+ d);

	}
}
