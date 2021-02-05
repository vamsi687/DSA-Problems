/*
Question :
Given two binary max heaps as arrays, merge the given heaps, after merging the two arrays.
The task is very simple to merge the two arrays firstly keep all the elements of first array
than elements second array, than apply the merge operation of heaps.

Input:
First line consists of T test cases. First line of every test case consists of 2 integers N and M, 
denoting the number elements of two arrays (MAX HEAP). Second and third line of every test cases consists
of elements of 2 Heaps respectively.

Output:
Single line output, print the merged max heap.

Constraints:
1<=T<=100
1<=N,M<=100

Example:
Input:
1
4 3
10 5 6 2
12 7 9
Output:
12 10 9 2 5 7 6 
*/

//Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static void heapify(int[] arr,int n,int i)
    {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[i] < arr[left])
            largest = left;
        if(right<n && arr[largest] < arr[right])
            largest = right;
            
        if(largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr,n,largest);
        }
    }
    
    static void buildHeap(int[] arr,int n)
    {
        int lastParentInd = (n/2)-1;
        
        for(int i=lastParentInd;i>=0;i--)
        {
            heapify(arr,n,i);
        }
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    int[] first = new int[N];
		    int[] second = new int[M];
		    for(int i=0;i<N;i++)
		    {
		        first[i] = sc.nextInt();
		    }
		    for(int i=0;i<M;i++)
		    {
		        second[i] = sc.nextInt();
		    }
		    int[] merge = new int[N+M];
		    for(int i=0;i<N+M;i++)
		    {
		        if(i<N)
		        {
		            merge[i] = first[i];
		        }
		        else
		        {
		            merge[i] = second[i-N];
		        }
		    }
		    
		    buildHeap(merge,N+M);
		    for(int i=0;i<N+M;i++)
		    {
		        System.out.print(merge[i]+" ");
		    }
		    System.out.println();
		}
	}
}
