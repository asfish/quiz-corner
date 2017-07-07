package quizs.from.geeksforgeeks.amazon;

/**
 * Maximize number of 0s by flipping a subarray
 * Given a binary array, find the maximum number zeros in an array with one flip of a subarray allowed. A flip operation switches all 0s to 1s and 1s to 0s.

 * Examples:
        Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
        Output : 6
        We can get 6 zeros by flipping the subarray {1, 1}

        Input :  arr[] = {0, 0, 0, 1, 0, 1}
        Output : 5
 *
 * Created by agebriel on 7/7/17.
 */
public class MaxNumOf0sByFlippingSubArray
{
	private static int max0sCount(int[] arr){
		int maxSubArr=0, original0s =0, tmp = 0;

		for(int i=0; i<arr.length; i++){

			if(arr[i] == 1)
				tmp++;
			else
			{
				//keep track of original num of 0s
				original0s++;
				if(maxSubArr<tmp) //update the max substring array length
					maxSubArr = tmp;
				//i+=tmp;
				tmp = 0;
			}
		}

		return maxSubArr + original0s;
	}

	public static void  main(String[] args)
	{
		//int arr[] = {0, 1, 0, 0, 1, 1, 0};
		int arr[] = {0, 0, 0, 1, 0, 1};
		System.out.println(max0sCount(arr));
	}
}
