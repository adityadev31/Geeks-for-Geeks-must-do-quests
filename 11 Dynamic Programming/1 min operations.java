/**

You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the minimum number of operations required to reach N from 0.

Constraints:
1<=T<=100
1<=N<=104

Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
    
        step1 = make an int array from 0 - n;
        step2 = fill index= 0 with 0
        step3 = iterate from 1 --> n 
                        - if(n == odd) arr[i] = 1 + arr[i-1]
                        - if(n == even) 1 + min(arr[i-1], arr[i/2])
    
    */
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n+1];
		    arr[0] = 0;
		    for(int i=1; i<=n; i++){
		        if(i%2 != 0) arr[i] = 1 + arr[i-1];
		        else arr[i] = 1 + Math.min(arr[i-1], arr[i/2]);
		    }
		    System.out.println(arr[n]);
		}
	}
}
