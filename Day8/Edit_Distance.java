/*
Question :
Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. 
The possible operations are:
1.Insert
2.Remove
3.Replace
 
Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of str1.

Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 0
Explanation: Both strings are same.
*/

//Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

class Solution
{
    
    public int min(int a, int b, int c)
    {
        if(a<b && a<c)
            return a;
        else if(b<a && b<c)
            return b;
        return c;
    }
    public int editDistance(String s, String t)
    {
        int firstLen = s.length(), secLen = t.length();
        int[][] dp = new int[firstLen+1][secLen+1];
        for(int i=0;i<=firstLen;i++)
        {
            for(int j=0;j<=secLen;j++)
            {
                if(i==0)
                {
                    dp[i][j] = j;
                }
                else if(j==0)
                {
                    dp[i][j] = i;
                }
                else if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1+ min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                }
            }
            
        }
        return dp[firstLen][secLen];
    }
}
/*
Time Complexity : O(M*N)
Space Complexity : O(M*N)
*/
