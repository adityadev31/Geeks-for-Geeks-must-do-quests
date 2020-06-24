/**

Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
        
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.

**/




import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void merge(int[] arr1, int[] arr2, int n1, int n2){
        int i=n1-1, j=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j<n2){     // swapping biggest of arr1 with smallest of arr2 -> to make arr1 smaller
            if(arr1[i]>arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;  // biggest of arr1
            j++;  // smallest of arr2
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        i=0; j=0;
        while(i<n1){
            sb.append(arr1[i]+" ");
            i++;
        }
        while(j<n2){
            sb.append(arr2[j]+" ");
            j++;
        }
        System.out.println(sb);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String size[] = br.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(size[0]);
            int n2 = Integer.parseInt(size[1]);
            int arr1[] = new int[n1];
            int arr2[] = new int[n2];
            String line1[] = br.readLine().trim().split("\\s+");
            String line2[] = br.readLine().trim().split("\\s+");
            for(int i=0; i<n1; i++) arr1[i]=Integer.parseInt(line1[i]);
            for(int i=0; i<n2; i++) arr2[i]=Integer.parseInt(line2[i]);
            merge(arr1, arr2, n1, n2);
        }
    }
}



