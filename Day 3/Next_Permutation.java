//Find the next permutation for the given array
/*
Question :
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:

Input: nums = [1]
Output: [1]
*/
//Solution in JAVA

import java.util.*;
public class NextPermutation
{
    public static void swap(int[] num, int i,int j)
    {
        int temp =num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public static void reverse(int[] num, int l,int h)
    {
        if(l<= h)
        {
            swap(num,l,h);
            reverse(num,++l,--h);           
        }        
    }
    
    public static void nextPermutation(int[] nums) {
        
        int i , j ;
        //Traverse from end
        for(i=nums.length-2;i>=0;i--)
        {
            //Find the index where nums[i] < nums[i+1]
            if(nums[i] < nums[i+1])
            {
                break;
            }
        }
        
        if(i>=0)
        {
            for(j=nums.length-1;j>=0;j--)
            {
                if(nums[j] > nums[i])
                {
                    swap(nums,i,j);
                    break;
                }
            }
        }
        
        reverse(nums,i+1,nums.length-1);
    }
    
	public static void main(String[] args) {
	    int[] nums = new int[]{5,4,7,5,3,2};
		nextPermutation(nums);
        // Print Array           
        for(int p=0;p<nums.length;p++)
        {
            System.out.print(nums[p]+" ");
        }
	}
}

