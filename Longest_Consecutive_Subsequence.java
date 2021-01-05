Question:

Given an array A of integers. Find the length of the longest sub-sequence such that elements in the sub-sequence are consecutive integers,
the consecutive numbers can be in any order.

Example 1:

Input:
1 //No: of Test cases
7 // Length of array
1 9 3 10 4 20 2 // Array elements
Output:
4 // Length of longest Consecutive Subsequence.
Explanation:
Longest consecutive subsequence is 1, 2, 3, 4 of length 4.

Example 2:

Input:
11
36 41 56 35 44 33 34 92 43 32 42
Output:
5

Solution in JAVA :

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class FindLongestSubsequence
{
    // Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
		    // Making object of GfG	
			GfG g = new GfG();
			
			System.out.println(g.findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}


class Longest_Consecutive_Subsequence
{
    // Function to find Longest Consecutive Subsequence
    int findLongestConseqSubseq(int a[], int n)
    { 
      // Create a HashSet
	    HashSet<Integer> elements = new HashSet<>();
      
	    //Store all the elements in the HashSet. Duplicate elements will be added only once.
      for(int index=0;index<n;index++)
	    {
	        elements.add(a[index]);
	    }
      
	    int maxSubsequence = 0;
      
	    //Traverse to each element in the array
      for(int index=0;index<n;index++)
	    {	        
          //Check the current element is at the starting position of the subsequence by checking the previous integer is present in HashSet or not.
          // Example : if a[index] = 20, check for a[index]-1 i.e.,20-1 = 19 in the HashSet. If 19 is not present, the a[index] = 20 is the starting position of the subsequence.
          
	        if(!elements.contains(a[index]-1))
	        {
	            int j = a[index];
              //Increment the Count till the next element is not found.
	            while(elements.contains(j))
	            {
	                j++;
	            }
              // Compare with Maximum length of subsequence.
	            if(maxSubsequence < (j-a[index]))
	                maxSubsequence = j-a[index];
	        }
	        
	    }
      //Return the Maximum subsequence length.
	    return maxSubsequence;
    }
}

Time Complexity : O(N)
Space Complexity : O(N)
