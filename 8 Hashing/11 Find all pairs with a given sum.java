// url - https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0


/**

Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 3 lines . The first line contains 3 space separated integers N, M, X. Then in the next two lines are space separated values of the array A and B respectively.

Output:
For each test case in a new line print the sorted space separated values of all the pairs u,v where u belongs to array A and v belongs to array B, such that each pair is separated from the other by a ',' without quotes also add a space after the ',' . If no such pair exist print -1.

Constraints:
1 <= T <= 100
1 <= N, M, X <= 106
-106 <= A, B <= 106

Example:
Input:
2
5 5 9
1 2 4 5 7
5 6 3 4 8
2 2 3
0 2
1 3
Output:
1 8, 4 5, 5 4
0 3, 2 1

Explanation:
Testcase 1: (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.


**/



/**

A P P R O A C H ---

    step1 - hash all the elements of arr2
    step2 - sort arr1
    step3 - iterate over arr1 and check if(target - arr1[i]) is present in hash or not
                - if present add it to ans
                - else continue
    step4 - if(no ans) found print(-1)
          - else print(ans)   Note - keep commas in mind

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void findPairs(int[] arr1, int[] arr2, int n, int m, int k){
        Set<Integer> st = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int x : arr2) st.add(x);
        Arrays.sort(arr1);
        for(int x : arr1){
            if(st.contains(k-x)){
                sb.append(String.valueOf(x) + " " + String.valueOf(k-x) + ", ");
            }
        }
        int sz = sb.length();
        if(sz == 0) System.out.println(-1);
        else System.out.println(sb.delete(sz-2, sz));
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    String str1[] = br.readLine().trim().split("\\s+");
		    String str2[] = br.readLine().trim().split("\\s+");
		    int n = Integer.parseInt(size[0]);
		    int m = Integer.parseInt(size[1]);
		    int k = Integer.parseInt(size[2]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(str1[i]);
		    for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(str2[i]);
		    findPairs(arr1, arr2, n, m, k);
		}
	}
}
