package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Find the index of first 1 in a sorted array of 0’s and 1’s
 * Given a sorted array consisting 0’s and 1’s. The problem is to find the index of first ‘1’
 * in the sorted array. It could be possible that the array consists of only 0’s or only 1’s.
 * If 1’s are not present in the array then print “-1”.

 * Examples:
	 Input : arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}
	 Output : 6
	 The index of first 1 in the array is 6.

	 Input : arr[] = {0, 0, 0, 0}
	 Output : -1
	 1's are not present in the array.
 *
 *
 * Created by agebriel on 8/4/17.
 */
public class IndexOfFirst1InSortedArrayOf0And1s
{
	// function to find the index of first '1'
// binary search technique is applied
	private static int indexOfFirstOne(int arr[], int low, int high)
	{
		while (low <= high) {
			int mid = (low + high) / 2;

			// if true, then 'mid' is the index of first '1'
			if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
				return mid;

				// first '1' lies to the left of 'mid'
			else if (arr[mid] == 1)
				high = mid - 1;

				// first '1' lies to the right of 'mid'
			else
				low = mid + 1;
		}

		// 1's are not present in the array
		return -1;
	}

	public static void main(String[] args)
	{
		int arr[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
		int n = arr.length;
		System.out.println(indexOfFirstOne(arr, 0, n - 1));
	}
}
