package quizs.from.leetcode;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 * For example,
        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 * Created by agebriel on 7/5/17.
 */
public class TrappingRainWater
{
	// return maximum amount of water
	static int findMaxWater(int[] arr)
	{
		int n = arr.length;
		// left[i] contains height of tallest bar to the
		// left of i'th bar including itself
		int left[] = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i-1], arr[i]);

		System.out.print("left: ");
		for(int i=0; i<n; i++)
			System.out.print(left[i] + " ");
		System.out.println();

		// Fill right array
		right[n-1] = arr[n-1];
		for (int i = n-2; i >= 0; i--)
			right[i] = Math.max(right[i+1], arr[i]);

		System.out.print("right: ");
		for(int i=0; i<n; i++)
			System.out.print(right[i] + " ");
		System.out.println();

		System.out.print("arr: ");
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i],right[i]) - arr[i];

		return water;
	}

	// Driver method to test the above function
	public static void main(String[] args)
	{
		//int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1,0,3};
		System.out.println("Maximum water that can be accumulated is " + findMaxWater(arr));
	}
}
