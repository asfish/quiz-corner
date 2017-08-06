package quizs.from.geeksforgeeks.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Count words that appear exactly two times in an array of words
 * Given an array of n words. Some words are repeated twice, we need count such words.
 * Examples:

	 Input : s[] = {"hate", "love", "peace", "love",
	 "peace", "hate", "love", "peace",
	 "love", "peace"};
	 Output : 1
	 There is only one word "hate" that appears twice

	 Input : s[] = {"Om", "Om", "Shankar", "Tripathi",
	 "Tom", "Jerry", "Jerry"};
	 Output : 2
	 There are two words "Om" and "Jerry" that appear
	 twice.
 *
 * Solution:
 *      1. Traverse the given array, store counts of words in a hash table
 *      2. Traverse hash table and count all words with count 2.
 *
 * Created by agebriel on 8/5/17.
 */
public class WordsThatAppearExactly2Times
{
	private static int countWords(String str[])
	{
		Map<String, Integer> words = new HashMap();
		for(int i=0; i<str.length; i++){
			if(!words.containsKey(str[i]))
				words.put(str[i], 1);
			else
				words.put(str[i], words.get(str[i]) +1);
		}

		int count = 0;
		for(int val : words.values())
		{
			if(val == 2)
				count++;
		}

		return count;
	}

	public static void main(String[] args)
	{
		String s[] = { "hate", "love", "peace", "love",
			"peace", "hate", "love", "peace",
			"love", "peace" };

		System.out.println(countWords(s));

		String s2[] = {"Om", "Om", "Shankar", "Tripathi",
		"Tom", "Jerry", "Jerry"};

		System.out.println(countWords(s2));
	}
}
