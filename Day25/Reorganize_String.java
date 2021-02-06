/*
Question :
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
*/

//Solution in JAVA

import java.util.*;

class Solution {

    class Key
    {
        char c;
        int freq;

        Key(char ch,int freq)
        {
            this.c = ch;
            this.freq = freq;
        }
    }
    
    //Override compare method based on decreasing order of frequencies of characters
    class KeyComparator implements Comparator<Key>
    {
        @Override
        public int compare(Key k1,Key k2)
        {
            if(k1.freq < k2.freq)
                return 1;
            else if(k1.freq > k2.freq)
                return -1;

            return 0;
        }
    }
    
    public String reorganizeString(String S) 
    {
        int n = S.length();
        //to store characters with their frequencies in descending order
        PriorityQueue<Key> pqueue = new PriorityQueue<>(new KeyComparator());
        
        Map<Character,Integer> map = new HashMap<>();
        //Stores character as key and it's frequency as value
        for(int i=0;i<n;i++)
        {
            Integer frequency = map.getOrDefault(S.charAt(i),0);
            map.put(S.charAt(i),frequency+1);
        }
        
        for(Map.Entry m : map.entrySet())
        {
            pqueue.add(new Key((Character)m.getKey(),(int)m.getValue()));            
        }
        
        StringBuilder result = new StringBuilder();
        //Initially prev contains $ as key and -1 as frequency
        Key prev = new Key('$',-1);
        //loop till priority queue becomes null
        while(pqueue.size() != 0)
        {
            //pop the character of highest frequency
            Key k = pqueue.poll();
            //append to result string
            result.append(k.c);
            //again add the character to priority queue only when it's frequency is more than 1
            if(prev.freq > 0)
                pqueue.add(prev);
            //decrease the frequency and update prev    
            k.freq -= 1;
            prev = k;
        }
        
        if(n != result.length())
            return "";
        
        return result.toString();
    }
}
