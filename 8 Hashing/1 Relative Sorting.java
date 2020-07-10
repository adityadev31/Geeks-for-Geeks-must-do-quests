/**

Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
Note: Expected time complexity is O(N log(N)).

Input:
First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M  ≤ 106
1 ≤ A1[], A2[] <= 106

Example:
Input:
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
8 4
2 6 7 5 2 6 8 4 
2 6 4 5
Output:
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8

Explanation:
Testcase 1: After sorting the resulted output is 2 2 1 1 8 8 3 5 6 7 9.
Testcase 2: After sorting the resulted output is 2 2 6 6 4 5 7 8.
 


**/




import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    public static void sortRel(int[] arr1, int[] arr2, int m, int n){
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        // hashing arr1[]
        for(int i=0; i<m; i++){
            if(!map1.containsKey(arr1[i])) map1.put(arr1[i], 1);
            else map1.put(arr1[i], map1.get(arr1[i])+1);
        }
        // hashing arr2[]
        for(int i=0; i<n; i++) map2.put(arr2[i], 1);
        
        // matching elements of arr1[] with arr2[] and setting it to -999 and sort
        for(int i=0; i<m; i++){
            if(map2.containsKey(arr1[i])) arr1[i] = -999;
        }
        Arrays.sort(arr1);
        
        // inserting arr2[] elements in arr1[]
        int i = 0;
        int j = 0;
        while(i < n){
            if(!map1.containsKey(arr2[i])){
                i++;
                continue;
            }
            int x = map1.get(arr2[i]);
            if(x == 0) i++;
            else{
                arr1[j] = arr2[i];
                map1.put(arr2[i], x-1);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : arr1) sb.append(p + " ");
        System.out.println(sb);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    String str1[] = br.readLine().trim().split("\\s+");
		    String str2[] = br.readLine().trim().split("\\s+");
		    int m = Integer.parseInt(size[0]);
		    int n = Integer.parseInt(size[1]);
		    int arr1[] = new int[m];
		    int arr2[] = new int[n];
		    for(int i=0; i<m; i++) arr1[i] = Integer.parseInt(str1[i]);  // getting arr1
		    for(int i=0; i<n; i++) arr2[i] = Integer.parseInt(str2[i]);  // getting arr2
		    sortRel(arr1, arr2, m, n);                                   // call function
		}
	}
}
