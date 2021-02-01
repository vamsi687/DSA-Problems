/*
Question :
Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Example 1:

Input:
N = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
N = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
       0
    /     \
   1       2
 /   \    /
3    4   5
*/

//Solution in JAVA

import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution
{
    int preindex = 0;
    
    Node build(int inorder[],int preorder[],int inStart,int inEnd)
    {
        if(inStart > inEnd)
            return null;
        //Store Current Preorder node and increment preorder index
        Node curPreNode = new Node(preorder[preindex++]);
        //if it has no child then return
        if(inStart == inEnd)
            return curPreNode;
        //get the current node by searching it in inorder
        int inIndex = search(inorder,inStart,inEnd,curPreNode.data);
        //left of the found index contains its left sub tree
        curPreNode.left = build(inorder,preorder,inStart,inIndex-1);
        //right of the found index contains its right sub tree
        curPreNode.right = build(inorder,preorder,inIndex+1,inEnd);
        
        return curPreNode;
    }
    
    int search(int inorder[],int start,int end,int data)
    {
        int i;
        for(i=start;i<=end;i++)
        {
            if(inorder[i] == data)
                return i;
        }
        return i;
    }
    
    public Node buildTree(int inorder[], int preorder[], int n)
    {
        return build(inorder,preorder,0,n-1);
    }
}


//Time Complexity : O(N*N)
