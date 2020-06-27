/**

Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated array elements.

Output:
For each test case, in a new line print the required element. If no such element present in array then print -1.

Constraints:
1 <= T <= 100
3 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
3
4
4 2 5 7
3
11 9 12
6
4 3 2 7 8 9

Output:
5
-1
7
Explanation:
Testcase 1 : Elements on left of 5 are smaller than 5 and on right of it are greater than 5.


**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    /*
        H I N T - suppose arr[i] is the ans then-
                  maxElement before i must be lesser than arr[i] i.e, ( maxBefore[i] <= arr[i] )
                  minElement after  i must be greater than arr[i] i.e,  ( arr[i] <= minAfter[i] )
    
        approach - 
        step1 - make max so far (L --> R) from original array
        step2 - make min so far (R --> L) from original array
        step3 -(maxBefore[i] <= arr[i]) also (arr[i] <= minAfter[i])
    */
     
    public static void solve(int[] arr, int n) {
        
        // max so far (L --> R)  i.e, maximum element from 0 to i-1
        int maxBefore[]  = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] > max) max = arr[i];
            maxBefore[i] = max;
        }
        
        // min so far (*  NOTE -   from L <-- R  *) i.e, minimum from i+1
        int minAfter[]  = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i] < min) min = arr[i];
            minAfter[i] = min;
        }
        
        
        // (maxBefore[i] <= arr[i]) also (arr[i] <= minAfter[i])
        for(int i=1; i<n-1; i++){
            if(maxBefore[i] <= arr[i] && minAfter[i] >= arr[i]){
                System.out.println(arr[i]);          // element found !!
                return;
            }
        }
        System.out.println(-1);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    solve(arr, n);
		}
	}
}
