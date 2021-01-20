/*
Question :
Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \ 
 3     2
Output:1 3 2

Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:10 20 30 40 60 N N
*/

//Solution in JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Level_order_traversal g = new Level_order_traversal();
                ArrayList <Integer> res = g.levelOrder(root);
                for (Integer num : res) System.out.print(num + " ");
    			System.out.println();
                t--;            
        }
    }  
}

class Level_order_traversal
{
    static int treeHeight(Node node)
    {
        if(node == null)
            return 0;
        int leftTreeHeight = treeHeight(node.left);
        int rightTreeHeight = treeHeight(node.right);
        if(leftTreeHeight > rightTreeHeight)
            return (leftTreeHeight+1);
        return (rightTreeHeight+1);
    }
    
    static void displayEachLevel(Node node,int level,ArrayList<Integer> levelOrder)
    {
        if(node == null)
            return;
        if(level == 1)
        {
            levelOrder.add(node.data);
            return;
        } 
        else if(level > 1)
        {
            displayEachLevel(node.left,level-1,levelOrder);
            displayEachLevel(node.right,level-1,levelOrder);    
        }
        
    }
    
    static ArrayList <Integer> levelOrder(Node node) 
    {
        int height = treeHeight(node);
        ArrayList<Integer> levelOrder = new ArrayList<Integer>();
        for(int i=1;i<=height;i++)
        {
            displayEachLevel(node,i,levelOrder);
        }
        return levelOrder;
    }
}
