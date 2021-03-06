/*
Question :
Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element.

Example 1:

Input :
t = 1 // No: of test cases
n= 6
arr = {1, 1, 2, 2, 2, 1}

Output :
5

Explanation :
arr[] = {1, 1, 2, 2, 2, 1}
Max Distance: 5
Distance for 1 is: 5-0 = 5
Distance for 2 is : 4-2 = 2
Max Distance 5

Example 2:

Input :
t=1 // No: of Test cases
n = 12
arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}

Output :
10

Explanation :
arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Max Distance 10
maximum distance for 2 is 11-1 = 10
maximum distance for 1 is 4-2 = 2
maximum distance for 4 is 10-5 = 5


Solution in JAVA :
*/

import java.util.Scanner;
import java.util.*;

class Max_Dis_Between_Same_Element
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
        
      //Create object of MaxDistance class
			MaxDistance maxDistance = new MaxDistance();
			
      System.out.println(maxDistance.maxDistance(arr,n));
		
		t--;
		}
	}
}

class MaxDistance
{
    int maxDistance(int arr[], int n)
    {
      // Create HashMap with key as element and value as index of it's first occurence.
    	HashMap<Integer,Integer> map = new HashMap<>();
    	//Array to store the distance of the element's highest index to lowest index for that particular element
    	int[] dist = new int[n];
    	for(int index=0;index<n;index++)
    	{
    	    //if the element comes for the first time, store the element & it's index in hashmap.
    	    //Assign dist[index] = 0 as the element was first occurred and it is the lower index.
    	    if(!map.containsKey(arr[index]))
    	    {
    	        map.put( arr[index],index );
    	        dist[index] = 0;
    	    }
    	    // if the element occurs more than 1 time, store the distance array with difference of current index & it's lowest index.
    	    else
    	    {
    	        dist[index] = index - map.get( arr[index] );
    	    }
    	}
    	int maxDistance = 0;
    	for(int i=0;i<n;i++)
    	{
    	    if(maxDistance < dist[i])
    	    {
    	        maxDistance = dist[i];
    	    }
    	}
    	return maxDistance;
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(N)
*/
