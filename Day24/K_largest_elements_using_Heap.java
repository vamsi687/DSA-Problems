/*
Question :
Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.

Example 1:

Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.
Example 2:

Input:
N = 7, K = 3
Arr[] = {1, 23, 12, 9, 30, 2, 50}
Output: 50 30 23
Explanation: 3 Largest element in the
array are 50, 30 and 23.
*/

//Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    
    void heapify(int[] arr,int n,int i)
    {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        //get the smallest value from root,left & right
        if(left<n && arr[smallest] > arr[left])
            smallest = left;
        if(right<n && arr[smallest] > arr[right])
            smallest = right;
        
        if(smallest != i)
        {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr,n,smallest);
        }
    }
    
    void buildHeap(int[] arr,int n)
    {
        int startIndex = (n/2)-1;
        
        for(int i=startIndex;i>=0;i--)
        {
            heapify(arr,n,i);
        }
    }
    
    void sort(int[] arr,int n)
    {
        for(int i=n-1;i>0;i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr,i,0);
        }
    }
    
    int[] kLargest(int[] arr, int n, int k) 
    {
        //Build a Min Heap
        int[] minHeap = new int[k];
        //insert first k elements in Min Heap
        for(int i=0;i<k;i++)
        {
            minHeap[i] = arr[i];
        }
        //Build heap using first k elements
        buildHeap(minHeap,k);
        //for remaining elements
        for(int i=k;i<n;i++)
        {
            //if the element > root of the heap(minimum element of heap)
            //then swap the element with root
            if(arr[i] > minHeap[0])
            {
                
                minHeap[0] = arr[i];
                //Balance the heap by calling heapify method
                heapify(minHeap,k,0);
            }
        }
        //Now heap contains the largest k elements 
        //sort the min heap in decreasing order 
        sort(minHeap,k);
        
        return minHeap;
    }
}
