/**

Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

Output: 
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.



**/





import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void sortArray(int[] arr, int n){
        int sorted[] = new int[n];                     // setting default value = 1
        int i=0, j=n-1, p=0, q=n-1;
        Arrays.fill(sorted, 1);
        while(i<j){                                    // fitting all 0s at left && 2s at right
            if(arr[i]==0) sorted[p++]=arr[i];
            if(arr[j]==0) sorted[p++]=arr[j];
            if(arr[i]==2) sorted[q--]=arr[i];
            if(arr[j]==2) sorted[q--]=arr[j];
            i++; j--;
        }
        if(i==j){
            if(arr[i]==0) sorted[p++]=arr[i];
            if(arr[i]==2) sorted[q--]=arr[i];
        }
        i=0;
        StringBuilder sb = new StringBuilder();
        while(i<n) sb.append(sorted[i++] + " ");
        System.out.println(sb);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    String str[] = br.readLine().trim().split("\\s+");
		    int i=-1;
		    while(++i<n) arr[i]=Integer.parseInt(str[i]);
		    sortArray(arr, n);
		}
	}
}
