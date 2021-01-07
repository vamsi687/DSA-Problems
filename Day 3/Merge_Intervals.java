// Merge the intervals which are overlapping

/*
Question :
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]

Output: [[1,5]]

Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

//Solution in JAVA

import java.util.*;
public class MergeIntervals
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    int cols = 2; //No: of columns = 2
		int[][] input = new int[rows][cols];
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<cols;j++)
      {
        input[i][j] = sc.nextInt();
      }
		}
    MergeInt mergeInt = new MergeInt();
    
    int[][] output = mergeInt.merge(input);
    rows = output.length;
    cols = output[0].length;
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<cols;j++)
      {
        System.out.print(output[i][j]+" ");
      }
      System.out.println();
		}
		
	}
}

class MergeInt {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0],i2[0]));
        
        ArrayList<int[]> out = new ArrayList<>();
        int[] prev;
        out.add(intervals[0]);
        for(int[] cur : intervals)
        {
            prev = out.get(out.size()-1);
            if(prev[1] >= cur[0])
            {
                prev[1] = Math.max(prev[1],cur[1]);
                continue;
            }
            else
            {
                out.add(cur);
            }
        }
        return out.toArray(new int[out.size()][2]);
    }
}

/*
Time Complexity : O(NlogN)
Space Compelexity : O(N)
*/
