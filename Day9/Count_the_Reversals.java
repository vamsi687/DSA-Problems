/*
Question :
Given a string S consisting only of opening and closing curly brackets '{' and '}' find out the minimum number of reversals required to make a balanced expression.

Input
The first line of input contains an integer T, denoting the number of test cases. Then T test cases
follow. The first line of each test case contains a string S consisting only of { and }.

Output
Print out minimum reversals required to make S balanced. If it cannot be balanced, then print -1.

Constraints
1 <= T <= 100
0 <= |S| <= 50

Examples
Input
4
}{{}}{{{
{{}}}}
{{}{{{}{{}}{{
{{{{}}}}

Output
3
1
-1
0

Explanation:
Testcase 1: For the given string }{{}}{{{ since the length is even we just need to count the number of openning brackets
('{') suppose denoted by 'm' and closing brackest('}') suppose dentoed by 'n' after removing highlighted ones.
After counting compute ceil(m/2) + ceil(n/2).
*/

//Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
		    String inp = sc.next();
		    Stack<Character> st = new Stack<>();
		    int openCount = 0, closeCount = 0;
		    for(int i=0;i<inp.length();i++)
		    {
		        if(st.isEmpty())
		        {
		            st.push(inp.charAt(i));
		            if(inp.charAt(i) == '{')
		            {
		                openCount++;
		            }
		            else
		            {
		                closeCount++;
		            }
		        }
		        else
		        {
		            if(inp.charAt(i) == '}')
		            {
		                if(st.peek() == '{')
		                {
		                    st.pop();
		                    openCount--;
		                    continue;
		                }
		                else
		                {
		                    closeCount++;
		                    st.push(inp.charAt(i));
		                }
		            }
		            else
		            {
		                openCount++;
		                st.push(inp.charAt(i));
		            }
		        }
		    }
		    if(st.isEmpty())
		    {
		        System.out.println("0");
		    }
		    else if(!st.isEmpty() && st.size()%2 == 1)
		    {
		        System.out.println("-1");
		    }
		    else if(!st.isEmpty() && st.size()%2 == 0)
		    {
		        // ceil(m/2) + ceil(n/2) = (m+n)/2 + n%2
		        int reversals = (openCount+closeCount)/2 + closeCount%2;
		        System.out.println(reversals);
		    }
		}
	}
}

/*
Time Complexity : O(S)
Space COmplexity : O(S)
*/
