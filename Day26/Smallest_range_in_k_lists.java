/*
Question :
Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists.
If more than one such range's are found, find the first such range found.

Example 1:

Input:
N = 5, K = 3
KSortedArray[][] = {{1 3 5 7 9},
                    {0 2 4 6 8},
                    {2 3 5 7 11}}
Output: 1 2
Explanation: K = 3
A:[1 3 5 7 9]
B:[0 2 4 6 8]
C:[2 3 5 7 11]
Smallest range is formed by number 1
present in first list and 2 is present
in both 2nd and 3rd list.
Example 2:

Input:
N = 4, K = 3
KSortedArray[][] = {{1 2 3 4},
                    {5 6 7 8},
                    {9 10 11 12}}
Output: 4 9
*/

//Solution in JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new smallestRangeFromKLists().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

class Node 
{
    int element; //stores data
    int i; //stores row
    int j; //stores next index
    
    Node(int ele,int i,int j)
    {
        this.element = ele;
        this.i = i;
        this.j = j;
    }
}

class MinHeap
{
    Node[] heapElements;
    int size;
    
    MinHeap(Node[] harr,int size)
    {
        this.heapElements = harr;
        this.size = size;
        //Build Min Heap
        int lastParentInd = (size/2)-1;
        
        while(lastParentInd >= 0)
        {
            //Balance the min heap
            MinHeapify(lastParentInd);
            lastParentInd--;
        }
    }
    
    void MinHeapify(int index)
    {
        int smallest = index;
        int left = 2*index+1;
        int right = 2*index+2;
        if(left<size && heapElements[left].element < heapElements[smallest].element)
            smallest = left;
            
        if(right<size && heapElements[right].element < heapElements[smallest].element )
            smallest = right;
            
        if(smallest != index)
        {
            Node temp = heapElements[smallest];
            heapElements[smallest] = heapElements[index];
            heapElements[index] = temp;
            MinHeapify(smallest);
        }
    }
    //get the minimum element
    Node getMin()
    {
        return heapElements[0];
    }
    //replace the minimum element with the next element of removed row
    void replaceMin(Node root)
    {
        heapElements[0] = root;
        MinHeapify(0);
    }
}

class smallestRangeFromKLists
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    int range = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    int start = -1,end=-1;
	    
	    Node[] minheap = new Node[k];
	    //store starting index of each row in an array to build min heap
	    for(int i=0;i<k;i++)
	    {
	        Node startNode = new Node(arr[i][0],i,1);
	        minheap[i] = startNode;
	        //update the max element
	        max = Math.max(max,startNode.element);
	    }
	    //Build min heap with first element of each row in 2D array
	    MinHeap mheap = new MinHeap(minheap,k);
	    
	    while(true)
	    {
	        //Get the minimum element
	        Node minimumNode = mheap.getMin();
	        //update min
	        min = minimumNode.element;
	        //if the range decreases, update the range
	        if(range > (max-min+1))
	        {
	            range = max-min+1;
	            start = min;
	            end = max;
	        }
	        //get the next element from the same row where the element gets removed
	        if(minimumNode.j < n)
	        {
	            minimumNode.element = arr[minimumNode.i][minimumNode.j];
	            minimumNode.j++;
	            //update the max element
	            if(max < minimumNode.element)
	                max = minimumNode.element;
	        }
	        //if any one of the row comes to end, stop the process
	        else 
	            break;
	       //Replace the root of min heap and further balance it using heapify
	        mheap.replaceMin(minimumNode);
	    }
	    //return start and end index of Minimum range
	    return new int[]{start,end};
	}
}

/*
Time complexity : O(n * k *log k)
Auxiliary Space complexity: O(k)
*/
