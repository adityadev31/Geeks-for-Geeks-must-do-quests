/**

Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.



**/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int findMiss(int[] arr, int n){
        Arrays.sort(arr);
        // binary search algo
        int l=0;
        int r=n-1;
        while(l<r){
            int k = (l+r)/2;
            if(k==l){ // for n=2
                k++;
                if(k==arr[k]) return k+1;  // ex -> 0,1 return 2
                else return k;             // ex -> 0,2 return 1
            }
            if(arr[k]!=k && arr[k-1]==k-1) return k; // current not matching but previous is matching hence return k
            if(arr[k]>k) r=k;
            if(arr[k]==k) l=k;
        }
        return -1;
    }
    
    public static void main (String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      while(t-- > 0){
          int n = Integer.parseInt(br.readLine());
          int arr[] = new int[n];

          arr[0]=0;
          int i=1;
          String line = br.readLine();
          for(String str: line.split("\\s")){
          arr[i] = Integer.parseInt(str);
          i++;
        }
        System.out.println(findMiss(arr, n));
      }
    }
}
