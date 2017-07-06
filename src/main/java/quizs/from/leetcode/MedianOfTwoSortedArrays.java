package quizs.from.leetcode;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 * Example 1:
 * ---------
        nums1 = [1, 3]
        nums2 = [2]

        The median is 2.0

 * Example 2:
 * ---------
        nums1 = [1, 2]
        nums2 = [3, 4]

        The median is (2 + 3)/2 = 2.5
 *
 *
 *
 * Created by agebriel on 7/5/17.
 */
public class MedianOfTwoSortedArrays
{
	public static void main(String[] args)
	{
		//1. equal length arrays
		//int ar1[] = {1, 12, 15, 26, 38};
		//int ar2[] = {2, 13, 17, 30, 45};
		//1,2,12,13,15,17,26,30,38,45

		//2. length of 1st array greater than 2nd array
		//int ar1[] = {1, 12, 15, 26, 38, 50, 54};
		//int ar2[] = {2, 13, 17, 30, 45};
		//1,2,12,13,15,17,26,30,38,45,50,54

		//3. length of 2nd array greater than 1st array
		//int ar1[] = {1, 12, 15, 26, 38};
		//int ar2[] = {2, 13, 17, 30, 45, 50, 54, 57};
		//1,2,12,13,15,17,26,30,38,45,50,54,57

		//4. All elements in ar1 are less than that of ar2, and ar1.len == ar2.len
		//int ar1[] = {1, 12, 15, 26, 38};
		//int ar2[] = {45, 50, 54, 57, 60};
		//1,12,15,26,38,45,50,54,57,60

		//5. All elements in ar2 are less than that of ar1, and ar1.len == ar2.len
		//int ar2[] = {1, 12, 15, 26, 38};
		//int ar1[] = {45, 50, 54, 57, 60};
		//1,12,15,26,38,45,50,54,57,60

		//6. All elements in ar1 are less than that of ar2, and ar1.len > ar2.len
		//int ar1[] = {1, 12, 15, 26, 38, 40, 42, 44};
		//int ar2[] = {45, 50, 54, 57, 60};
		//1,12,15,26,38,40,42,44,45,50,54,57,60

		//7. All elements in ar2 are less than that of ar1, and ar1.len > ar2.len
		//int ar2[] = {1, 12, 15, 26, 38, 40, 42, 44};
		//int ar1[] = {45, 50, 54, 57, 60};
		//1,12,15,26,38,40,42,44,45,50,54,57,60

		//8. All elements in ar1 are less than that of ar2, and ar1.len < ar2.len
		//int ar1[] = {1, 12, 15, 26, 38, 40, 42, 44};
		//int ar2[] = {45, 50, 54, 57, 60, 63, 65, 68, 70, 73, 76};
		//1,12,15,26,38,40,42,44,45,50,54,57,60,63,65,68,70,73,76

		//9. All elements in ar2 are less than that of ar1, and ar1.len > ar2.len
		int ar2[] = {1, 12, 15, 26, 38, 40, 42, 44};
		int ar1[] = {45, 50, 54, 57, 60, 63, 65, 68, 70, 73};
		//1,12,15,26,38,40,42,44,45,50,54,57,60,63,65,68,70,73

		int c=0, i=0, j=0, m1=0,m2=0, len = (ar1.length + ar2.length)/2;

		while(c <= len)
		{
			//if all elements of ar1 less than that of ar2
			if(ar1[ar1.length-1] < ar2[0])
			{
				//if the length of both array is equal
				if(ar1.length == len)
				{
					m1 = ar1[ar1.length - 1];
					m2 = ar2[0];
				}

				//if the length of ar1 is greater than len
				else if(ar1.length > len)
				{
					m1 = ar1[len-1];
					m2 = ar1[len];
				}
				//if the length of ar2 is greater than len
				else
				{
					m1 = ar2[len - (ar1.length +1)];
					m2 = ar2[len - ar1.length];
				}

				break;
			}

			//if all elements of ar2 less than that of ar1
			if(ar2[ar2.length-1] < ar1[0])
			{
				//if the length of both array is equal
				if(ar1.length == len)
				{
					m1=ar1[0];
					m2=ar2[ar2.length-1];
				}

				//if the length of ar1 is greater than len
				else if(ar2.length > len)
				{
					m1 = ar2[len-1];
					m2 = ar2[len];
				}
				//if the length of ar2 is greater than len
				else
				{
					m1 = ar1[len - (ar2.length +1)];
					m2 = ar1[len - ar2.length];
				}

				break;
			}

			if(ar1[i] < ar2[j])
			{
				m1 = ar1[i];
				i++;
				c++;
			}
			else
			{
				m2 = ar2[j];
				j++;
				c++;
			}
		}

		int median = (ar1.length + ar2.length)%2 == 0 ? (m1 + m2)/2 : m1 > m2 ? m1 : m2 ;
		System.out.println("The median is: " + median);
	}
}
