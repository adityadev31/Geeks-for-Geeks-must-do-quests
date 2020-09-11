/**

Let's give it a try! You have a linked list and you have to implement the functionalities push and pop of stack using this given linked list.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer Q denoting the number of queries.
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack . 

Your Task:
You are required to complete the two methods push() which take one argument an integer 'x' to be pushed into the stack and pop() which returns a integer poped out from the stack.

Expected Time Complexity: O(1) for both push() and pop().
Expected Auxiliary Space: O(1) for both push() and pop().

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
2
5
1 2 1 3 2 1 4 2
4
2 1 4 1 5 2
Output:
3 4
-1 5

Explanation:
Testcase 1:In the first test case for query 
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4.
Testcase 2: In the second testcase only two pop operations will be performed and Hence, the output will be -1 5.

**/



/*
class StackNode
{
    int data;
    StackNode next;
    StackNode(int a)
    {
       data = a;
       next = null;
    }
}
*/
class MyStack {

    StackNode top;

    void push(int a) {
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }
    int pop() {
        if(top==null) return -1;
        StackNode prev = top;
        top = top.next;
        prev.next = null;
        return prev.data;
    }
}
