/**

Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

**/




/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void triplets(int[] arr, int n){
        Arrays.sort(arr);
        int count=0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]==arr[k]) count++;
                }
            }
        }
        if(count!=0) System.out.println(count);
        else System.out.println(-1);
    }
    
    public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int T = scan.nextInt();
      for(int i=0; i<T; i++){
          int N = scan.nextInt();
          int[] arr = new int[N];
          for(int j=0; j<N; j++) arr[j]=scan.nextInt();
          triplets(arr, N);
      }
    }
}
