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
     
    public static void sortRel(int[] A1, int[] A2, int m, int n){
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        
        // 1 mapping A1 and set A2
        for(int i=0; i<m; i++){
            if(map.containsKey(A1[i])) map.put(A1[i], map.get(A1[i])+1);
            else map.put(A1[i], 1);
        }
        for(int i=0; i<n; i++) st.add(A2[i]);
        
        // 2 filling -1 to A2 elements in A1    and then   sorting
        for(int i=0; i<m; i++) if(st.contains(A1[i])) A1[i] = -1;
        Arrays.sort(A1);
        
        // 3 filling A2 elements in sorted A1 array
        int k = 0;
        for(int i=0; i<n; i++){
            if(map.containsKey(A2[i])){
                int freq = map.get(A2[i]);
                while(freq-- > 0) A1[k++] = A2[i];
            }
        }
        
        // print
        StringBuilder sb = new StringBuilder();
        for(int x : A1) sb.append(x + " ");
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
