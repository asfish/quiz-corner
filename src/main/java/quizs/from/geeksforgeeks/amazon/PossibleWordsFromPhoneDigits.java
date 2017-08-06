package quizs.from.geeksforgeeks.amazon;

/**
 * Created by agebriel on 8/4/17.
 */
public class PossibleWordsFromPhoneDigits
{
	// hashTable[i] stores all characters that correspond to digit i in phone
	private static final char[][] hashTable= {{}, {}, {'a','b', 'c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
		{'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};

	// A recursive function to print all possible words that can be obtained
// by input number[] of size n.  The output words are one by one stored
// in output[]
	private static void  printWordsUtil(int number[], int curr_digit, char output[], int n)
	{
		// Base case, if current output word is prepared
		int i;
		if (curr_digit == n)
		{
			for(int k=0; k<output.length;k++)
				System.out.printf("%s", output[k]);
			System.out.println();
			return ;
		}

		// Try all 3 possible characters for current digit in number[]
		// and recur for remaining digits
		for (i=0; i<hashTable[number[curr_digit]].length; i++)
		{
			output[curr_digit] = hashTable[number[curr_digit]][i];
			printWordsUtil(number, curr_digit+1, output, n);
			if (number[curr_digit] == 0 || number[curr_digit] == 1)
				return;
		}
	}

	// A wrapper over printWordsUtil().  It creates an output array and
// calls printWordsUtil()
	private static void printWords(int number[], int n)
	{
		char[] result = new char[n+1];
		result[n] ='\0';
		printWordsUtil(number, 0, result, n);
	}

	//Driver program
	public static void main(String[] args)
	{
		int number[] = {2, 3, 4};
		int n = number.length;
		printWords(number, n);
	}
}
