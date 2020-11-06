/**

Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.
Note: It is strongly recommended to do merging in-place using O(1) extra space.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains N and M, and next two line contains N and M sorted elements in two lines for each.

Output:
For each testcase, print the merged list in sorted form.

User Task:
The task is to complete the function sortedMerge() which takes references to the heads of two linked lists as the arguments and returns the head of merged linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 100
1 <= N, M <= 104
1 <= Node's data <= 105

Example:
Input:
2
4 3
5 10 15 40 
2 3 20
2 2
1 1
2 4 
Output:
2 3 5 10 15 20 40
1 1 2 4

Explanation:
Testcase 1: After merging the two linked lists, we have merged list as 2, 3, 5, 10, 15, 20, 40.
Testcase 2: After merging the given two linked list , we have 1, 1, 2, 4 as output.

**/









/*  ================ U S I N G   R E C U R S I O N    ( B E T T E R )  =================== */

class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
     if(headA == null) return headB;            // base case
     if(headB == null) return headA;            // base case
     if(headA.data < headB.data){               // case-1
         headA.next = sortedMerge(headA.next, headB);  // recursive call
         return headA;
     }
     else{                                      // case-2
         headB.next = sortedMerge(headA, headB.next);   // recursive call
         return headB;
     }
   } 
}













/* ========================= U S I N G   D U M M Y   P O I N T E R S  ============================== */


class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
     Node newHead = headA;
     Node tail = headA;
     Node t1 = headA;
     Node t2 = headB;
     
     // setting initial pointers
     
     if(headA.data < headB.data){
         newHead = headA;
         tail = headA;
         t1 = t1.next;
     }else{
         newHead = headB;
         tail = headB;
         t2 = t2.next;
     }
     
     // checking and iterating
     while(t1 != null && t2 != null){
         if(t1.data < t2.data){
             tail.next = t1;
             tail = t1;
             t1 = t1.next;
         }else{
             tail.next = t2;
             tail = t2;
             t2 = t2.next;
         }
     }
     
     // connecting the remains
     while(t1 != null){
         tail.next = t1;
         tail = t1;
         t1 = t1.next;
     }
     while(t2 != null){
         tail.next = t2;
         tail = t2;
         t2 = t2.next;
     }
     
    return newHead;
   } 
}
