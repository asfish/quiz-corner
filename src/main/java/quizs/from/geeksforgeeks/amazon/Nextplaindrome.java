package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Given a number, find the next smallest palindrome
 * =================================================
 * Given a number, find the next smallest palindrome larger than this number.
 * For example, if the input number is “2 3 5 4 5”, the output should be “2 3 6 3 2”.
 * And if the input number is “9 9 9”, the output should be “1 0 0 1”.

 The input is assumed to be an array. Every entry in array represents a digit in input number. Let the array be ‘num[]’ and size of array be ‘n’

 There can be three different types of inputs that need to be handled separately.
 1) The input number is palindrome and has all 9s. For example “9 9 9”. Output should be “1 0 0 1”
 2) The input number is not palindrome. For example “1 2 3 4”. Output should be “1 3 3 1”
 3) The input number is palindrome and doesn’t have all 9s. For example “1 2 2 1”. Output should be “1 3 3 1”.
 *
 *
 * Created by agebriel on 7/5/17.
 */
public class Nextplaindrome
{
	// Returns next palindrome of a given
	// number num[]. This function is for
	// input type 2 and 3
	static void generateNextPalindromeUtil(int num[], int n)
	{
		int mid = n / 2;

		// end of left side is always 'mid -1'
		int i = mid - 1;

		// Begining of right side depends
		// if n is odd or even
		int j = (n % 2 == 0) ? mid : mid + 1;

		// A bool variable to check if copy of left
		// side to right
		// is sufficient or not
		boolean leftsmaller = false;

		// Initially, ignore the middle same digits
		while (i >= 0 && num[i] == num[j])
		{
			i--;
			j++;
		}

		// Find if the middle digit(s) need to
		// be incremented or not (or copying left
		// side is not sufficient)
		if (i < 0 || num[i] < num[j])
		{
			leftsmaller = true;
		}

		// Copy the mirror of left to tight
		while (i >= 0)
		{
			num[j++] = num[i--];
		}

		// Handle the case where middle digit(s)
		// must be incremented. This part of code
		// is for CASE 1 and CASE 2.2
		if (leftsmaller)
		{
			int carry = 1;

			// If there are odd digits, then increment
			// the middle digit and store the carry
			if (n % 2 == 1) {
				num[mid] += 1;
				carry = num[mid] / 10;
				num[mid] %= 10;
			}
			i = mid - 1;
			j = (n % 2 == 0 ? mid : mid + 1);

			// Add 1 to the rightmost digit of the left
			// side, propagate the carry towards MSB digit
			// and simultaneously copying mirror of the
			// left side to the right side.
			while (i >= 0)
			{
				num[i] = num[i] + carry;
				carry = num[i] / 10;
				num[i] %= 10;
				num[j] = num[i];// copy mirror to right
				i--;
				j++;
			}

		}
	}

	// The function that prints next palindrome
	// of a given number num[] with n digits.
	static void generateNextPalindrome(int num[], int n)
	{
		System.out.println("Next Palindrome is:");

		// Input type 1: All the digits are 9,
		// simply o/p 1 followed by n-1 0's
		// followed by 1.
		if (isAll9(num, n)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++)
				System.out.print("0");
			System.out.println("1");

		}

		// Input type 2 and 3
		else {
			generateNextPalindromeUtil(num, n);
			printarray(num);
		}
	}

	// A utility function to check if num has all 9s
	static boolean isAll9(int num[], int n) {
		for (int i = 0; i < n; i++)
			if (num[i] != 9)
				return false;
		return true;
	}

	/* Utility that prints out an array on a line */
	static void printarray(int num[]) {
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]);
		System.out.println();
	}

	public static void main(String[] args)
	{
		int num[] = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
		generateNextPalindrome(num, num.length);
	}
}
