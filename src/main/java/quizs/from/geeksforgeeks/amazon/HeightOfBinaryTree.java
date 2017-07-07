package quizs.from.geeksforgeeks.amazon;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

import quizs.from.geeksforgeeks.amazon.shortestsubsegment.Queue;

/**
 *
 * Iterative Method to find Height of Binary Tree:
 *There are two conventions to define height of Binary Tree
        1) Number of nodes on longest path from root to the deepest node.
        2) Number of edges on longest path from root to the deepest node.
 *
 * Recursive method to find height of Binary Tree is discussed here. How to find height
 * without recursion? We can use level order traversal to find height without recursion.
 * The idea is to traverse level by level. Whenever move down to a level, increment height
 * by 1 (height is initialized as 0). Count number of nodes at each level, stop traversing
 * when count of nodes at next level is 0.
 *
 * Following is detailed algorithm to find level order traversal using queue.

    Create a queue.
    Push root into the queue.
    height = 0
    Loop
    nodeCount = size of queue

    // If number of nodes at this level is 0, return height
    if nodeCount is 0
        return Height;
    else
        increase Height

    // Remove nodes of this level and add nodes of
    // next level
    while (nodeCount > 0)
        pop node from front
        push its children to queue
        decrease nodeCount
        // At this point, queue has nodes of next level
 *
 *
 *
 *
 * http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
 *
 * Created by agebriel on 7/6/17.
 */
public class HeightOfBinaryTree
{
	private static class Node{
		Node left, right;
		int data;

		public Node(int data){
			this.data = data;
		}
	}

	private static int getTreeHeight(Node root)
	{
		if(root == null)
			return 0;

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		int height = 0;

		while(true)
		{
			int nodeCount = q.size();
			if(nodeCount==0)
				return height;

			height++;
			while (nodeCount > 0)
			{
				Node n = q.peek();
				q.remove();
				nodeCount--;
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
		}

	}

	public static void main(String args[])
	{
		// Let us create a binary tree shown in above diagram
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Height of tree is " + getTreeHeight(root));
	}
}
