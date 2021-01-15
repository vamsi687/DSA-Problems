/*
Question :
Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.

Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
*/

// Solution in JAVA

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            ReverseLL g = new ReverseLL();
            head = g.reverseList(head);
            printList(head); 
            t--;
        }
    } 
}    

class ReverseLL
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null)
        {
            next = cur.next ;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(1)
*/
