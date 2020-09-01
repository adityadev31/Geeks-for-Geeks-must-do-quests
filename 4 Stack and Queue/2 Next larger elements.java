/**

Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1 

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.

Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1018
Example:
Input
2
4
1 3 2 4
4
4 3 2 1
Output
3 4 4 -1
-1 -1 -1 -1

Explanation:
Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    /**
    
       initialize ans array with -1 default
    1) push smaller element index in stack
    2) when larger element is detected as compared to top-
        - pop top and insert that element into that popped index until a greater element comes at the top or top becomes empty
        - push the current index to the stack
    3) increment index i
    **/
     
     
    public static void nextLarger(long arr[], int n){
        Stack<Integer> small = new Stack<Integer>();
        long[] ans = new long[n];
        Arrays.fill(ans, -1);
        int i=0; 
        while(i < n){
            if(small.isEmpty()){
                small.push(i);
            }
            else{
                if(arr[small.peek()] < arr[i]){
                    while(!small.isEmpty() && arr[small.peek()]<arr[i]){
                        ans[small.pop()] = arr[i];
                    }
                    small.push(i);
                }
                else{
                    small.push(i);
                }
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        i=0;
        while(i<n){
            sb.append(ans[i] + " ");
            i++;
        }
        System.out.println(sb);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    long arr[] = new long[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Long.parseLong(str[i]);
		    }
		    nextLarger(arr, n);
		}
	}
}







/*
			S A M E    C O D E 

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    long arr[] = new long[n];
		    for(int i=0; i<n; i++) arr[i] = Long.parseLong(str[i]);
		    // code 
		    
		    Stack<Integer> st = new Stack<>();
		    long ans[] = new long[n];
		    Arrays.fill(ans, -1);
		    for(int i=0; i<n; i++){
		        if(st.empty()) st.push(i);
		        else if(!st.empty()){
		            if(arr[st.peek()] >= arr[i]) st.push(i);
		            else{
		                while(!st.empty() && arr[st.peek()]<=arr[i]) ans[st.pop()] = arr[i];
		                st.push(i);
		            }
		        }
		    }
		    
		    StringBuilder sb = new StringBuilder();
		    for(long x : ans) sb.append(x + " ");
		    System.out.println(sb);
		}
	}
}





*/
