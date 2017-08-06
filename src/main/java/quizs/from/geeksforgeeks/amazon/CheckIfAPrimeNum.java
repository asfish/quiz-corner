package quizs.from.geeksforgeeks.amazon;

import java.util.Scanner;

/**
 *
 * Java Program to check if a number is Prime or Not. This program accepts a * number
 * from command prompt and check if it is prime or not.

 * Read more: http://www.java67.com/2014/01/how-to-check-if-given-number-is-prime.html#ixzz4owPLZwlY
 *
 * Created by agebriel on 8/5/17.
 */
public class CheckIfAPrimeNum
{
	public static void main(String args[])
	{

		int number = 11;
		System.out.println(isPrime(number));
		System.out.println(isPrimeOrNot(number));
		System.out.println(isPrimeNumber(number));

	}

	/* * Java method to check if an integer number is prime or not.
	* * @return true if number is prime, else false
	* */
	public static boolean isPrime(int number)
	{
		boolean isPrime = true;
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++)
		{
			if (number % i == 0)
			{
				// number is perfectly divisible - no prime return false; } }
				isPrime = false;
			}
		}
		return isPrime;
	}

	/* * Second version of isPrimeNumber method, with improvement like not
	* * checking for division by even number, if its not divisible by 2.
	* */
	public static boolean isPrimeNumber(int number)
	{
		if (number == 2 || number == 3)
		{
			return true;
		}
		if (number % 2 == 0)
		{
			return false;
		}
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 3; i < sqrt; i += 2)
		{
			if (number % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	/* * Third way to check if a number is prime or not.
	* */
	public static String isPrimeOrNot(int num)
	{
		if (num < 0)
		{
			return "not valid";
		}
		if (num == 0 || num == 1)
		{
			return "not prime";
		}
		if (num == 2 || num == 3)
		{
			return "prime number";
		}
		if ((num * num - 1) % 24 == 0)
		{
			return "prime";
		}
		else
		{
			return "not prime";
		}
	}

}