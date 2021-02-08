/*
Question :
Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.
Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
*/

//Solution in JAVA

import java.util.*;

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


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Merge g = new Merge();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}

// a is an array of Nodes of the heads of linked lists
// and N is size of array a
class Merge
{
    Node mergeKList(Node[]a,int N)
    {
        Node resultHead = null;
        Node resultLast = null;
        //to store the heap elements in ascending order
        PriorityQueue<Node> pqueue = new PriorityQueue<>( new Comparator<Node>() {
            
            public int compare(Node n1,Node n2)
            {
                return n1.data - n2.data;
            }
        });
        
        for(int i=0;i<N;i++)
        {
            //add first node of each row
            if(a[i]!=null)
                pqueue.add(a[i]);
        }
        //traverse till elements in min heap exists
        while(!pqueue.isEmpty())
        {
            //get the minimum element in heap and remove it
            Node minInHeap = pqueue.peek();
            pqueue.poll();
            //add the next node from the removed list
            if(minInHeap.next != null)
                pqueue.add(minInHeap.next);
            //if the node is the first element to get inserted in the result list
            if(resultHead == null)
            {
                resultHead = minInHeap;
                resultLast = minInHeap;
            }
            //else, add the node at the last of the result linked list
            else
            {
                resultLast.next = minInHeap;
                resultLast = resultLast.next;
            }
        }
        return resultHead;
    }
}
