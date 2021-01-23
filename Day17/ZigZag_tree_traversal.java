/*
Question :
Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

Example 1:

Input:
        3
      /   \
     2     1
Output: 3 1 2
 

Example 2:

Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output: 7 7 9 8 8 6 9 10 
*/

//Solution in JAVA

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
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
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        }
	}
}// } Driver Code Ends

class GFG
{    
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> out = new ArrayList<>();
	    //To Store currentLevel
	    Stack<Node> currentLevel = new Stack<>();
	    //To Store Next level
	    Stack<Node> nextLevel = new Stack<>();
	    //To toggle between left & right traversal accross alternate levels
	    boolean leftToRight = true;
	    currentLevel.push(root);
	    while(!currentLevel.isEmpty())
	    {
	        Node node = currentLevel.pop();
	        out.add(node.data);
	        if(leftToRight)
	        {
	            if(node.left !=null)
	                nextLevel.push(node.left);
	            if(node.right != null)
	                nextLevel.push(node.right);
	        }
	        else
	        {
	            if(node.right != null)
	                nextLevel.push(node.right);
	            if(node.left !=null)
	                nextLevel.push(node.left);
	        }
	        //If cuurent level elements got processed, 
	        //traverse the elements in opposite order by toggling leftToRight variable
	        if(currentLevel.isEmpty())
	        {
	            leftToRight = leftToRight?false:true;
	            Stack<Node> temp = currentLevel;
	            currentLevel = nextLevel;
	            nextLevel = temp;
	        }
	    }
	    return out;
	}
}
