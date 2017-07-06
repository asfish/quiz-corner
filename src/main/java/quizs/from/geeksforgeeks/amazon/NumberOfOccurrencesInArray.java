package quizs.from.geeksforgeeks.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given an array of n numbers and a positive integer k. The problem is to find k numbers
 * with most occurrences, i.e., the top k numbers having the maximum frequency. If two numbers
 * have same frequency then the larger number should be given preference. The numbers should
 * be displayed in decreasing order of their frequencies. It is assumed that the array consists
 * of k numbers with most occurrences.

 Examples:
	Input : arr[] = {3, 1, 4, 4, 5, 2, 6, 1},
    k = 2
    Output : 4 1
    Frequency of 4 = 2
    Frequency of 1 = 2
    These two have the maximum frequency and
    4 is larger than 1.

    Input : arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
    k = 4
    Output : 5 11 7 10
 *
 *
 * Created by agebriel on 7/4/17.
 */
public class NumberOfOccurrencesInArray
{
	// comparison function to sort the 'freq_arr[]'
	private static boolean compare(Map.Entry<Integer, Integer> p1,
		                               Map.Entry<Integer, Integer> p2)
	{
		// if frequencies of two elements are same
		// then the larger number should come first
		if (p1.getValue() == p2.getValue())
			return p1.getKey() > p2.getKey();

		// sort on the basis of decreasing order
		// of frequencies
		return p1.getValue() > p2.getValue();
	}

	// funnction to print the k numbers with most occurrences
	private static void print_N_mostFrequentNumber(int arr[], int k)
	{
		// unordered map
		//Note: instead of HashMap user LinkedHashMap in order to preserve order of entry
		Map<Integer, Integer> um = new HashMap<Integer, Integer>()
		{
			@Override
			public Integer get(Object key)
			{
				return containsKey(key) ? super.get(key) : 0;
			}
		};

		//build the mapping
		for (int i = 0; i<arr.length; i++)
			um.put(arr[i], um.get(arr[i])+1);

		// sort the map
		List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(um.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>()
		{
			@Override
			public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2)
			{
				// if frequencies of two elements are same
				// then the larger number should come first
				if (p1.getValue() == p2.getValue())
					//return p1.getKey().compareTo(p2.getKey()); //asc
					return p2.getKey().compareTo(p1.getKey()); //desc.

				// sort on the basis of decreasing order of frequencies
				//return p1.getValue().compareTo(p2.getValue()); //asc
				return p2.getValue().compareTo(p1.getValue()); //desc
			}
		});

		//for(Map.Entry<Integer, Integer> entry : entries)
		//	System.out.println(entry.getKey()+ "-> "+ entry.getValue());

		// display the the top k numbers
		int count = 0;
		for(Map.Entry<Integer, Integer> entry:entries)
		{
			if(++count > k)
				break;
			//System.out.println(entry.getKey()+ "-> "+ entry.getValue());
			System.out.print(entry.getKey()+ " ");
		}
	}

	public static void  main(String[] args)
	{
		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
		int k = 2;
		print_N_mostFrequentNumber(arr, k);
		System.out.println();
		int arr1[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int k1 = 4;
		print_N_mostFrequentNumber(arr1, k1);

		int[] arr2 = {4,5,6,7,8,1,2,1,2,3,5,4,6,7,8,9,0,6,7};
		print_N_mostFrequentNumber(arr2, 1);
	}
}
