package quizs.from.geeksforgeeks.amazon;

/**
 * Created by agebriel on 7/5/17.
 */

class Node
{
	int data;
	Node left, right;

	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

public class SumPropertyInBinaryTree
{
	Node root;

	private static boolean isSumPropertyFulfilled(Node node)
	{
		int ld=0, rd=0;

		if(node.left != null)
			ld = node.left.data;
		if(node.right != null)
			rd = node.right.data;

		if((node.data == ld+rd)
			&& isSumPropertyFulfilled(node.left)
			&& isSumPropertyFulfilled(node.right))
			return true;

		return false;

	}

	public static void main(String[] args)
	{
		SumPropertyInBinaryTree tree = new SumPropertyInBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(2);
		if (tree.isSumPropertyFulfilled(tree.root))
			System.out.println("The given tree satisfies children"
				+ " sum property");
		else
			System.out.println("The given tree does not satisfy children"
				+ " sum property");
	}
}
