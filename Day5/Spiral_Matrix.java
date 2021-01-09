//Traverse the matrix in Spiral form
/*
Question :
Given a matrix of size R*C. Traverse the matrix in spiral form.

Example 1:

Input:
R = 4, C = 4
matrix[][] =  {{1, 2, 3, 4},
               {5, 6, 7, 8},
               {9, 10, 11, 12},
               {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

      1-2-3--4
             |
-->5-6-7    8
|      |     |
9  10<-11   12
|^            |
13 -14 -15<-16


Example 2:

Input:
R = 3, C = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.
*/
//Solution in JAVA

import java.io.*;
import java.util.*;
class SpiralMatrix
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}

class Solution{
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {

        ArrayList<Integer> output = new ArrayList<>();
        int toprow = 0, bottomRow = r-1, leftCol = 0, rightCol = c-1, i = 0;
        while(toprow<=bottomRow && leftCol<=rightCol)
        {
            for(i=leftCol;i<=rightCol;++i)
            {
                  output.add(matrix[toprow][i]);
                  
            }
            toprow++;
            for(i=toprow;i<=bottomRow;++i)
            {
                output.add(matrix[i][rightCol]);              
            }            
            rightCol--;
            if(toprow<=bottomRow)
            {
                for(i=rightCol;i>=leftCol;--i)
                {
                    output.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }
            if(leftCol <= rightCol)
            {
                for(i=bottomRow;i>=toprow;--i)
                {
                    output.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        
        return output;
    }
}

/*
Time Complexity : O(N*M)
Space Complexity : O(N*M)
*/
