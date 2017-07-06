package quizs.from.geeksforgeeks.amazon;


import java.util.Collections;
import java.util.PriorityQueue;


/**
 *
 * Minimum sum of squares of character counts in a given string after removing k characters
 * ========================================================================================
 * Given a string of lowercase alphabets and a number k, the task is to print the minimum value of the
 * string after removal of ‘k’ characters. The value of a string is defined as the sum of squares of the
 * count of each distinct character. For example consider the string “saideep”, here frequencies of
 * characters are s-1, a-1, i-1, e-2, d-1, p-1 and value of the string is
 * 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9.

 * Expected Time Complexity : O(n)

 * Examples:
 * ---------

    Input :  str = abccc, K = 1
    Output :  6
    We remove c to get the value as 11 + 11 + 22

    Input :  str = aaab, K = 2
    Output :  2
 *
 *
 * A Simple solution: is to use sorting technique through all current highest frequency reduce up to
 * k times. For After every reduce again sort frequency array.
 *
 * A Better Solution: used to Priority Queue which has to the highest element on top.
 *
 *      Initialize empty priority queue.
 *      Count frequency of each character and Store into temp array.
 *      Remove K characters which have highest frequency from queue.
 *      Finally Count Sum of square of each element and return it.
 *
 *
 * Created by agebriel on 7/5/17.
 */
public class MinSumSqrCharCountInStr
{
	private final static int MAX_CHAR = 26;

	// Main Function to calculate min sum of
// squares of characters after k removals
	private static int minStringValue(String str, int k)
	{
		int l = str.length(); // find length of string

		// if K is greater than length of string
		// so reduced string will become 0
		if (k >= l)
			return 0;

		// Else find Frequency of each character and
		// store in an array
		int[] frequency = new int[MAX_CHAR];
		for (int i=0; i<l; i++)
			frequency[str.charAt(i)-'a']++;

		for(int i=0; i<MAX_CHAR; i++)
			System.out.print(frequency[i] + " ");
		System.out.println();

		// Push each char frequency into a priority_queue
		//you need to order it in desc order. you can also use your own custom comparator
		PriorityQueue<Integer> q = new PriorityQueue(MAX_CHAR, Collections.reverseOrder());

		for (int i=0; i<MAX_CHAR; i++)
			if(frequency[i]>0)
				q.offer(frequency[i]);

		//This loop does not necessarily print elements in the order of the actual priority order
		for (Integer i : q){ //.toArray(new Integer[q.size()])) {
			System.out.print(i +" ");
		}
		System.out.println();

		// Removal of K characters
		while (0<k--)
		{
			int temp = q.remove();
			//System.out.println("temp: " +temp);
			temp = temp-1;
			q.offer(temp);
		}

		// After removal of K characters find sum
		// of squares of string Value
		int result = 0; // Initialize result
		while (!q.isEmpty())
		{
			int temp = q.poll();
			result += temp*temp;
		}

		return result;
	}

	// Driver Code
	public static void main(String[] args)
	{
		String str = "abbccc";   // Input 1
		int k = 2;
		System.out.println(minStringValue(str, k));

		str = "aaab";           // Input 2
		k = 2;
		System.out.println(minStringValue(str, k));
	}
}
