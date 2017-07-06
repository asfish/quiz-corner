package quizs.from.geeksforgeeks.amazon;



/**
 * You are given N distinct numbers. You are tasked with finding the number of
 * groups of 2 or 3 that can be formed whose sum is divisible by three.

 Examples:

 Input  : 1 5 7 2 9 14
 Output : 13
 The groups of two that can be
 formed are:
 (1, 5)
 (5, 7)
 (1, 2)
 (2, 7)
 (1, 14)
 (7, 14)
 The groups of three are:
 (1, 5, 9)
 (5, 7, 9)
 (1, 2, 9)
 (2, 7, 9)
 (2, 5, 14)
 (1, 9, 14)
 (7, 9, 14)

 Input  : 3 6 9 12
 Output : 10
 All groups of 2 and 3 are valid.
 *
 *
 *
 *Naive Approach : For each number, we can add it up with every other number
 * and see if the sum is divisible by 3. We then store these sums, so that we
 * can add each number again to check for groups of three.
 Time Complexity: O(N^2) for groups of 2, O(N^3) for groups of 3
 Auxiliary Space: O(N^2)

 Optimum Approach
 If we carefully look at every number, we realize that 3 options exist:

 The number is divisible by 3
 The number leaves a remainder of 1, when divided by 3
 The number leaves a remainder of 2, when divided by 3
 Now, for groups of two being divisible by 3, either both number have to belong
 to category 1 (both are divisible by 3), or one number should leave a remainder 1,
 and the other a remainder 2. This way the remainders add up to 3, making the sum
 divisible by 3.
 To form a group of three, either all three numbers should give the same remainder,
 or one should give remainder 0, another should give 1, and the last should give 2.

 In this way, we do not care about the numbers themselves, but their respective
 remainders. Thus by grouping them into three categories, we can find the total
 possible groups using a simple formula.

 Let C1 be number of elements divisible by 3.
 Let C2 be number of elements leaving remainder 1.
 Let C3 be number of elements leaving remainder 2.

 Answer =
 C2 * C3 + C1 * (C1 - 1) / 2    --> Groups of 2
 + C1 * (C1 - 1) * (C1 - 2) / 6
 + C2 * (C2 - 1) * (C2 - 2) / 6
 + C3 * (C3 - 1) * (C3 - 2) / 6 --> Groups of 3
 with elements of same remainder
 + C1 * C2 * C3 --> Groups of three with all
 distinct remainders
 *
 *
 *
 * Created by agebriel on 7/4/17.
 */
public class NumberOfGroupsOfSizes2OrThreeDivisibleBy3
{
	private static int numOfCombinations(int arr[], int N)
	{
		// Initialize groups to 0
		int C[] = {0, 0, 0};

		// Increment group with specified remainder
		for (int i = 0; i < N; ++i)
		{
			System.out.print(C[arr[i] % 3] + "...");
			System.out.print(++C[arr[i] % 3] + "     ");
			//++C[arr[i] % 3];
		}

		System.out.println();
		for(int i=0; i<C.length; i++)
			System.out.print(C[i] + " ");
		System.out.println();

		// Return groups using the formula
		return C[1] * C[2] + C[0] * (C[0] - 1) / 2 +
			C[0] * (C[0] - 1) * (C[0] - 2) / 6 +
			C[1] * (C[1] - 1) * (C[1] - 2) / 6 +
			C[2] * (C[2] - 1) * (C[2] - 2) / 6 +
			C[0] * C[1] * C[2];
	}

	public static void main(String[] args)
	{
		int arr1[] = {1, 5, 7, 2, 9, 14};
		System.out.println(numOfCombinations(arr1, 6));
		//int arr2[] = {3, 6, 9, 12};
		//System.out.println(numOfCombinations(arr2, 4));
	}
}
