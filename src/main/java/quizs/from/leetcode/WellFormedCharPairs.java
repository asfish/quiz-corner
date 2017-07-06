package quizs.from.leetcode;

import java.util.Stack;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by agebriel on 7/5/17.
 */
public class WellFormedCharPairs
{
	private static boolean isValid(String s) {
		int length=s.length();
		char [] array=s.toCharArray();
		if(length==0) return true;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0; i<length; i++)
		{
			if(array[i]=='(' || array[i]=='{' || array[i]=='[' )
			{
				stack.push(array[i]);
			}
			if(array[i]==')' ||array[i]=='}' ||array[i]==']')
			{
				if(stack.isEmpty()) return false;
				char temp=stack.pop();
				if((temp=='(' && array[i]==')' ) || (temp=='{' && array[i]=='}' ) ||(temp=='[' && array[i]==']' )  )
				{
					continue;
				}else
				{
					return false;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}

	public static void main(String[] args)
	{
		String s1 = "()[]{}";
		String s2 = "([)]";

		System.out.println(isValid(s1));
		System.out.println(isValid(s2));

	}
}
