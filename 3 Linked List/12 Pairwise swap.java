/**

Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the linked list and the next line contains linked list data.

Output:
Output the linked list after swapping pairwise nodes.

User Task:
The task is to complete the function pairWiseSwap() which takes the head node as the only argument and returns the modified head.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
1
8
1 2 2 4 5 6 7 8

Output:
2 1 4 2 6 5 8 7

Explanation:
Testcase 1: After swapping each pair considering (1,2), (2, 4), (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as a new linked list.

**/


class Solution {
    
    public void reverseK(Node head, int k){
        if(k == 1 || head.next == null) return;
        reverseK(head.next, k-1);
        head.next.next = head;
        head.next = null;
        return;
    }
    
    public Node pairwiseSwap(Node head)
    {
        Stack<Node> low = new Stack<Node>();
        Stack<Node> low1 = new Stack<Node>();
        Stack<Node> high = new Stack<Node>();
        
        int i=1, k=2;
        Node trav = head;
        while(trav != null){
            if(i==1){
                low.push(trav);
                low1.push(trav);
            }
            if(i==k || trav.next == null){
                high.push(trav);
                i=0;
            }
            i++;
            trav = trav.next;
        }
        
        while(!low1.isEmpty()) reverseK(low1.pop(), k);
        
        low.pop();
        while(!low.isEmpty()) low.pop().next = high.pop();
        
        return high.pop();
    }
}
