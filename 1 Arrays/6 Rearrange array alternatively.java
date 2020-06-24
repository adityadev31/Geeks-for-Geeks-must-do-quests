/**


Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...

Note: O(1) extra space is allowed. Also, try to modify the input array as required.

Input:
First line of input conatins number of test cases T. First line of test case contain an integer denoting the array size N and second line of test case contain N space separated integers denoting the array elements.

Output:
Output the modified array with alternated elements.

Constraints:
1 <=T<= 100
1 <=N<= 107
1 <=arr[i]<= 107

Example:
Input:
2
6
1 2 3 4 5 6
11 
10 20 30 40 50 60 70 80 90 100 110

Output:
6 1 5 2 4 3
110 10 100 20 90 30 80 40 70 50 60

Explanation:
Testcase 1: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.


**/






import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void reArrange(int[] arr, int n){
        int ans[] = new int[n];
        int i=0, j=n-1, k=0;
        StringBuilder sb = new StringBuilder();
        while(i<j){
            ans[k++] = arr[j--];     // print right
            sb.append(ans[k-1]+" ");
            ans[k++] = arr[i++];     // then print left
            sb.append(ans[k-1]+" ");
        }
        if(i==j){               // middle one
            ans[k] = arr[i];
            sb.append(ans[k]+" ");
        }
        i=0;
        while(i<n){
            arr[i]=ans[i];
            i++;
        }
        System.out.println(sb);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String line[] = br.readLine().trim().split("\\s+");
		    int[] arr = new int[n];
		    int i=0;
		    while(i<n){
		        arr[i] = Integer.parseInt(line[i]);
		        i++;
		    }
		    reArrange(arr, n);
		}
	}
}
