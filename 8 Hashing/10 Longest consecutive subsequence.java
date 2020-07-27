// url -  https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence/0

/**


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






A P P R O A C H -->  hint
                -->  1. Rather than checking in a brute force way, try using hashing. Hash all the elements.
                -->  2. When you have hashed all the elements of array, then you just need to check the number till which arr++ exists in the hash.



**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /**
    
    step1  -  inset into set;
    step2  -  iterate array and check whether its prev num is present in set or not
                    - if(present) -->  its not the starting of the subarray
                    - if(not)     -->  its the starting of the subarray
    step3  -  if(its start point) check for the presence of arr[i]+1 till the end and keep comparing with max len
    step4  - return max len
    
    **/
     
    public static void subArray(int[] arr, int n){
        
        // step1
        Set<Integer> st = new HashSet<>();
        for(int x : arr) st.add(x);
        
        // step2
        int maxLen=Integer.MIN_VALUE, currentLen=0;
        for(int i=0; i<n; i++){
            if(st.contains(arr[i]-1)){   // --> not start point (continue)
                continue;
            }
            else{                       // --> starting point
                currentLen = 0;
                int k = arr[i];
                while(st.contains(k)){  // --> step 3
                    currentLen++;
                    k++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        
        System.out.println(maxLen);
        
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
		    subArray(arr, n);
		}
	}
}
