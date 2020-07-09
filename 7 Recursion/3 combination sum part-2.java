/**

Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

ach number in A may only be used once in the combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.
   If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 10,1,2,7,6,1,5 and B(sum) 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.
 
Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)

Example:
Input:
2
7
10 1 2 7 6 1 5
8
5
8 1 8 6 8
12

Output:
(1 1 6)(1 2 5)(1 7)(2 6)
Empty

**/






import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static StringBuilder sb;
     
    public static SortedSet<String> ts;
     
    public static void targetSum(int[] arr, int n, int sum, String ans){
        if(sum == 0){       // base case
            String x = ans;
            char[] a = x.toCharArray();   // string --> char array
            Arrays.sort(a);               // sort
            x = "";                       // inserting sorted elements into string x
            for(int i=0; i<a.length-1; i++){
                x += a[i]+" ";
            }
            x = x + a[a.length-1];        // inserting last element separately to avoid extra spaces
            x = "("+x+")";
            ts.add(x);                    // adding to sorted set to remove duplicates
            return;
        }
        if(n == 0) return;
        if(arr[n-1] > sum) targetSum(arr, n-1, sum, ans);                     // not selected (item > sum)
        else{
            targetSum(arr, n-1, sum, ans);                                    // not selected
            targetSum(arr, n-1, sum-arr[n-1], String.valueOf(arr[n-1]+ans));  // selected (sum updated, ans updated)
        }
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");    // getting size
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    int sum = Integer.parseInt(br.readLine());
		    ts = new TreeSet<String>();
		    targetSum(arr, n, sum, "");
		    Iterator<String> it = ts.iterator();
		    if(!it.hasNext()){
		        System.out.println("Empty");
		        continue;
		    }
		    while(it.hasNext()){
		        System.out.print(it.next());
		    }
		    System.out.println();
		}
	}
}
