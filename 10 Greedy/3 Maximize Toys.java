// url - https://practice.geeksforgeeks.org/problems/maximize-toys/0

/**

Given an array consisting cost of toys. Given an integer K depicting the amount with you. Maximise the number of toys you can have with K amount.

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the number of toys and an integer K depicting the value of K.
Next line is followed by the cost of toys.


Output:

Print the maximum toys in separate line.


Constraints:

1 ≤ T ≤ 30
1 ≤ N ≤ 1000
1 ≤ K ≤ 10000
1 ≤ A[i] ≤ 10000


Example:

Input
1
7 50
1 12 5 111 200 1000 10
Output
4

**/


/**

A P P R O A C H - 

step1 - sort the array
step2 - keep picking and counting the smallest ones till the sufficient amount is left

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
		    String siz[] = br.readLine().trim().split("\\s+");
		    String str[] = br.readLine().trim().split("\\s+");
		    int n = Integer.parseInt(siz[0]), k = Integer.parseInt(siz[1]);
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
		    Arrays.sort(arr);
		    int count = 0;
		    for(int i=0; i<n; i++){
		        if(arr[i]<=k){
		            count++;
		            k -= arr[i];
		        }
		    }
		    System.out.println(count);
		}
	}
}

