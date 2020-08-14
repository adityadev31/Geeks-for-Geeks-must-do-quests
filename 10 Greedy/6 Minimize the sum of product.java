// url - https://practice.geeksforgeeks.org/problems/minimize-the-sum-of-product/0

/**

You are given two arrays, A and B, of equal size N. The task is to find the minimum value of A[0] * B[0] + A[1] * B[1] +…+ A[N-1] * B[N-1], where shuffling of elements of arrays A and B is allowed.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains three lines. The first line contains an integer N denoting the size of the arrays. In the second line are N space separated values of the array A[], and in the last line are N space separated values of the array B[].

Output:
For each test case, print the minimum sum.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[] <= 1018

Example:
Input:
2
3 
3 1 1
6 5 4
5
6 1 9 5 4
3 4 8 2 4
Output:
23 
80

Explanation:
For testcase1: 1*6+1*5+3*4 = 6+5+12 = 23 is the minimum sum
For testcase2: 2*9+3*6+4*5+4*4+8*1 =18+18+20+16+8 = 80 is the minimum sum

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str1[] = br.readLine().trim().split("\\s+");
		    String str2[] = br.readLine().trim().split("\\s+"); 
		    long arr1[] = new long[n];
		    long arr2[] = new long[n];
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(str1[i]);    
		        arr2[i] = Long.parseLong(str2[i]);   
		    }
		    Arrays.sort(arr1);                         // sort arr1
		    Arrays.sort(arr2);                         // sort arr2
		    long sum = 0;
		    for(int i=0; i<n; i++) sum += arr1[i]*arr2[n-i-1];   // multiply small arr1[] to large arr2[]
		    System.out.println(sum);
		}
	}
}
