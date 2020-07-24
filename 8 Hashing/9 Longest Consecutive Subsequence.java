/**

url ->  https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence/0


Given an array arr[] of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Input:
The first line of input contains T, number of test cases. First line of line each test case contains a single integer N.
Next line contains N integer array.

Output:
Print the output of each test case in a seprate line.

Constraints:
1 <= T <= 100
1 <= N <= 105
0 <= a[i] <= 105

Example:
Input:
2
7
2 6 1 9 4 5 3
7
1 9 3 10 4 20 2

Output:
6
4

Explanation:
Testcase 1:  The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.

Testcase2: 1, 2, 3, 4 is the longest consecutive subsequence.

**/


/**
      H I N T --> step1 Hash all the elements.
                  step2 When you have hashed all the elements of array, then you just need to check the number till which arr++ exists in the hash.
**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void solution(int[] arr, int n){
        Set<Integer> st = new HashSet<>();
        int ans = -1;
        for(int i : arr) st.add(i);
        for(int i=0; i<arr.length; i++){
            if(!st.contains(arr[i]-1)){    // means its the first element of a new subsequence
                int x = arr[i], temp = 1;
                while(1==1){
                    if(!st.contains(x+1)){  // contains next element
                        ans = Math.max(ans, temp);
                        break;
                    }
                    else temp++;            // does not contains next element
                    x++;
                }
            }
        }
        System.out.println(ans);
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
		    solution(arr, n);
		}
	}
}
