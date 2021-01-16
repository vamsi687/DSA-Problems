/*
Question :
You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.

Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1. 

Example 2:

Input:
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1
Explanation: The Linked list does not 
contains any loop. 
*/

// Solution in JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends

class solver
{
    public static void removeLoop(Node head){
        // remove the loop without losing any nodes
        //Find the cycle in a loop
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast!=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        // if cycle was found.
        if(slow == fast)
        {
            /* 
            // Naive solution
            
            Node ptr1 = head;
            Node ptr2 = null;
            
            //For every one step of ptr1, point the ptr2 at meeting point and traverse it through the loop.
            //if ptr2.next = ptr1 then remove loop by making ptr2.next = null
            while(true)
            {
                ptr2 = slow;
                while(ptr2.next != slow && ptr2.next != ptr1)
                {
                    ptr2 = ptr2.next;
                }
                if(ptr2.next == ptr1)
                    break;
                ptr1 = ptr1.next;
            }
            ptr2.next = null;
            */
            
            // Better Solution
            // Assign pointers with meeting point
            Node ptr1 = slow;
            Node ptr2 = slow;
            int count = 1;
            // Count the nodes in the loop
            while(ptr1.next != ptr2)
            {
                ptr1 = ptr1.next;
                count++;
            }
            ptr1 = head;
            //Move ptr1 till count
            for(int i=0;i<count;i++)
            {
                ptr1 = ptr1.next;
            }
            ptr2 = head;
            //Traverse ptr2 from head & ptr1 from count pos node till they meet
            //The point where they meet is the starting point of the loop
            while(ptr2 != ptr1)
            {
                ptr2 = ptr2.next;
                ptr1 = ptr1.next;
            }
            // Traverse the loop and move to the end point
            while(ptr1.next != ptr2)
            {
                ptr1 = ptr1.next;
            }
            //Remove the link from end point to start point to break the loop.
            ptr1.next = null;
        }
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(1)
*/
