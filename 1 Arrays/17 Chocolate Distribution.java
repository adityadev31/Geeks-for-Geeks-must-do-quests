/**

Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting the number of packets. Then next line contains N space separated values of the array A denoting the values of each packet. The third line of each test case contains an integer m denoting the no of students.

Output:
For each test case in a new line print the minimum difference.

Constraints:
1 <= T <= 100
1 <=N<= 107
1 <= Ai <= 1018
1 <= M <= N

Example:
Input:
2
8
3 4 1 9 56 7 9 12
5
7
7 3 2 4 9 12 56
3

Output:
6
2

Explanation:
Testcase 1: The minimum difference between maximum chocolates and minimum chocolates is 9-3=6


**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    
    /**
        W I N D O W  S L I D I N G  M E T H O D
        
        step1 = sort the array (length = n)
        step2 = set i=0, j=m-1, min=min_long
        step3 = while(j<n) -> if(diff btw j and i < min) set min = diff  --> updation(i++, j++)
        step4 = return min
        
    **/ 
    
     
    public static void chocolate(long[] arr, int n, int m){
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int i = 0;
        int j = m-1;
        while(j<n){
            if((arr[j] - arr[i]) < min){
                min = arr[j] - arr[i];
            }
            i++;
            j++;
        }
        System.out.println(min);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());                // T
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());            // N
		    String str[] = br.readLine().trim().split("\\s+");
		    long arr[] = new long[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Long.parseLong(str[i]);                // Arr (long)
		    }
		    int m = Integer.parseInt(br.readLine());            // M
		    chocolate(arr, n, m);
		}
	}
}










/* ====== WINDOW SLIDING ========*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(br.readLine().trim());
            long[] arr = new long[n];
            for(int i=0; i<n; i++) arr[i] = Long.parseLong(str[i]);
            //
            Arrays.sort(arr);
            int w1=0, w2=m-1;
            long min=Long.MAX_VALUE, temp=-1;
            for(int i=m-1; i<n; i++){
                temp = arr[i] - arr[i-m+1];
                if(temp < min) min = temp;
            }
            //                    
            System.out.println(min);
        }
    }
    
}
