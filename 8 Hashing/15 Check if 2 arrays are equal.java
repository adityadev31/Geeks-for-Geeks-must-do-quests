// url - https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not/0

/**

Given two arrays A and B of equal size, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains 3 lines of input. The first line contains an integer N denoting the size of the array. The second line contains element of array A[]. The third line contains elements of the array B[].

Output:
For each test case, print 1 if the arrays are equal else print 0.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). 

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[],B[] <= 1018

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15
Output:
1
0

Explanation:
Testcase1:
Input : A[] = {1, 2, 5, 4, 0}; B[] = {2, 4, 5, 0, 1}; Since all the array elements are same. So,
Output : 1
Testcase2:
Input : A[] = {1, 2, 5}; B[] = {2, 4, 15}; Since all the array elements are not same. So,
Output : 0 


**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void isEqual(long[] arr1, long[] arr2, int n){
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(arr1[i])) map.put(arr1[i], 1);
            else map.put(arr1[i], map.get(arr1[i])+1);
        }
        for(int i=0; i<n; i++){
            if(!map.containsKey(arr2[i])){
                System.out.println(0);
                return;
            }
            else{
                if(map.get(arr2[i])==1) map.remove(arr2[i]);
                else map.put(arr2[i], map.get(arr2[i])-1);
            }
        }
        System.out.println(1);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str1[] = (br.readLine()).trim().split("\\s+");
		    String str2[] = (br.readLine()).trim().split("\\s+");
		    long arr1[] = new long[n];
		    long arr2[] = new long[n];
		    for(int i=0; i<n; i++) arr1[i] = Long.parseLong(str1[i]);
		    for(int i=0; i<n; i++) arr2[i] = Long.parseLong(str2[i]);
		    isEqual(arr1, arr2, n);
		}
	}
}
