package quizs.from.leetcode;

import java.util.Arrays;

/**
 *
 * Given an unsorted integer array, find the first missing positive integer.

 * For example,
        Given [1,2,0] return 3,
        and [3,4,-1,1] return 2.

 * Your algorithm should run in O(n) time and uses constant space.

 * Created by agebriel on 7/5/17.
 */
public class FirstMissingPositiveNum
{
	public static void main(String[] args)
	{
		//int[] num2 = {1,2,0}; // return 3,
		//int[] nums = {3,1,2,0}; // return 4,
		//int[] nums = {3,4,-1,1}; // return 2.
		//int[] nums = {3,4,-1,1,2,-9,-12};
		int nums[] = {0, 10, 2, -10, -20};

		//System.out.println(Arrays.stream(num2).min().getAsInt());
		//System.out.println(Arrays.stream(num2).max().getAsInt());

		//IntSummaryStatistics stat = Arrays.stream(num2).summaryStatistics();
		//System.out.println("Min = " + stat.getMin());
		//System.out.println("Max = " + stat.getMax());

		System.out.println("missing: " + findMissing(nums));

	}

	private static int findMissing(int arr[])
	{
		// First separate positive and negative numbers
		int shift = segement (arr);

		// Shift the array and call findMissingPositive for positive part
		return findMissingPositive(Arrays.copyOfRange(arr, shift, arr.length));
	}

	private static int findMissingPositive(int[] arr)
	{
		int i, size = arr.length;

		// Mark arr[i] as visited by -ve. Note that
		// 1 is subtracted because index start from 0 and positive numbers start from 1
		for(i = 0; i < size; i++)
		{
			if(Math.abs(arr[i]) <= size)
				arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
		}

		// Return the first index value at which is positive
		for(i = 0; i < size; i++)
			if (arr[i] > 0)
				return i+1;  // 1 is added becuase indexes start from 0

		return size+1;
	}

	//move -ves and zero to the left and find the shift where positiveint nums start
	private static int segement (int arr[])
	{
		int j = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if (arr[i] <= 0)
			{
				//swap(arr, i,j);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;  // increment count of non-positive integers
			}
		}

		return j;
	}
}
