package quizs.from.geeksforgeeks.amazon;

/**
 *
 * http://www.geeksforgeeks.org/number-buildings-facing-sun/
 *
 * Given an array representing heights of buildings.
 * Examples:
        Input : arr[] = {7, 4, 8, 2, 9}
        Output: 3
        Explanation: As 7 is the first element, it can see the sunset.
                       4 can't see the sunset as 7 is hiding it.
                       8 can see.
                       2 can't see the sunset.
                       9 also can see the sunset.

        Input : arr[] = {2, 3, 4, 5}
        Output : 4
 *
 * Created by agebriel on 7/6/17.
 */
public class NumberOfBuildingsFacingTheSun
{
	public static void main(String[] args)
	{
		int arr[] = {7, 4, 8, 2, 9};
		//int arr[] = {2, 3, 4, 5};
		int canSee = 1;

		for(int i=0; i<arr.length; i++)
		{
			if(i-1 >= 0 && arr[i]>arr[i-1])
				canSee++;
		}
		System.out.println(canSee);
	}
}
