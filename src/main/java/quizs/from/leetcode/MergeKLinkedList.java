package quizs.from.leetcode;

import java.util.LinkedList;
import java.util.Arrays;

/**
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 *
 * Created by agebriel on 7/5/17.
 */
public class MergeKLinkedList
{
	public static void main(String[] args)
	{
		LinkedList<Integer> ll1 = new LinkedList(Arrays.asList(2,4,7,8,10,19,21,24));
		LinkedList<Integer> ll2 = new LinkedList(Arrays.asList(3,5,9,12,15,17));

		int i=0,j=0, loop = ll1.size() == ll2.size() ? ll1.size() + ll2.size()
			: ll1.size() < ll2.size() ? ll1.size() *2 : ll2.size() *2;
		System.out.println("loop: " + loop);
		LinkedList<Integer> m = new LinkedList();
		while(m.size() < loop)
		{
			if(ll1.get(i) < ll2.get(j))
			{
				m.add(ll1.get(i));
				i++;
				if(i == ll1.size()) break;
			}
			else
			{
				m.add(ll2.get(j));
				j++;
				if(j == ll2.size()) break;
			}
		}
		if(ll1.size() > i)
		{
			m.addAll(ll1.subList(i, ll1.size()));
		}
		if(ll2.size() > j)
		{
			m.addAll(ll2.subList(j, ll2.size()));
		}

		System.out.println(m);

	}

}
