/**

Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the first linked list and next line contains N elements of the linked list. Again, the next line contains M, and the following line contains M elements of the linked list.

Output:
Output the resultant linked list.

User Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the new list.

Expected Time Complexity: O(N) + O(M)
Expected Auxiliary Space: O(N) + O(M)

Constraints:
1 <= T <= 100
1 <= N, M <= 5000

Example:
Input:
2
2
4 5
3
3 4 5
2
6 3
1
7
Output:
3 9 0  
7 0

Explanation:
Testcase 1: For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
Testcase 2: For the given two linked list (6 3) and (7), after adding the two linked list resultant linked list will be (7 0).

**/



class Solution{
    
    static Node createNode(int data){
        Node temp = new Node(data);
        return temp;
    }
    
    static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node head2 = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head2;
    }
    
    static Node addLists(Node first, Node second){
        
        // reversing lists
        first = reverse(first);
        second = reverse(second);
        
        int sum = first.data + second.data;   // calculating for the first time
        int data = sum % 10;
        int carry = sum/10;
        
        // initialize
        Node newHead = createNode(data);
        Node tail = newHead;
        first = first.next;
        second = second.next;
        
        // adding till one list ends
        while(first != null && second != null){    // we have carry first and second
            sum = first.data + second.data + carry;
            data = sum % 10;
            carry = sum / 10;
            tail.next = createNode(data);
            tail = tail.next;
            first = first.next;
            second = second.next;
        }
        
        // adding left overs
        while(first != null){
            sum = first.data + carry;
            data = sum % 10;
            carry = sum / 10;
            tail.next = createNode(data);
            tail = tail.next;
            first = first.next;
        }
        
        // adding left overs
        while(second != null){
            sum = second.data + carry;
            data = sum % 10;
            carry = sum / 10;
            tail.next = createNode(data);
            tail = tail.next;
            second = second.next;
        }
        
        // adding carrys leftovers
        while(carry != 0){
            sum = carry;
            data = sum % 10;
            carry = sum / 10;
            tail.next = createNode(data);
            tail = tail.next;
        }
        
        // returning final reverse
        return reverse(newHead);
    }
}
