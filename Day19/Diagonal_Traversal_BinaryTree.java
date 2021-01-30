/*
Question :
Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}

class Tree
{
    void diagonalTraversal(Node node,int diagonal,TreeMap<Integer,ArrayList<Integer>> diagonalElements)
    {
        if(node == null)
            return;
        
        ArrayList<Integer> temp = diagonalElements.get(diagonal);
        //if the element is at the starting point of the diagonal
        if(temp == null)
        {
            temp = new ArrayList<Integer>();
            temp.add(node.data);
        }
        //else add to the existing diagonal elements list
        else
        {
            temp.add(node.data);
        }
        //update the elements list in the map
        diagonalElements.put(diagonal,temp);
        //traverse to left subtree by increasing the diagonal by 1
        diagonalTraversal(node.left,diagonal+1,diagonalElements);
        //as right subtree comes under same diagonal, it is passed as it is
        diagonalTraversal(node.right,diagonal,diagonalElements);
    }
     public ArrayList<Integer> diagonal(Node root)
      {
          //tree map is used to keep the map in a sorted order wrt diagonals which acts as a key
        TreeMap<Integer,ArrayList<Integer>> diagonalElements = new TreeMap<>();
        //call method to get the elements of it's diagonal
        diagonalTraversal(root,0,diagonalElements);
        
        ArrayList<Integer> output = new ArrayList<>();
        //add each diagonals list sequentially
        for(Map.Entry<Integer,ArrayList<Integer>> m : diagonalElements.entrySet())
        {
            output.addAll(new ArrayList(m.getValue()));
        }
        return output;
      }
}
