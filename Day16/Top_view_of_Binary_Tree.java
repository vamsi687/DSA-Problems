/*
Question :
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3

Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
*/

//Solution in JAVA

import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class GfG{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
           {
               Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}
   
class Pair
{
    int first, second;
    Pair() {}
    Pair(int one,int two)
    {
        first = one;
        second = two;
    }
}

class View
{
    static void topViewUtil(Node node,int col,int row,Map<Integer,Pair> map)
    {
        if(node == null)
            return;
        if(!map.containsKey(col))
        {
            map.put(col,new Pair(node.data,row));
        }
        else if(map.get(col).second > row)
        {
            map.put(col,new Pair(node.data,row));
        }
        
        topViewUtil(node.left,col-1,row+1,map);
        topViewUtil(node.right,col+1,row+1,map);
    }
    
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        //key as column and values as, Pair(node.data, row )
        Map<Integer,Pair> map = new TreeMap<>();
        
        topViewUtil(root,0,0,map);
        
        for(Map.Entry<Integer,Pair> m : map.entrySet())
        {
            System.out.print((int)m.getValue().first+" ");
        }
        
    }
}

/*
Time Complexity: O(N)
Auxiliary Space: O(N)
*/
