/*
Question :
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: 
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: 
As the sequence is already sorted so there is no inversion count.

Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: 
As all the elements of array are same, so there is no inversion count.

*/
//Solution in JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Inversion_of_Array().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Inversion_of_Array
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    
    static long merge(long[] arr, long l,long m,long h)
    {
        long leftlen = m-l+1;
        long rightlen = h-m;
        long i,j, swaps = 0;
        long[] left = new long[(int)leftlen];
        long[] right = new long[(int)rightlen];
        for(i=0;i<leftlen;i++)
        {
            left[(int)i] = arr[(int)(i+l)];
        }
        for(j=0;j<rightlen;j++)
        {
            right[(int)j] = arr[(int)(m+1+j)];
        }
        i=0;j=0;
        long k=l;
        while(i<leftlen && j<rightlen)
        {
            if(left[(int)i] <= right[(int)j])
            {
                arr[(int)k] = left[(int)i];
                i++;
            }
            else
            {
                arr[(int)k] = right[(int)j];
                j++;
                // As the array will be in ascending order, the element left[i] < right[j] indicates that right[j] < 'Remaining elements of left array'.
                // Add the remaining elements to swaps variable.
                swaps+= (m+1) - (l+i);
            }
            k++;
        }
        while(i<leftlen)
        {
            arr[(int)k] = left[(int)i];
            i++;
            k++;
        }
        while(j<rightlen)
        {
            arr[(int)k] = right[(int)j];
            j++;
            k++;
        }
        return swaps;
    }
    
    static long mergeSort(long[] arr, long l, long h)
    {
        long count = 0;
        if(l<h)
        {
            long mid = (h+l)/2;
            
            count += mergeSort(arr,l,mid);
            count += mergeSort(arr,mid+1,h);
            count += merge(arr,l,mid,h);
        }
        return count;
    }
    
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,N-1);
        
    }
}

/*
Time Complexity : O(NlogN)
Space Complexity : O(N)
*/
