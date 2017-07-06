package quizs.from.leetcode;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add
 * up to a specific target.

 * You may assume that each input would have exactly one solution, and you may not
 * use the same element twice.

 * Example:
 * -------
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
 *
 * Created by agebriel on 7/5/17.
 */
public class IndicesAdder
{
	public static int[] twoSum(int[] nums, int target) {
		if(nums.length == 0) return null;
		for(int i=0; i<nums.length; i++)
		{
			for(int j=i+1; j<nums.length; j++)
			{
				int sum = nums[i] + nums[j];
				if(sum == target)
				{
					//result = new int[]{nums[i], nums[j]};
					//System.out.println("result: [" + nums[i] + "," + nums[j] +"]");
					int[] result = new int[2];
					result[0]=i; //nums[i];
					result[1]=j; //nums[j];
					return result;
				}
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		int[] nums = {2, 7, 11, 15};
		int target = 9;

		int[] indices = twoSum(nums, target);
		System.out.println("["+indices[0] +", "+ indices[1]+"]");
	}
}
