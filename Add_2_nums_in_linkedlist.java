/* 
Add two numbers represented by linked lists 

Question :
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).

Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
*/

//Solution in JAVA

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

class Solution{
    static Node reverseLL(Node head)
    {
        Node prev = null;
        Node cur = head;
        Node next = null;
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
    
    static Node addTwoLists(Node first, Node second){
        // return head of sum list
        //Reverse the linked lists
        first = reverseLL(first);
        second = reverseLL(second);
        Node fptr = first;
        Node sptr = second;
        int carry = 0;
        
        Node resHead = null;
        Node resTemp = null;
        //loop until both linked become null and no more carry is present
        while(fptr!=null || sptr!=null || carry==1)
        {
            //For first node
            if(fptr==first && sptr == second)
            {
                resHead = new Node(fptr.data+sptr.data);
                if(resHead.data > 9)
                {
                    resHead.data -= 10;
                    carry = 1;
                }
                resTemp = resHead;
                fptr = fptr.next;
                sptr = sptr.next;
            }
            //For remaining nodes
            else
            {
                Node temp = new Node(carry);
                //If data present in both nodes
                if(fptr!=null && sptr!=null)
                {
                    temp.data = fptr.data+sptr.data+carry;    
                }
                //Data present in any node of first & second linked list
                else if(fptr!=null && sptr==null)
                {
                    temp.data = fptr.data+carry;
                }
                else if(fptr==null && sptr!=null)
                {
                    temp.data = sptr.data+carry;
                }
                //If only carry is present
                else if(fptr ==null && sptr==null && carry==1)
                {
                    temp.data = carry;
                }
                carry = 0;
                // If data is of 2 digits, store only units place in it and take the carry
                if(temp.data > 9)
                {
                    temp.data -= 10;
                    carry = 1;
                }
                
                if(fptr != null)
                {
                    fptr = fptr.next;    
                }
                if(sptr != null)
                {
                    sptr = sptr.next;    
                }
                
                resTemp.next = temp;
                resTemp = resTemp.next;
            }
            
        }
        //Reverse the result linked list and return it.
        resHead = reverseLL(resHead);
        return resHead;
    }
}

/*
Time Complexity : O(N+M)
Space Complexity : O(max(N+M))
*/
