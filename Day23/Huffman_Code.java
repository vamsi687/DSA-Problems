/*
Question :
Given An array of Alphabets and their frequency. Your task is to print all the given alphabets Huffman Encoding.
Note: If two elements have same frequency, then the element which if at first will be taken on left of Binary Tree and other one to right.

Input:
First line consists of test cases T. First line of every test case consists of string of alphabets and second line consists of its frequencies.

Output:
Print the HuffmanCodes in single line, with n spaces of each alphabet's HuffmanCodes respectively. In PreOrder form of Binary Tree.
Example:
Input:
1
abcdef
5 9 12 13 16 45
Output:
0 100 101 1100 1101 111 
*/

//Solution in JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class Huffman
{
    char alphabet;
    int freq;
    Huffman left,right;
  
}

class MyComparator implements Comparator<Huffman>
{
    @Override
    public int compare(Huffman h1,Huffman h2)
    {
        if(h1.freq == h2.freq)
            return 1;
        return h1.freq - h2.freq;
    }
}

class GFG {
    
    static void displayHuffmanCodeinPreOrder(Huffman root,String code)
    {
        //if the node is leaf & character is an alphabet then print the code
        if(root.left == null && root.right == null && Character.isLetter(root.alphabet))
        {
            System.out.print(code+" ");
            return;
        }
        //to left sub tree concatenate the code with '0' 
        displayHuffmanCodeinPreOrder(root.left,code+"0");
        //to right sub tree concatenate the code with '1' 
        displayHuffmanCodeinPreOrder(root.right,code+"1");
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
		    String input = sc.next();
		    int n = input.length();
		    int[] freq = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        freq[i] = sc.nextInt();
		    }
		    char[] inpChars = input.toCharArray();
		    
		    PriorityQueue<Huffman> queue = new PriorityQueue<Huffman>(n,new MyComparator());
		    for(int i=0;i<n;i++)
		    {
		        Huffman hm = new Huffman();
		        hm.alphabet = inpChars[i];
		        hm.freq = freq[i];
		        hm.left = null;
		        hm.right = null;
		        //insert every alphabet and it's frequency into priority queue
		        queue.add(hm);
		    }
		    //intialize root with null
		    Huffman root = null;
		    //loop till all the nodes get extracted
		    while(queue.size() > 1)
		    {
		        //get the lowest frequency node
		        Huffman first = queue.peek();
		        queue.poll();
		        //get the second lowest frequency node
		        Huffman second = queue.peek();
		        queue.poll();
		        //new node is created with freq data as summ of first & second
		        Huffman internal = new Huffman();
		        internal.alphabet = '-';
		        internal.freq = first.freq+second.freq;
		        internal.left = first;
		        internal.right = second;
		        //initialize it with root
		        root = internal;
		        //add the internal node to queue
		        queue.add(internal);
		    }
		    //Display the huffman codes in pre order of binary tree
		    displayHuffmanCodeinPreOrder(root,"");
		    System.out.println();
		}
	}
}

//Resources : https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
