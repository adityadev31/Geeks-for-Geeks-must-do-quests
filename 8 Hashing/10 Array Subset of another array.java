// url -> https://practice.geeksforgeeks.org/problems/array-subset-of-another-array/0

/**

Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n. Task is to check whether arr2[] is a subset of arr1[] or not. Both the arrays can be both unsorted or sorted. It may be assumed that elements in both array are distinct.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an two integers m and n denoting the size of arr1 and arr2 respectively. The following two lines contains the space separated elements of arr1 and arr2 respectively.

Output:
Print "Yes"(without quotes) if arr2 is subset of arr1.
Print "No"(without quotes) if arr2 is not subset of arr1.

Constraints:
1 <= T <= 100
1 <= m,n <= 105
1 <= arr1[i], arr2[j] <= 105

Example:
Input:
3
6 4
11 1 13 21 3 7
11 3 7 1
6 3
1 2 3 4 5 6
1 2 4
5 3
10 5 2 23 19
19 5 3

Output:
Yes
Yes
No

Explanation:
Testcase 1: (11, 3, 7, 1) is a subset of first array.

**/



/**

A P P R O A C H -  

step1 - if(n1 < n2 ) return NO
step2 - put arr1 in a set (since distinct)
step3 - if(arr2[i] not present in set) --> return No   else continue the loop
step4 - after loop return Yes (loop ended successfully i.e, all arr2 ele are present in arr1)

**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void isSubset(int[] arr1, int[] arr2, int n1, int n2){
        
        if(n1 < n2){
            System.out.println("No");
            return;
        }
                                              // using set to check whether arr1 has the element of arr2 or not
        Set<Integer> st = new HashSet<>();
        for(int x : arr1) st.add(x);          // adding arr1 to set
        for(int y : arr2){                    // checking arr2 ele in set
            if(!st.contains(y)){
                System.out.println("No");     // not found --> return No
                return;
            }
        }
        System.out.println("Yes");            // found return --> Yes
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt((br.readLine()).trim());
		while(t-->0){
		    String[] size = (br.readLine()).trim().split("\\s+");
		    int n1 = Integer.parseInt(size[0]);
		    int n2 = Integer.parseInt(size[1]);
		    String str1[] = (br.readLine()).trim().split("\\s+");
		    String str2[] = (br.readLine()).trim().split("\\s+");
		    int arr1[] = new int[n1];
		    int arr2[] = new int[n2];
		    for(int i=0; i<n1; i++) arr1[i] = Integer.parseInt(str1[i]);
		    for(int i=0; i<n2; i++) arr2[i] = Integer.parseInt(str2[i]);
		    isSubset(arr1, arr2, n1, n2);
	    }
	}
}
