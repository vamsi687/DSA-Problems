/*
Question :
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.

Note: Follow 0 based indexing.

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.
*/

//Solution in JAVA

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution { 
    
    boolean knows(int M[][],int A, int B)
    {
        if(M[A][B] == 1)
            return true;
        return false;
    }
    
    int celebrity(int M[][], int n){
    	//stores all the people initially, Keeps on removing the people who is not celebrity
    	Stack<Integer> st = new Stack<>();
    	//push all people in stack
    	for(int i=0;i<n;i++)
    	{
    	    st.push(i);
    	}
    	//loop until stack has more than one element
    	while(st.size()>1)
    	{
    	    //pop top two people and check whether they know each other or not
    	    int A = st.pop();
    	    int B = st.pop();
    	    //if A knows B then A is not celebrity & B might be a celebrity, so push B again
    	    if(knows(M,A,B))
    	    {
    	        st.push(B);
    	    }
    	    //if A doesn't know B, then B is not a celebrity but A can be a celebrity. So, push A again
    	    else
    	        st.push(A);
    	}
    	//If there are only two people and there is no potential candicate
    	if(st.isEmpty())
    	    return -1;
    	//pop the last element from stack and check whether it is celebrity or not
	    int C = st.pop();
	    
	    for(int i=0;i<n;i++)
	    {
	        //if Any other person doesn't know C then he is not a Celebrity
	        //if C know any other person then he is not Celebrity
	        //In any of the case, return -1.
	        if(i!=C && (!knows(M,i,C) || knows(M,C,i)))
	            return -1;
	    }
	    return C;  
    }
}

/*
Time Complexity : O(N)
Auxiliary Space Complexity : O(N)
*/
