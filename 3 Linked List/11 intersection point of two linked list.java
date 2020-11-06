/*

Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
 

Your Task:
You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1 and linklist2 as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.

 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 100
1 <= value <= 1000

*/








class Intersect
{
    int findLen(Node head){
        int count = 0;
        if(head!=null) count = 1;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
    
	int intersectPoint(Node headA, Node headB)
	{
	     if(headA == null || headB == null) return -1;
	    
         int lenA = 0, lenB = 0, lenDiff = 0;
         Node bigHead = null, smallHead = null;
         // finding lengths
         lenA = findLen(headA);
         lenB = findLen(headB);
         // finding smaller and larger heads
         bigHead = (lenA > lenB) ? headA : headB;
         smallHead = (bigHead == headA) ? headB : headA;
         // finding diff len
         lenDiff = Math.abs(lenA-lenB);
         // iterating bigger
         while(lenDiff-- > 0) bigHead = bigHead.next;
         // iterating till common is not found
         while(bigHead != smallHead){
             bigHead = bigHead.next;
             smallHead = smallHead.next;
         }
         return bigHead.data;
	}
}
