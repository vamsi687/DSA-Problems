/* Add 1 to a number represented as linked list 
Question :
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 

Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
*/

// Solution in JAVA

import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Sol obj = new Sol();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}

class Sol
{
    public static Node reverseLL(Node head)
    {
        Node prev = null;
        Node cur = head;
        Node next = head;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
    
    public static Node addOne(Node head) 
    {         
        head = reverseLL(head);
        Node temp = head;
        int carry = 0;
        while(temp != null)
        {
            if(temp == head)
            {
                temp.data += 1;
                if(temp.data > 9)
                {
                    if(temp.next != null)
                    {
                        temp.data -= 10;
                        carry = 1;
                    }
                }
                temp = temp.next;
            }
            else
            {
                if(carry > 0)
                {
                    temp.data += carry; 
                    carry = 0;
                    if(temp.data > 9)
                    {
                        if(temp.next != null)
                        {
                            temp.data -= 10;
                            carry = 1;    
                        }
                    }
                }
                temp = temp.next;
                
            }
        }
        head = reverseLL(head);
        return head;
    }
}

/*
Time Complexity : O(N)
Space Complexity : O(1)
*/
