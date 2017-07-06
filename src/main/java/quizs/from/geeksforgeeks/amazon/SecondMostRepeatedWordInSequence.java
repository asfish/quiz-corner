package quizs.from.geeksforgeeks.amazon;

/*
Second most repeated word in a sequence
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.(Considering no two words are the second most repeated, there will be always a single word).

Examples:

Input : {"aaa", "bbb", "ccc", "bbb",
         "aaa", "aaa"}
Output : bbb

Input : {"geeks", "for", "geeks", "for",
          "geeks", "aaa"}
Output : for

Solution:
	1. Store all the words in a map with their occurrence with word as key and its
		occurrence as value.
	2. Find the second largest value in the map.
	3. Traverse the map again and return the word with occurrence value equals to
		second max value.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by agebriel on 7/4/17.
 */
public class SecondMostRepeatedWordInSequence
{
	// Method to find the word
	static String secMostRepeated(List<String> seq)
	{
		// Store all the words with its occurrence
		HashMap<String, Integer> occ = new HashMap<String,Integer>(seq.size()){
			@Override
			public Integer get(Object key) {
				return containsKey(key) ? super.get(key) : 0;
			}
		};

		for (int i = 0; i < seq.size(); i++)
			occ.put(seq.get(i), occ.get(seq.get(i)) + 1);
		/*{
			if(occ.containsKey(seq.get(i)))
				occ.put(seq.get(i), occ.get(seq.get(i)) + 1);
			else
				occ.put(seq.get(i), 1);
		}*/

		for(String s : occ.keySet())
			System.out.println(s + " -> " + occ.get(s));

		//System.out.println("min: " + Integer.MIN_VALUE + ", max: " + Integer.MAX_VALUE);
		// find the secondMaxVal largest occurrence
		//int firstMaxVal = Integer.MIN_VALUE, secondMaxVal = Integer.MIN_VALUE;
		int firstMaxVal =0 , secondMaxVal =0;

		Iterator<Map.Entry<String, Integer>> itr = occ.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry<String, Integer> entry = itr.next();
			int v = entry.getValue();

			if( firstMaxVal < v ) {
				secondMaxVal = firstMaxVal;
				firstMaxVal = v;
			}
			else if (v > secondMaxVal && v != firstMaxVal)
				secondMaxVal = v;
		}

		// Return string with occurrence equals
		// to secondMaxVal
		itr = occ.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry<String, Integer> entry = itr.next();
			int v = entry.getValue();
			if (v == secondMaxVal)
				return entry.getKey();
		}

		return null;
	}

	public static void main(String[] args)
	{
		String arr[] = { "ccc", "aaa", "ccc",
			"ddd", "aaa", "aaa" };
		List<String> seq =  Arrays.asList(arr);

		System.out.println(secMostRepeated(seq));
	}
}
