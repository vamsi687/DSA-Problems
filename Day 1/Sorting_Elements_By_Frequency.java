// Sorting Array elements by it's Frequency
/*
Question :
Given an array of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first.
If frequencies of two elements are same, then smaller number comes first.

Example 1:

Input:
T = 1 //Test cases
N = 5
A[] = {5,5,4,6,4}

Output: 4 4 5 5 6

Explanation: 
The highest frequency here is 2. 
Both 5 and 4 have that frequency. Now
since the frequencies are same then 
smaller element comes first. So 4 comes 
first then comes 5. Finally comes 6.
The output is 4 4 5 5 6.

Example 2:

Input:
T = 1 //Test cases
N = 5
A[] = {9,9,9,2,5}

Output: 9 9 9 2 5

Explanation: 
The highest frequency here is 3. 
The element 9 has the highest frequency
So 9 9 9 comes first. Now both 2 and 5
have same frequency. So we print smaller
element first.
The output is 9 9 9 2 5.

Solution in JAVA.
*/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class SortByFrequency 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Sorting().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}

class Sorting
{
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
         Map<Integer, Integer> map = new HashMap<>(); 
        ArrayList<Integer> outputArray = new ArrayList<>(); 
  
        // Assign elements and their count in the list and map 
        for (int current : arr) { 
            int count = map.getOrDefault(current, 0); 
            map.put(current, count + 1); 
            outputArray.add(current); 
        } 
  
        // Compare the map by value 
        SortComparator comp = new SortComparator(map); 
  
        // Sort the map using Collections CLass 
        Collections.sort(outputArray, comp); 
  
        // Final Output 
        return outputArray; 
    }
}

class SortComparator implements Comparator<Integer> 
{ 
    private final Map<Integer, Integer> freqMap; 
  
    // Assign the specified map 
    SortComparator(Map<Integer, Integer> tFreqMap) 
    { 
        this.freqMap = tFreqMap; 
    } 
  
    // Compare the values 
    @Override
    public int compare(Integer k1, Integer k2) 
    { 
  
        // Compare value by frequency 
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1)); 
  
        // Compare value if frequency is equal 
        int valueCompare = k1.compareTo(k2); 
  
        // If frequency is equal, then just compare by value, otherwise - 
        // compare by the frequency. 
        if (freqCompare == 0) 
            return valueCompare; 
        else
            return freqCompare; 
    } 
} 

/*
Time Complexity : O(NlogN)
Space Complexity : O(N)

Resources : https://www.geeksforgeeks.org/sort-elements-by-frequency-set-5-using-java-map/
*/
