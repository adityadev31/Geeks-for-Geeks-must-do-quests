/**


Given an input stream of n integers, find the kth largest element for each element in the stream.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains two space separated integers k and n . Then in the next line are n space separated values of the array.

Output:
For each test case, in a new line, print the space separated values denoting the kth largest element at each insertion, if the kth largest element at a particular insertion in the stream doesn't exist print -1.

Constraints:
1 <= T <= 100
1 <= K <= n
1 <= n <= 106
1 <= stream[] <= 105

Example:
Input:
2
4 6
1 2 3 4 5 6
1 2
3 4

Output:
-1 -1 -1 1 2 3
3 4 

Explanation:
Testcase1:
k = 4
For 1, the 4th largest element doesn't exist so we print -1.
For 2, the 4th largest element doesn't exist so we print -1.
For 3, the 4th largest element doesn't exist so we print -1.
For 4, the 4th largest element is 1 {1, 2, 3, 4}
For 5, the 4th largest element is 2 {2, 3, 4 ,5}
for 6, the 4th largest element is 3 {3, 4, 5}
 


**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void solve(int[] arr, int n, int k){
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        int i = 0;
        for(i=0; i<k-1; i++){               // printing -1 till k-1
            System.out.print("-1 ");
        }
        for(i=0; i<k; i++){
          mh.add(arr[i]);                   // adding k elements from the array to min heap
        }
    
        for(i=k; i<n; i++){
          System.out.print(mh.peek() + " ");
          if(arr[i] > mh.peek()){               // if current element > minheap's 1st element
            mh.remove();                        // remove first and add current element
            mh.add(arr[i]);
          }
        }
        System.out.print(mh.peek() + " ");
        System.out.println();
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    int k = Integer.parseInt(size[0]);
		    int n = Integer.parseInt(size[1]);
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    solve(arr, n, k);
		}
	}
}
