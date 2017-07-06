package quizs.from.geeksforgeeks.amazon;

/**
 * Searching for Patterns | Set 3 (Rabin-Karp Algorithm)
 * =====================================================
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[])
 * that prints all occurrences of pat[] in txt[]. You may assume that n > m.

 * Examples:

        Input:  txt[] = "THIS IS A TEST TEXT"
                pat[] = "TEST"
        Output: Pattern found at index 10

        Input:  txt[] =  "AABAACAADAABAABA"
                pat[] =  "AABA"

        Output: Pattern found at index 0
                Pattern found at index 9
                Pattern found at index 12

 *
 * The Naive String Matching algorithm slides the pattern one by one. After each slide, it one
 * by one checks characters at the current shift and if all characters match then prints the match.
 *
 * Like the Naive Algorithm, Rabin-Karp algorithm also slides the pattern one by one. But unlike
 * the Naive algorithm, Rabin Karp algorithm matches the hash value of the pattern with the hash
 * value of current substring of text, and if the hash values match then only it starts matching
 * individual characters. So Rabin Karp algorithm needs to calculate hash values for following strings.
        1) Pattern itself.
        2) All the substrings of text of length m.
 *
 *
 * Created by agebriel on 7/6/17.
 */
public class PatternSearch
{
	private final static int MAX = 256;

	private static void search(String pattern, String txt)
	{
		int[] p = new int[MAX], t = new int[MAX];
		int pl = pattern.length(), tl = txt.length();

		for(int i=0; i<pl; i++)
		{
			(p[pattern.charAt(i)])++;
			(t[txt.charAt(i)])++;
		}

		for(int i=pl; i<tl; i++){
			if(compare(p,t))
				System.out.println("Pattern found at index: " + (i-pl));

			(t[txt.charAt(i)])++;
			(t[txt.charAt(i-pl)])--;
		}
	}

	private static boolean compare(int[] p, int[] t)
	{
		for(int i=0; i<MAX; i++){
			if(p[i] != t[i])
				return false;
		}
		return true;
	}

	public static void main(String [] args){
		String txt = "THIS IS A TEST TEXT", pat = "TEST";
		String txt1 =  "AABAACAADAABAABA", pat1 =  "AABA";

		//System.out.println(txt1.matches(pat1));

		search(pat, txt);
		search(pat1, txt1);
	}
}
