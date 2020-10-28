/**

Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines of input. The first line of each test case consists of an integer N(size of array) and an integer K separated by a space. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each test case, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N, K ≤ 107
1 ≤ A[i] ≤ 1018

Example:
Input
2
5 3
1 2 3 4 5
6 2
10 20 30 40 50 60

Output
3 2 1 5 4
20 10 40 30 60 50

Explanation:
Testcase 1: Reversing groups in size 3, first group consists of elements 1, 2, 3. Reversing this group, we have elements in order as 3, 2, 1.

**/



import java.util.*;

 /*
   
   S L I D I N G.  W I N D O W.  M E T H O D. 
   
   step1 - making a window of len k (left=0 && right=k-1)
   step2 - swap all elements in window
   step3 - move window to the next k (left=right+1 && right=right+k)
   step4 - do above while(right < n)
   step5 - last swapping for the left overs
   
   */

 class Main
 {
   
   public static void swap(int[] arr, int a, int b){
     int temp = arr[a];
     arr[a] = arr[b];
     arr[b] = temp;
   }
   
   
   public static void reverse(int[] arr, int n, int k){
     /*
         w1 = left side of the window
         w2 = left side of the window
         l = left swapper
         r = right swapper
         k = checker
     */
     int w1=0, w2=k-1;
     int l=w1, r=w2;
     
     // main loop
     while(w2 < n){
       while(l < r){
         swap(arr, l, r);
         l++; r--;
       }
       // updating pointers
       w1 = w2+1;
       w2 = w2+k;
       l  = w1;
       r  = w2;
     }
     
     
     // left overs
     if(w1 < n && w2 > n){
       l = w1;
       r = n-1;
       while(l < r){
         swap(arr, l, r);
         l++; r--;
       }
     }
   
     // printing array
     for(r=0; r<n; r++) System.out.print(arr[r]+" ");
   }
   
   
   public static void main(String args[])
   { 
    int[] arr = {1,2,3,4,5};
    int k = 3;
    reverse(arr, arr.length, k);
   }
 }


// Ans = 3 2 1 5 4



/*

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    
    public static void swap(long[] arr, int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] st1 =  br.readLine().trim().split("\\s+");
            String[] st2 =  br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st1[0]);
            int k = Integer.parseInt(st1[1]);
            long arr[] = new long[n];
            for(int i=0; i<n; i++) arr[i] = Long.parseLong(st2[i]);
            //
            int w1=0, w2=k-1;       // setting window
            int l = w1, r = w2;     // setting iterators
            while(w1<n){
                if(r>=n) r=n-1;
                while(l<r){
                    swap(arr, l , r);
                    l++;
                    r--;
                }
                w1 = w2+1;
                w2 = w2+k;
                l = w1;
                r = w2;
            }
            //
            StringBuilder sb = new StringBuilder();
            for(long x: arr) sb.append(x+" ");
            System.out.println(sb);
        }
        
    }
    
}


*/
