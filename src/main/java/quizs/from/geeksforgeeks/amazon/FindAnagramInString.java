package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[])
 * that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume
 * that n > m.
 * Expected time complexity is O(n)

 * Examples:

    1) Input:  txt = "BACDGABCDA"  pat = "ABCD"
    Output:
        Found at Index 0
        Found at Index 5
        Found at Index 6

    2) Input: txt =  "AAABABAA" pat = "AABA"
    Output:
        Found at Index 0
        Found at Index 1
        Found at Index 4
 *
 * Find anagrams of a string in another string
 * ===========================================
 *  Sliding Histogram Approach – O(n) time O(1) space
 *      Notice that when we find an anagram starting from i we might potentially find another
 *      starting from i+1 if character count distribution remains same. For example,
 *      text = “abaab” and pattern = “aba”. We can see both of the strings have same character
 *      count distribution i.e. histogram ([a=2,b=1,c=0,..]) for first m characters, where
 *      m=length of pattern. If we remove first character ‘a’ and add 4th character ‘a’ then
 *      histogram remains same ([a=2,b=1,c=0,..]).

 *      So, we can create a fixed length (=size of the pattern) sliding window histogram for
 *      characters in text string and check if the window equals to the pattern histogram at
 *      each position of the text. We keep sliding the window to right one position and check
 *      if the window equals to patten histogram. This is linear time algorithm if the alphabet
 *      size of the strings is finite (for example 256 character set). Below is the implementation
 *      of the idea in O(n) time and O(1) space.
 *
 * Created by agebriel on 7/6/17.
 */
public class FindAnagramInString
{
	private final static int MAX = 256;

	private static boolean compare(char arr1[], char arr2[])
	{
		for (int i=0; i<MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}
	// This function search for all permutations of pat[] in txt[]
	private static void search(String pat, String txt)
	{
		int M = pat.length(), N = txt.length(); //, i=0;

		// countP[]:  Store count of all characters of pattern
		// countTW[]: Store count of current window of text
		char[] countP = new char[MAX], countTW = new char[MAX];
		for (int i = 0; i < M; i++)
		{
			(countP[pat.charAt(i)])++;
			(countTW[txt.charAt(i)])++;
		}

		// Traverse through remaining characters of pattern
		for (int i = M; i < N; i++)
		{
			// Compare counts of current window of text with
			// counts of pattern[]
			if (compare(countP, countTW))
				System.out.println("Found at Index " +(i - M));

			// Add current character to current window
			(countTW[txt.charAt(i)])++;

			// Remove the first character of previous window
			countTW[txt.charAt(i-M)]--;
		}

		// Check for the last window in text
		if (compare(countP, countTW))
			System.out.println("Found at Index " +(N - M));
	}


	public static void main(String[] args)
	{
		//String str = "abateatas", pattern = "tea";
		String str = "BACDGABCDA" , pattern = "ABCD";
		//String str = "AAABABAA",  pattern = "AABA";

		search(pattern, str);
		printIndicesOfAnagram(str, pattern);

	}

	//Alternative way
	private static void printIndicesOfAnagram(String str, String pattern)
	{
		int index = 0;
		int pl = pattern.length();
		int sl = str.length();
		final int pValue = convertToInt(pattern);

		while((index + pl)<=sl)
		{
			String win = str.substring(index, index + pl);
			if(pValue == convertToInt(win))
				System.out.println(index);
			index++;
		}
	}

	private static int convertToInt(String str)
	{
		int sum = 0;
		for(int i=0; i<str.length(); i++)
			 sum += Character.getNumericValue(str.charAt(i));

		return sum;
	}


}
