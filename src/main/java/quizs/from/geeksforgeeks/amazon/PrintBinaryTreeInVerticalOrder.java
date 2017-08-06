package quizs.from.geeksforgeeks.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)
 Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

			    1
			 /     \
			2       3
		   / \    /  \
		  4   5  6   7
			      \   \
			      8   9


 The output of print this tree vertically will be:
 4
 2
 1 5 6
 3 8
 7
 9




 * Created by agebriel on 8/5/17.
 */
public class PrintBinaryTreeInVerticalOrder
{
	private static class Node
	{
		int key;
		Node left, right;
	}

	// A utility function to create a new node
	private static Node newNode(int key)
	{
		Node node = new Node();
		node.key = key;
		node.left = node.right = null;
		return node;
	}

	// Utility function to store vertical order in map 'm'
	// 'hd' is horizontal distance of current node from root.
	// 'hd' is initially passed as 0
	private static void getVerticalOrder(Node root, int hd, Map<Integer, List<Integer>> m)
	{
		// Base case
		if (root == null)
			return;

		List<Integer> vns = null;
		// Store current node in map 'm'
		if(m.get(hd) == null)
		{
			vns = new ArrayList<Integer>();
			vns.add(root.key);
		}
		else
		{
			vns = m.get(hd);
			vns.add(root.key);
		}
		m.put(hd, vns);

		// Store nodes in left subtree
		getVerticalOrder(root.left, hd-1, m);

		// Store nodes in right subtree
		getVerticalOrder(root.right, hd+1, m);
	}

	// The main function to print vertical oder of a binary tree
	// with given root
	private static void printVerticalOrder(Node root)
	{
		// Create a map and store vertical oder in map using
		// function getVerticalOrder()
		Map < Integer,List<Integer>> m = new HashMap<Integer, List<Integer>>();
		int hd = 0;
		getVerticalOrder(root, hd,m);

		// Traverse the map and print nodes at every horigontal
		// distance (hd)
		//Map< Integer,Vector<Integer>>  iterator it;
		List<Integer> keys = new ArrayList(m.keySet());
		Collections.sort(keys);
		for (int num : keys)
		{
			for(int n : m.get(num))
				System.out.print(n + " ");
			System.out.println();
		}
	}


	public static void main(String[] args)
	{
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		root.right.left.right = newNode(8);
		root.right.right.right = newNode(9);
		System.out.print("Vertical order traversal is \n");
		printVerticalOrder(root);

	}
}
