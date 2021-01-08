//Count the number of pairs can be formed using the given sum.
/*
Question :
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:

Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.
*/

//Solution in JAVA

import java.io.*;
import java.util.*;

public class CountPairs {

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
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
    
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //Store the elements in map with their frequencies.
        for(int i=0;i<n;i++)
        {
            int temp = map.getOrDefault(arr[i],0);
            map.put(arr[i],temp+1);
        }
        int count = 0;
        for(int i=0;i<n;i++)
        {
            // If the difference of k & arr[i] exists then the sum will be k.
            if(map.containsKey(k-arr[i]))
            {
                // As there may be many with value 'k-arr[i]' i.e duplicates, add frequency to count.
                count += map.get(k-arr[i]);
                // Example : k=4, arr[i] =2. To avoid repeating count. 
                if(arr[i] == k-arr[i])
                {
                    count--;
                    
                }
                
            }
        }
        //Now count contains all the pairs twice. So, return count/2.
        return count/2;
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(N)
*/
