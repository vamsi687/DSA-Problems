/*
Question :
Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. 

Example 1:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilike"
Output: 1
Explanation:The string can be segmented as "i like".

Example 2:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilikesamsung"
Output: 1
Explanation: The string can be segmented as 
"i like samsung" or "i like sam sung".
*/

// Solution in JAVA

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        int len = A.length(), i=0,j=1, flag = 0;
        while(i<len && j<=len)
        {
            if(B.contains(A.substring(i,j)))
            {
                flag = 1;
                i = j;
                j++;
            }
            else
            {
                j++;
                flag = 0;
            }
        }
        if(flag == 0)
            return 0;
        return 1;
    }
}
