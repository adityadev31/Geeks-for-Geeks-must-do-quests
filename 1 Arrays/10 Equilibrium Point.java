/**

Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

Output:
For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai <= 108

Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3

Explanation:
Testcase 1: Since its the only element hence its the only equilibrium point.
Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).


**/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void equilibrium(int[] arr, int n, int totalSum){
        int leftSum = 0;
        int rightSum = totalSum;
        int i=0;
        while(i<n){
            rightSum -= arr[i];            // (update right) now we have left and right
            if(leftSum == rightSum){
                System.out.println(i+1);
                return;
            }
            leftSum += arr[i];             // (update left)
            i++;
        }
        System.out.println(-1);
    }
    
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    String str[] = br.readLine().trim().split("\\s+");
		    int i=-1;
		    int sum = 0;
		    while(++i<n){
			arr[i]=Integer.parseInt(str[i]);
			sum = sum+arr[i];
		    }
		    equilibrium(arr, n, sum);
		}
	}
}


