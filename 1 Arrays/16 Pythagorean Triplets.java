/**


Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Input:
The first line contains T, denoting the number of testcases. Then follows description of testcases. Each case begins with a single positive integer N denoting the size of array. The second line contains the N space separated positive integers denoting the elements of array A.

Output:
For each testcase, print "Yes" or  "No" whether it is Pythagorean Triplet or not (without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[i] <= 1000

Example:
Input:
1
5
3 2 4 6 5

Output:
Yes

Explanation:
Testcase 1: a=3, b=4, and c=5 forms a pythagorean triplet, so we print "Yes"



**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /** using 2 pointer method in sorted array ( i=0, j=n-2, p=n-1 --> 
    
        if(i+j > p) j--
        if(i+j < p) i++
        if(i+j == p) break;
        
    ) **/
     
    public static void triplets(int[] arr, int n){
        Arrays.sort(arr);                               // 2 3 4 5 6
        int p = n-1;          // pivot
        int i = 0, j = p-1;
        boolean flag = false;
        while(p>=2){
            if(i<j){
                if(((arr[i]*arr[i]) + (arr[j]*arr[j])) == (arr[p]*arr[p])){                  // arr[i]^2 + arr[j]^2 == arr[p]  -->  "Yes"
                System.out.println("Yes");
                return;
                }
                else if(((arr[i]*arr[i]) + (arr[j]*arr[j])) > (arr[p]*arr[p])){ j--; }       // arr[i]^2 + arr[j]^2 > arr[p]  -->  reduce higher digit (i.e, j--)
                else i++;                                                                    // arr[i]^2 + arr[j]^2 < arr[p]  -->  increase lower digit (i.e, i++)
            }
            else{
                p--;
                j = p-1;
                i = 0;
            }
        }
        System.out.println("No");
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
		    triplets(arr, n);
		}
	}
}







/*======== USING HASHING =========*/

/*

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        
        int maxEle = -1;
        
        // finding max element
        for(int x: arr) if(maxEle < x) maxEle = x;
        
        // to get all the elements as indexes (note there will be no 0 as ele in arr hence maxEle+1)
        int[] hash = new int[maxEle+1]; 
        
        // inserting no.of counts in hash of index as elements
        for(int x: arr) hash[x]++;  
        
        // looping
        for(int i=1; i<=maxEle; i++){
            
            if(hash[i] == 0) continue; // as count = 0 ==> element not present in arr[]
            
            for(int j=1; j<=maxEle; j++){
                if((i == j && hash[i] == 1) || (hash[j] == 0)) continue; // either 1 element or zero
                int mul = (int)Math.sqrt((i*i)+(j*j));
                if(mul*mul != i*i+j*j) continue;        // if not perfect square
                if(mul > maxEle) continue;              // if out of range
                if(hash[mul] >= 1) return true;         // found
            }
        }
        return false;
    }
}

*/
