package quizs.from.geeksforgeeks.amazon;

/**
 *
 * String containing first letter of every word in a given string with spaces
 * ==========================================================================
 * A String str is given which contains lowercase English letters and spaces. It may contain
 * multiple spaces. Get first letter of every word and return the result as a string. The result
 * should not contain any space.

 * Examples:
 * ---------

    Input : str = "geeks for geeks"
    Output : gfg

    Input : str = "happy coding"
    Output : hc
 *
 * Created by agebriel on 7/5/17.
 */
public class FirstLetterWord
{
	public static void main(String[] args)
	{
		String str = "geeks for geeks";
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String word : words)
		{
			sb.append(word.charAt(0));
		}

		System.out.println(sb.toString());
	}
}
