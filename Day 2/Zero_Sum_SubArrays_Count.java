// Display the count of the Sub Arrays whose sum = 0

Question :
You are given an array A[] of size N. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
T = 1 //No: of test cases
N = 6
A[] = {0,0,5,5,0,0}

Output: 6

Explanation: 
The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
T = 1 //No: of test cases
N = 10
A[] = {6,-1,-3,4,-2,2,4,6,-12,-7}

Output: 4

Explanation: 
The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

Solution in JAVA :

import java.io.*;
import java.util.*;
class ZeroSumSubArray {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    int arr[]=new int[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }

		    System.out.println(findSubarray(arr,n));
		}
		
	}

public static int findSubarray(int[] arr ,int n) 
{    
    int sum = 0, count = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<n;i++)
    {
        sum += arr[i];
        //If sum is zero increment Count
        if(sum == 0)
            count++;
        //If the sum at index i occurs before then the sub array with sum=0 exists.
        if(map.containsKey(sum))
        {
            //Increment count with the number of times the similar sum has occurred earlier.
            count += map.get(sum);
        }
        //Get the number of occurrences of the similar sum which occurred earlier. If the sum has not occurred earlier, the Default value is 0.
        Integer temp = map.getOrDefault(sum,0);
        //Increment the occurences of the sum by 1.
        map.put(sum, temp+1);
    }
    return count;
}

Time Complexity : O(N)
Space Complexity : O(N)
