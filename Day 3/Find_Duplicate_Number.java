// Find the Duplicate Number with O(1) space complexity and less than O(N2) Time Complexity.
/*
Question :
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Example 3:

Input: nums = [1,1]
Output: 1

Answer in JAVA :
*/

import java.util.*;
public class FindDuplicate
{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Get length of Array
    int Length = sc.nextInt();
    //Initialize array with given length
		int[] nums = new int[Length];
    for(int i=0;i<Length;i++)
    {
      nums[i] = sc.nextInt();
    }
    //Sort the Array so that repeated elements comes one after the other
		Arrays.sort(nums);
		int repeatedNum = 0;
    //Traverse the array and find the repeated element by comparing with it's predecessor.
		for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1])
            {
                repeatedNum = nums[i];
                break;
            }
            else
                continue;
        }
		System.out.println(repeatedNum);
	}
}

Time Complexity : O(NlogN)
Space Complexity : O(1)
