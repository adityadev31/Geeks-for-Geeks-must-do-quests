/**

Given an array of positive integers. The task is to find inversion count of array.

Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains N elements.

Output:
Print the inversion count of array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ C ≤ 1018

Example:
Input:
1
5
2 4 1 3 5

Output:
3

Explanation:
Testcase 1: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

**/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static long inversions;
    
    public static void merge(long arr[], int l, int m, int r){
        
        // calculating inversions
        int p=l, q=m+1;
        while(p<=m && q<=r){
            if(arr[p] > arr[q]){
                inversions += m-p+1;
                q++;
            }
            else p++;
        }
        
        
        // merge sort
        int n1 = m-l+1;
        int n2 = r-m;
        long arr1[] = new long[n1];
        long arr2[] = new long[n2];
        for(int i=0; i<n1; i++){ arr1[i] = arr[i+l]; }
        for(int i=0; i<n2; i++){ arr2[i] = arr[i+m+1]; }
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){ arr[k++]=arr1[i++]; }
            else{ arr[k++]=arr2[j++]; }
        }
        while(i<n1){ arr[k++]=arr1[i++]; }
        while(j<n2){ arr[k++]=arr2[j++]; }
    }
    
    public static void mergeSort(long arr[], int l, int r){
        if(l>=r) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
    
    public static void findInversion(long[] arr, int n){
        mergeSort(arr, 0, n-1);
        long ans = inversions;
        inversions = 0;
        System.out.println(ans);
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
		    findInversion(arr, n);
		}
	}
}








/**

		B E T T E R    W A Y 
		

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class GFG
 {
    public static long count;
    
    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0; i<n1; i++) arr1[i] = arr[i+l];
        for(int j=0; j<n2; j++) arr2[j] = arr[j+m+1];
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]) arr[k++] = arr1[i++];
            else{						// when arr2[j] < arr1[i]  count += n1-i;       i.e. all the elements of arr1 after ith position (including i) will be swapped
                arr[k++] = arr2[j++];
                count += n1-i;
            }
        }
        while(i<n1) arr[k++] = arr1[i++];
        while(j<n2) arr[k++] = arr2[j++];
    }
     
    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
		    // call function
	            mergeSort(arr, 0, n-1);
		    System.out.println(count);
		    count = 0;
		}
	}
}




**/
