package quizs.from.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given a string, s, and a list of words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 * For example, given:
    s: "barfoothefoobarman"
    words: ["foo", "bar"]

 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * Created by agebriel on 7/5/17.
 */
public class ConcatOfWordsInString
{
	public static void main(String[] args)
	{
		String s = "barfoothefoobarman";
		String [] words = {"foo", "bar"};

		String[] cWords = {words[0]+words[1],words[1]+words[0]};
		List<Integer> indices = new ArrayList();

		for(int i=0; i<words.length; i++)
		{
			if(s.indexOf(cWords[i]) != -1)
			{
				indices.add(s.indexOf(cWords[i]));
				//indices.add(s.lastIndexOf(words[i]));
			}
		}

		Integer[] index = new Integer[indices.size()];
		index = indices.toArray(index);

		System.out.print("[ ");
		for(int i=0;i<index.length; i++)
		{
			System.out.print(index[i] + " ");
		}
		System.out.print("]");
	}

}
