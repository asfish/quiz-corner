package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Shuffle a given array
 * Given an array, write a program to generate a random permutation of array elements.
 * This question is also asked as “shuffle a deck of cards” or “randomize a given array”.
 *
 *Let the given array be arr[]. A simple solution is to create an auxiliary array temp[] which is initially a copy of arr[]. Randomly select an element from temp[], copy the randomly selected element to arr[0] and remove the selected element from temp[]. Repeat the same process n times and keep copying elements to arr[1], arr[2], … . The time complexity of this solution will be O(n^2).

 * Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates random number in O(1) time.
 * The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last). Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.

 * Following is the detailed algorithm

 * To shuffle an array a of n elements (indices 0..n-1):
		 for i from n - 1 downto 1 do
		    j = random integer with 0 <= j <= i
		    exchange a[j] and a[i]
 *
 *
 * Created by agebriel on 8/5/17.
 */
public class ShuffleGivenArray
{
	// A utility function to print an array
	private static void printArray (int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.printf("%d ", arr[i]);
		System.out.printf("\n");
	}

	// A function to generate a random permutation of arr[]
	private static void randomize ( int arr[], int n )
	{
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--)
		{
			// Pick a random index from 0 to i
			int j = (int )(Math.random() * i + 1);

			// Swap arr[i] with the element at random index
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static void main(String[] args)
	{
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int n = arr.length;
		randomize (arr, n);
		printArray(arr, n);

	}
}
