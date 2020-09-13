/**


Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.


**/





/*          ALGO

Algorithm :
1. Create a deque to store k elements.
2. Run a loop and insert first k elements in the deque. While inserting the element if the element at the back of the queue is smaller than the current element remove all those elements and then insert the element.
3. Now, run a loop from k to end of the array.
4. Print the front element of the array
5. Remove the element from the front of the queue if they are out of the current window.
6. Insert the next element in the deque. While inserting the element if the element at the back of the queue is smaller than the current element remove all those elements and then insert the element.
7. Print the maximum element of the last window.

*/


import java.util.Deque;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String siz[] = br.readLine().trim().split("\\s+");
		    String str[] = br.readLine().trim().split("\\s+");
		    int n = Integer.parseInt(siz[0]);
		    int k = Integer.parseInt(siz[1]);
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
		    
		    // call function
		    
		    // DeQue must have indices of arrays values in descending order
		    
		    Deque<Integer> dq = new LinkedList<>();
		    StringBuilder sb = new StringBuilder();
		    for(int i=0; i<k; i++){
		        while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) dq.removeLast();
		        dq.addLast(i);
		    }
		    for(int i=k; i<n; i++){
		        sb.append(arr[dq.peekFirst()]+" ");
		        while(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.removeFirst();
		        while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) dq.removeLast();
		        dq.addLast(i);
		    }
		    sb.append(arr[dq.peekFirst()]);
		    System.out.println(sb);
		    
		}
	}
}
