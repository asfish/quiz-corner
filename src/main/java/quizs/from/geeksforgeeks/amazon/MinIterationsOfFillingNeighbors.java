package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Fill array with 1’s using minimum iterations of filling neighbors
 * =================================================================
 * Given an array of 0s and 1s, in how many iterations the whole array can be filled with 1s
 * if in a single iteration immediate neighbors of 1s can be filled.

 * NOTE: If we cannot fill array with 1s, then print “-1” .

 * Examples:

        Input : arr[] = {1, 0, 1, 0, 0, 1, 0, 1,
                            1, 0, 1, 1, 0, 0, 1}

        Output : 1

        To convert the whole array into 1s, one iteration
        is required. Between indexes i=2 and i=5, the zero
        at i=3 would be converted to '1' due to its neighbours
        at i=2 similarly the zero at i=4 would be converted
        into '1' due to its neighbor at i=5, all this can
        be done in a single iteration. Similarly all 0's can
        be converted to 1 in single iteration.

        Input : arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 0,
                    1, 1, 1, 1, 0, 0, 0, 1}
		 Output : 2
 *
 *
 *
 * It is given that a single 1 can convert both its 0 neighbours to 1. This problem boils down to three cases :
 *
 *   Case 1 : A block of 0s has 1s on both sides
        Let count_zero be the count of zeros in the block.

        Number of iterations are always equal to :
        count_zero/2   if (count_zero is even)
        count_zero+1)/2    if(count_zero is odd).

 *    Case 2 : Either single 1 at the end or in
        the starting. For example 0 0 0 0 1 and
        1 0 0 0 0
        In this case the number of iterations required will
        always be equal to number of zeros.

 *    Case 3 : There are no 1s (Array has only 0s)
        In this case array can't be filled with all 1's.
        So print -1.
 *
 * Algorithm :
 * -----------
        1-Start traversing the array.
            a) Traverse until a 0 is found.
                while (i<n &&a[i]==1)
                {
                    i++;
                    flag=true;
                }
            Flag is set to true just to check at
            the last if array contains any 1 or not.

            b) Traverse until a 1 is found and Count
                contiguous 0 .
                    while (i<n &&a[i]==0)
                    {
                        count_zero++;
                        i++;
                    }

            c) Now check which case is satisfied by
                current subarray. And update iterations
                using count and update max iterations.
 *
 * Created by agebriel on 7/5/17.
 */
public class MinIterationsOfFillingNeighbors
{
	// Returns count of iterations to fill arr[]
	// with 1s.
	static int countIterations(int arr[], int n)
	{
		boolean oneFound = false;
		int res = 0;

		// Start traversing the array
		for (int i=0; i<n; )
		{
			if (arr[i] == 1)
				oneFound = true;

			// Traverse until a 0 is found
			while (i<n && arr[i]==1)
				i++;

			// Count contiguous 0s
			int count_zero = 0;
			while (i<n && arr[i]==0)
			{
				count_zero++;
				i++;
			}

			// Condition for Case 3
			if (oneFound == false && i == n)
				return -1;

			// Condition to check if Case 1 satisfies:
			int curr_count;
			if (i < n && oneFound == true)
			{
				// If count_zero is even
				if ((count_zero & 1) == 0)
					curr_count = count_zero/2;

					// If count_zero is odd
				else
					curr_count = (count_zero+1)/2;

				// Reset count_zero
				count_zero = 0;
			}

			// Case 2
			else
			{
				curr_count = count_zero;
				count_zero = 0;
			}

			// Update res
			res = Math.max(res, curr_count);
		}

		return res;
	}

	// Driver method
	public static void main(String[] args)
	{
		int arr[] = {0, 1, 0, 0, 1, 0, 0,
			0, 0, 0, 0, 0, 1, 0};
		int arr1[] = {1, 0, 1, 0, 0, 1, 0, 1,
			1, 0, 1, 1, 0, 0, 1};

		int arr2[] = {0, 0, 1, 1, 0, 0, 1, 1, 0,
			1, 1, 1, 1, 0, 0, 0, 1};

		int[] arr3 = {1,0,0,0,0,0,0};
		int[] arr4 = {0,0,0,0,0,0,0,0,0,1};

		System.out.println(countIterations(arr, arr.length));
		System.out.println(countIterations(arr1, arr1.length));
		System.out.println(countIterations(arr2, arr2.length));
		System.out.println(countIterations(arr3, arr3.length));
		System.out.println(countIterations(arr4, arr4.length));

	}
}
