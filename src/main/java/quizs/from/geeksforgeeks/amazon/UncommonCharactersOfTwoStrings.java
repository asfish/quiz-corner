package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Find uncommon characters of the two strings
 * ===========================================
 * Find and print the uncommon characters of the two given strings in sorted order.
 * Here uncommon character means that either the character is present in one string
 * or it is present in other string but not in both. The strings contain only lowercase
 * characters and can contain duplicates.
 *
 * Examples:
 * --------

    Input : str1 = "characters"
    str2 = "alphabets"
    Output : b c l p r

    Input : str1 = "geeksforgeeks"
    str2 = "geeksquiz"
    Output : f i o q r u z
 *
 *
 * Naive Approach: Using two loops. For each charactrer of 1st string check whether it is
 *      present in 2nd string or not. Likewise, for each character of 2nd string check whether
 *      it is present in 1st string or not. Time Complexity O(n2) and extra would be required
 *      to handle duplicates.

 * Efficient Approach: Use hashing. Use a hash table of size 26 for all the lowercase
 *       characters.
 *       Initially, mark presence of each character as ‘0’ (denoting that the character is not
 *       present in both the strings). Traverse the 1st string and mark presence of each
 *       character of 1st string as ‘1’ (denoting 1st string) in the hash table. Now, traverse
 *       the 2nd string. For each character of 2nd string, check whether its presence in the hash
 *       table is ‘1’ or not. If it is ‘1’, then mark its presence as ‘-1’ (denoting that the
 *       character is common to both the strings), else mark its presence as ‘2’ (denoting 2nd
 *       string).
 *
 *       Time Complexity: O(m + n), where m and n are the sizes of the two strings respectively.
 *
 *
 * Created by agebriel on 7/5/17.
 */
public class UncommonCharactersOfTwoStrings
{
	// size of the hash table
	private final static int MAX_CHAR = 26;

	// function to find the uncommon characters
// of the two strings
	private static void findAndPrintUncommonChars(String str1, String str2)
	{
		// mark presence of each character as 0
		// in the hash table 'present[]'
		int[] present = new int[MAX_CHAR];
		for (int i=0; i<MAX_CHAR; i++)
			present[i] = 0;

		int l1 = str1.length();
		int l2 = str2.length();

		// for each character of str1, mark its
		// presence as 1 in 'present[]'
		for (int i=0; i<l1; i++)
			present[str1.charAt(i) - 'a'] = 1;

		// for each character of str2
		for (int i=0; i<l2; i++)
		{
			// if a character of str2 is also present
			// in str1, then mark its presence as -1
			if (present[str2.charAt(i) - 'a'] == 1
				|| present[str2.charAt(i) - 'a'] == -1)
				present[str2.charAt(i) - 'a'] = -1;

				// else mark its presence as 2
			else
				present[str2.charAt(i) - 'a'] = 2;
		}

		// print all the uncommon characters
		for (int i=0; i<MAX_CHAR; i++)
			if (present[i] == 1 || present[i] == 2 )
				System.out.print((char) (i + 'a') + " ");
		System.out.println();
	}

	// Driver program to test above
	public static void main(String[] args)
	{
		String str1 = "characters";
		String str2 = "alphabets";
		findAndPrintUncommonChars(str1, str2);
	}
}
