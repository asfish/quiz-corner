package quizs.from.leetcode;

import java.util.Stack;

/**
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest
 * valid (well-formed) parentheses substring.

 * For "(()", the longest valid parentheses substring is "()", which has length = 2.

 * Another example is ")()())", where the longest valid parentheses substring is "()()",
 * which has length = 4.
 *
 * Created by agebriel on 7/5/17.
 */
public class WellFormedParenthesis
{
	public static void main(String[] args)
	{
		String s2 = "(()";
		//String s2 = ")()())";

		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<s2.length(); i++)
		{
			if(s2.charAt(i) == '(')
			{
				stack.push(s2.charAt(i));
			}
			if(s2.charAt(i)==')')
			{
				if(stack.isEmpty())
				{
					continue;
				}
				sb.append(stack.pop()).append(s2.charAt(i));
			}
		}

		System.out.println(sb.toString());
		System.out.println(sb.toString().length());
	}
}
