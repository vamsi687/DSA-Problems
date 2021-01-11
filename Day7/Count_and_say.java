/*
Question :
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character.
Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, 
replace the counts with a number and concatenate every saying.

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*/

//Solution in JAVA
//Create a public class. In Main method, create a Solution object and call countAndSay() method

class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        String str = "11";
        for(int i=3;i<=n;i++)
        {
            str += "$";
            int len = str.length();
            int count = 1;
            char[] arr = str.toCharArray();
            String temp = "";
            for(int j=1;j<len;j++)
            {
                if(arr[j] != arr[j-1])
                {
                    temp += count+0;
                    temp += arr[j-1];
                    count = 1;
                }
                else
                {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }
}

