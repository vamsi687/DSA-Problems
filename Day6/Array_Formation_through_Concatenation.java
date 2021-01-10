/*
Check Array Formation Through Concatenation

Question :
ou are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

Example 1:
Input: arr = [85], pieces = [[85]]
Output: true

Example 2:
Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]

Example 3:
Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].

Example 4:
Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]

Example 5:
Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false
*/

//Solution in JAVA

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    Solution sol = new Solution();
    int[] arr = new int[]{91,4,64,78};
    int[][] pieces = new int[][]{{78},{4,64},{91}};
    bool Result = sol.canFormArray(arr,pieces);
    if(Result)
      System.out.println("Concatenation can be formed");
    else
      System.out.println("Concatenation can not be formed");
	}
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            hmap.put(arr[i],i);
        }
        int count = 0;
        for(int i=0;i<pieces.length;i++)
        {
            // Check for cases of row length 1
            if(pieces[i].length == 1 && hmap.containsKey(pieces[i][0]))
            {
                continue;
            }
            // if row length>1 and first element matches then check for all the elements whether it matches or not
            else if(pieces[i].length > 1 && hmap.containsKey(pieces[i][0]))
            {
                int index = hmap.get(pieces[i][0]);
                index++;
                if(index>=arr.length)
                    return false;
                for(int j=1;j<pieces[i].length;j++)
                {
                    if(arr[index] == pieces[i][j])
                    {
                        index++;
                        if(index>= arr.length && j<pieces[i].length-1)
                        {
                            return false;
                        }
                    }
                    else
                        return false;
                }
            }
            //if first element itself is not matching.
            else
            {
               return false;
            }
        }
    return true;
}
}
