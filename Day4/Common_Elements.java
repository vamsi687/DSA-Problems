//Find the Common elements from the given 3 sorted arrays.
/*
Question :
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}

Output: 20 80

Explanation: 
20 and 80 are the only common elements in A, B and C.
*/

//Solution in JAVA


import java.util.*;

public class CommonElements
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        //Traverse through first array
        for(int i=0;i<n1;i++)
        {          
            //If map doesn't contain the element then add the element in map. Add the duplicate elements only once.
            // map.put(<Element>,<First_Array>)
            if(!map.containsKey(A[i]))
            {
                map.put(A[i],1);    
            }
            else
                continue;
        }
        //Traverse through second array
        for(int i=0;i<n2;i++)
        {
            // If element doesn't exist in map then it is not present in first array
            if(!map.containsKey(B[i]))
            {
                continue;    
            }
            else
            {
                //If the element is present in the first array, then only add it in the map and change the value to '2' indicating that element is present in 2nd array.
                if(map.get(B[i]) == 1)
                    map.put(B[i],2);
            }
        }
        //Traverse through third array
        for(int i=0;i<n3;i++)
        {
           if(!map.containsKey(C[i]))
            {
                continue;    
            }
            else
            {
                //If the element is present in the second array, then only add it in the map and change the value to '3' indicating that element is present in 3rd array.
                if(map.get(C[i]) == 2)
                    map.put(C[i],3);
            }
                
        }
        ArrayList<Integer> output = new ArrayList<>();
        //Traverse through map elements
        for(Map.Entry<Integer,Integer> m: map.entrySet())
        {
            // Add the elements which has only value=3, this indicates that the elements are present in all the 3 arrays.
            if((int)m.getValue() == 3)
                output.add((int)m.getKey());
        }
        return output;
    }
}

/*
Time Complexity : O(N) //Linear time
Space Complexity : O(N)
*/
