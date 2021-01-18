/* Merge sort for Linked list

Question :
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.

Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
*/

// JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

class LinkedList
{
    static Node merge(Node left,Node right)
    {
        Node res = null;
        if(left == null)
            return right;
        if(right == null)
            return left;
        
        if(left.data <= right.data)
        {
            res = left;
            res.next = merge(left.next, right);
            
        }
        else
        {
            res = right;
            res.next = merge(left,right.next);
            
        }
        return res;
    }
    
    public static Node getMiddle(Node head)
    {
        if(head == null)
            return head;
        Node slow = head;
        Node fast = head.next;
        while(fast!=null)
        {
            fast = fast.next;
            if(fast!=null)
            {
                slow = slow.next;
                fast = fast.next;    
            }
        }
        return slow;
    }
    
    static Node mergeSort(Node head)
    {        
        if(head==null || head.next==null)
            return head;
        
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        Node mergedList = merge(left,right);
        return mergedList;
    }
}
