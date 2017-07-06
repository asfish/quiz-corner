package quizs.from.geeksforgeeks.amazon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *Modify contents of Linked List:
 *===============================
 * Given a singly linked list containing n nodes. Modify the value of first half nodes such that
 * 1st node’s new value is equal to the last node’s value minus first node’s current value, 2nd
 * node’s new value is equal to the second last node’s value minus 2nd node’s current value,
 * likewise for first half nodes. If n is odd then the value of the middle node remains unchanged.
 (No extra memory to be used).

 Examples:

 Input : 10 -> 4 -> 5 -> 3 -> 6
 Output : 4 -> 1 -> 5 -> 3 -> 6

 Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
 Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10
 *
 *
 * Approach: The following steps are:
 * ----------------------------------
 *  1. Split the list from the middle. Perform front and back split. If the number
 *     of elements is odd, the extra element should go in the 1st(front) list.
 *  2. Reverse the 2nd(back) list.
 *  3. Perform the required subtraction while traversing both list simultaneously.
 *  4. Again reverse the 2nd list.
 *  5. Concatenate the 2nd list back to the end of the 1st list.
 *
 * Created by agebriel on 7/4/17.
 */
public class LinkedListContentModifier
{

	public static void main(String[] args)
	{
		List<Integer> nums = new LinkedList<Integer>();
		//nums.addAll(Arrays.asList(10,7,12,8,9,2));
		//nums.addAll(Arrays.asList(10,4,5,3,6));
		nums.addAll(Arrays.asList(2,9,8,12,7,10));
		int l=0, r=nums.size()-1;

		for(Integer i : nums)
		{
			nums.set(l, nums.get(l)-nums.get(r));
			if(((r--)-(l++)<=2))
				break;
		}

		for(int i=0; i<nums.size(); i++)
			System.out.println(nums.get(i));
	}
}
