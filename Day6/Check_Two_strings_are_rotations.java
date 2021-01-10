/*
Question :
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?

Example :
Input :
s1 = ABCD and s2 = CDAB
Output : 
Two strings are rotations of each other

Input :
s1 = ABCD and s2 = ACBD
Output :
Two strings are not rotations of each other
*/

//Solution in JAVA

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		boolean flag = false;
		if(s1.length() == s2.length())
		{
		    if((s1+s1).indexOf(s2) != -1)
		    {
		        flag = true;
		    }
		}
		if(flag)
		{
		    System.out.println("Two strings are rotations of each other");        
		}
		else
		{
		    System.out.println("Two strings are not rotations of each other");
		}
	}
}

/*
Time Complexity : O(1)
Space Complexity : O(1)
*/
