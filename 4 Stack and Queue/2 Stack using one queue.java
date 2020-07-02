/**

mplement a Stack using two queues q1 and q2.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
First line of each test case contains an integer Q denoting the number of queries . 
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the stack)
(ii) 2     (a query of this type means to pop element from stack and print the poped element)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out from the stack.

Your Task:
Since this is a function problem, you don't need to take inputs. You are required to complete the two methods push() which takes an integer 'x' as input denoting the element to be pushed into the stack and pop() which returns the integer poped out from the stack.

Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
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
1 2 2 2 1 3
Output:
3 4
2 -1

Explanation:
Testcase1:
1 2    the stack will be {2}
1 3    the stack will be {2 3}
2       poped element will be 3 the stack will be {2}
1 4    the stack will be {2 4}
2       poped element will be 4  
Testcase 2: 
1 2 the stack will be {2}
2    poped element will be 2
2    the stack is empty hence -1
1 3 the stack will be {3}.

**/


class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();  // using only q1 for both push and pop
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
	    if(q1.isEmpty()) return -1;
	    else{
	        int s = q1.size();   // 1 2 3 4 5 
	        int i=0;
	        while(++i < s){
	            q1.add(q1.poll());
	        }
	        return q1.poll();
	    }
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    q1.add(a);
    }
}

