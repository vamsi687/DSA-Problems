/*Intersection Point in Y Shapped Linked Lists 

Question :
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
*/

//Solution in JAVA

import java.util.*;


class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
 class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {

   tail.next=node;
   tail = node;
  }
}

  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
    public static void main(String args[])
    {
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
     {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		  LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					tail1.next = (new Node(a));
					tail1= tail1.next;
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt();  
					tail2.next = (new Node(b));
					tail2= tail2.next;
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				tail1.next = head3;
				tail2.next = head3;
				Node tail3=head3;
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt();   
					tail3.next = (new Node(c));
					tail3= tail3.next;
				}
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(head1, head2));
			t--;			
         }
    }
}

class Intersect
{
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         int count1=0,count2=0;
         Node ptr1 = head1;
         while(ptr1!=null)
         {
             count1++;
             ptr1 = ptr1.next;
         }
         Node ptr2 = head2;
         while(ptr2!=null)
         {
             count2++;
             ptr2 = ptr2.next;
         }
         int diff =0;
         if(count1>count2)
         {
             
             diff = count1-count2;
             ptr1 = head1;
             for(int i=0;i<diff;i++)
             {
                 ptr1 = ptr1.next;
             }
             ptr2 = head2;
             while(ptr1!=null && ptr2!=null)
             {
                 if(ptr1.next == ptr2)
                 {
                     return ptr2.data;
                 }
                 else if(ptr1.next == ptr2.next)
                 {
                     return ptr1.next.data;
                 }
                 else
                 {
                     ptr1 = ptr1.next;
                     ptr2 = ptr2.next;
                 }
             }
         }
         else
         {
             ptr1 = head1;
             diff = count2-count1;
             ptr2 = head2;
             for(int i=0;i<diff;i++)
             {
                 ptr2 = ptr2.next;
             }
             while(ptr1!=null && ptr2!=null)
             {
                 if(ptr2.next == ptr1)
                 {
                     return ptr1.data;
                 }
                 else if(ptr1.next == ptr2.next)
                 {
                     return ptr2.next.data;
                 }
                 else
                 {
                     ptr1 = ptr1.next;
                     ptr2 = ptr2.next;
                 }
             }
         }
         
         return -1;
	}
}

/*
Time Complexity: O(N+M)
Auxiliary Space : O(1)
*/
