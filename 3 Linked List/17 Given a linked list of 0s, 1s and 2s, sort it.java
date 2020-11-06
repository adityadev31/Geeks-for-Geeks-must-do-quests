/*

Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103

*/







/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    // find middle
    static Node findMid(Node head){
        Node fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    // merge 2 sorted LL
    static Node merge(Node head1, Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if(head1.data < head2.data){
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else{
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
    
    // driver merge
    static Node mergeSort(Node head1){
        if(head1 == null || head1.next == null) return head1;
        Node mid = findMid(head1);
        Node head2 = mid.next;
        mid.next = null;
        head1  = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    
    static Node segregate(Node head)
    {
        return mergeSort(head);
    }
}


