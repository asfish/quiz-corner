package quizs.from.geeksforgeeks.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Secret = [{"apple","apple"}, {"apple","orange", "apple"}]
 * cart = ["orange", "apple", "apple", "grape", "apple", "orange", "apple", "grape"]
 * Created by agebriel on 8/6/17.
 */
public class GroceryPurchaseSecretPrize
{
	public static void main(String[] args)
	{
		List<String> s1 = Arrays.asList("apple","apple");
		List<String> s2 = Arrays.asList("apple","orange", "apple");
		List<List<String>> secret = new ArrayList<List<String>>();
		secret.add(s1);
		secret.add(s2);
		List<String> cart = Arrays.asList("orange", "apple", "apple", "grape", "apple", "orange", "apple", "grape");

		System.out.println(getPrize(cart, secret));
	}

	private static int getPrize(List<String> cart, List<List<String>> secret)
	{
		//boolean v1 = Collections.indexOfSubList(cart, secret.get(0)) != -1;
		//boolean v2 = Collections.indexOfSubList(cart, secret.get(1)) != -1;

		boolean v1 = isSubList(secret.get(0), cart);
		boolean v2 = isSubList(secret.get(1), cart);

		return v1 && v2 ? 1 : 0;
	}

	private static boolean isSubList(List<String> s1, List<String> s2)
	{
		boolean found = false;
		for(int i=0; i<s2.size(); i++)
		{
			if((i+s1.size() > s2.size()-1) || found) break;

			for(int j=0; j<s1.size(); j++)
			{
				if(s1.get(j).equals(s2.get(i+j)))
					found = true;
				else
				{
					found = false;
					break;
				}
			}
		}
		return found;
	}
}
