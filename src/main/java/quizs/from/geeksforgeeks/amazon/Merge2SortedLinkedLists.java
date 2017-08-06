package quizs.from.geeksforgeeks.amazon;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Merge two sorted linked lists:
 * Write a SortedMerge() function that takes two lists, each of which is sorted
 * in increasing order, and merges the two together into one list which is in
 * increasing order. SortedMerge() should return the new list. The new list should
 * be made by splicing together the nodes of the first two lists.
 *
 *
 * Created by agebriel on 7/31/17.
 */
public class Merge2SortedLinkedLists
{
	/*
	* Merge is one of those nice recursive problems where the recursive
	* solution code is much cleaner than the iterative code. You probably
	* wouldn't want to use the recursive version for production code however,
	* because it will use stack space which is proportional to the length of the lists.
	*/
	private static Node SortedMerge(Node a, Node b)
	{
		Node result = null;

	  //Either a or b is empty linked list
		if (a == null)
			return b;
		else if (b==null)
			return a;

	  /* Pick either a or b, and recur */
		if (a.data <= b.data)
		{
			result = a;
			result.next = SortedMerge(a.next, b);
		}
		else
		{
			result = b;
			result.next = SortedMerge(a, b.next);
		}
		return(result);
	}
	private static class Node{
		public int data;
		public Node next;
	}

	/* Function to insert a node at the beginging of the
	   linked list */
	private static void push(Node head, List<Integer> data, int index)
	{
		Node node = new Node();
		head.data = data.get(index);
		int pointer = index +1;
		if(pointer > data.size()-1) return;
		head.next = node;
		push(node, data, pointer);
	}

	/* Function to print nodes in a given linked list */
	private static void printList(Node node)
	{
		System.out.printf("\nMerged Linked List is: ");
		while (node!=null)
		{
			System.out.printf("%d ", node.data);
			node = node.next;
		}

		System.out.printf("\n\n");
	}

	/* Drier program to test above functions*/
	public static void main(String []args)
	{
    /* Start with the empty list */
		Node res = null;


    /* Let us create two sorted linked lists to test
      the functions
       Created lists, a: 5->10->15,  b: 2->3->20 */
		Node a = new Node();
		push(a, Arrays.asList(5,10, 15), 0);

		Node b = new Node();
		push(b, Arrays.asList(2,3,20), 0);

        /* Remove duplicates from linked list */
		res = SortedMerge(a, b);
		printList(res);
	}

}
