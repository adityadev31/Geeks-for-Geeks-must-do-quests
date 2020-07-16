/**

Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

Input:
The first line of input contains an integer T denoting the number of test cases. The T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains the n space separated integers forming the array. The last line contains the value of k.

Output:
Print "True" (without quotes) if given array can be divided into pairs such that sum of every pair is divisible by k or else "False" (without quotes).

Constraints:
1<=T<=100
2<=n<=10^5
1<=a[i]<=10^5
1<=k<=10^5

Example:
Input:
2
4
9 7 5 3
6
4
91 74 66 48
10

Output:
True
False

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void hasPair(int[] arr, int n, int k){
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // setting map with all possible remainders with value = 0 by default
        for(int i=0; i<k; i++) map.put(i, 0);
        
        // mapping freq of remainders of ele with k in arr[]
        for(int x : arr){
            int rem = x % k;
            map.put(rem, map.get(rem)+1);
        }
        
        // iterate over map and check if all the num and conjugate of num has same value (i.e, valOfnum == valOf(k-num)) i.e, pairs have same freq
        for(int i=0; i<k; i++){
            
            if(i == 0 || i == k-i){        // special cases
                if(map.get(i)%2 != 0){
                    System.out.println("False");
                    return;
                }
                else continue;
            }
            
            int x = map.get(i);           // normal cases
            int y = map.get(k-i);
            if(x != y){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String str[] = br.readLine().trim().split("\\s+");
		    int k = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    hasPair(arr, n, k);
		}
	}
}
