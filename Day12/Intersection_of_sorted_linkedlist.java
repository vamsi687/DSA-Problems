/*
Question :
Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. 
The new list should be made with its own memory — the original lists should not be changed.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.

Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
*/

// Solution in JAVA

import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node resHead = null;
        Node resPtr = null;
        while(ptr1!=null && ptr2!=null)
        {
            if(ptr1.data > ptr2.data)
            {
                ptr2 = ptr2.next;
            }
            else if(ptr1.data < ptr2.data)
            {
                ptr1 = ptr1.next;
            }
            else
            {
                if(resHead == null)
                {
                    resHead = new Node(ptr1.data);
                    resPtr = resHead;
                }
                else
                {
                    Node temp = new Node(ptr1.data);
                    resPtr.next = temp;
                    resPtr = resPtr.next;
                }
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        return resHead;
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(1)
*/
