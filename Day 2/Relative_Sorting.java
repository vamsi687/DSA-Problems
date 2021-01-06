//Sort the First Array based on the Second Array

Question : 
Given two integer arrays. Sort the first array such that all the relative positions of the elements in the first array are same as the elements in the second array.

See example for better understanding.
Example 1:

Input:
T = 1
N = 11, M = 4
A1[] = {2,1,2,5,7,1,9,3,6,8,8}
A2[] = {2,1,8,3}

Output: 2 2 1 1 8 8 3 5 6 7 9

Explanation: 
Array elements of A1[] are
sorted according to A2[]. So 2 comes first
then 1 comes, then comes 8, then finally 3
comes, now we append remaining elements in
sorted order.

Example 2:

Input:
T = 1
N = 11, M = 4
A1[] = {2,1,2,5,7,1,9,3,6,8,8}
A2[] = {99,22,444,56}

Output: 1 1 2 2 3 5 6 7 8 8 9

Explanation: 
No A2 elements are in A1
so we cannot sort A1 according to A2.
Hence we sort the elements in 
non-decreasing order.

// Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 

class RelativeSorting {

	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		      System.out.print(x+" ");
		    
		    System.out.println();
		}
	}

// A1[] : the input array-1
// N : size of the array A1[]
// A2[] : the input array-2
// M : size of the array A2[]
public static void sortA1ByA2(int A1[], int N, int A2[], int M)
{    
    HashMap<Integer,Integer> map = new HashMap<>();
    //Do the sorting only when first array is greater than or equal to Second array
    if(N>=M)
    {
        //Traverse the first array and store the frequency of elements in HashMap
        for(int i=0;i<N;i++)
        {
            Integer temp = map.getOrDefault(A1[i],0);
            map.put( A1[i], temp+1 );
        }
        // Traverse the second array and check whether each element is present in Hashmap and count the unmatching elements. 
        int countOfUnmatchingElements = 0;
        for(int i=0;i<M;i++)
        {
            if(!map.containsKey(A2[i]))
            {
                countOfUnmatchingElements++;
            }
        }
        //If no element matches with first array then Sort the first element in ascending order.
        if(countOfUnmatchingElements == M)
        {
            Arrays.sort(A1);
        }
        //If Part of the elements are present in the array.
        else
        {
            int index = 0,count = 0;
            //Traverse the second array and first assign the matching elements according to the second array's order and decrement the count of the assigned elements.
            for(int j=0;j<M;j++)
            {
                Integer temp = map.getOrDefault(A2[j],0);
                if(temp > 0)
                {
                    while(temp!=0)
                    {
                        A1[index] = A2[j];
                        index++;
                        temp--;
                    }
                }
                map.put(A2[j],temp);
            }
            ArrayList<Integer> alist = new ArrayList<>();
            //Traverse the map and add the remaining elements in the Arraylist
            for(Map.Entry<Integer,Integer> m : map.entrySet())
            {
                int t2 = (int)m.getValue();
                if(t2>0)
                {
                    while(t2!= 0)
                    {
                        alist.add(m.getKey());
                        t2--;
                    }
                }
            }
            //Sort the remaining elements
            Collections.sort(alist);
            int remainingEleind = 0;
            //Assigned the remaining sorted elements.
            while(index<N)
            {
                A1[index] = alist.get(remainingEleind);
                remainingEleind++;
                index++;
            }
        }
    }
}

}

Time Complexity : O(NlogN)
Space Complexity : O(N)

