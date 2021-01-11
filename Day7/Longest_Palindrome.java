/*
Question :
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. 
Incase of conflict, return the substring which occurs first ( with the least starting index )

nput:
The first line of input consists number of the testcases. The following T lines consist of a string each.

Output:
In each separate line print the longest palindrome of the string given in the respective test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ Str Length ≤ 104

Example:
Input:
1
aaaabbaa

Output:
aabbaa

Explanation:
Testcase 1: The longest palindrome string present in the given string is "aabbaa".
*/

// Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isPalindrome(String inp)
    {
        int len = inp.length();
        int j = len-1;
        for(int i=0;i<=len/2;i++)
        {
            if(inp.charAt(i)!=inp.charAt(j))
            {
                return false;
            }
            j--;
        }
        return true;
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
		    String input = sc.next();
		    int maxLen = Integer.MIN_VALUE,length =0;
		    boolean res = false;
		    String maxPalindrome = "";
		    for(int i=0;i<=input.length()-1;i++)
		    {
		        for(int j=i+1;j<=input.length();j++)
		        {
		            res = isPalindrome(input.substring(i,j));
		            if(res)
		            {
		                
		                if(res)
		                {
		                    length = j-i;
		                    
		                    if(length>maxLen)
		                    {
		                        maxLen = length;
		                        maxPalindrome = input.substring(i,j);
		                    }
		                }
		            }
		        }
		    }
		    System.out.println(maxPalindrome);
		}
	}
}

