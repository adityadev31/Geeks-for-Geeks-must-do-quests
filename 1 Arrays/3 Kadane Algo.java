/**

question - 

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

**/




import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int kadane(int[] arr, int n){
        int globalSum = arr[0];
        int localSum = arr[0];
        for(int i=1; i<n; i++){
            localSum = Math.max(arr[i], localSum+arr[i]);
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }
    
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            
            String line = br.readLine();
            int i = 0;
            for (String numStr: line.split("\\s")){
                a[i] = Integer.parseInt(numStr);
                i++;
            }
            System.out.println(kadane(a, n));
        }
	}
}
