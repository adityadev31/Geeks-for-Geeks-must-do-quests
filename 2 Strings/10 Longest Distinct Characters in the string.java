/**

Given a string S, find length of the longest substring with all distinct characters.  For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is String str.

Output:
Print length of smallest substring with maximum number of distinct characters.
Note: The output substring should have all distinct characters.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of str ≤ 10000

Example:
Input:
2
abababcdefababcdab
geeksforgeeks

Output:
6
7

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s = br.readLine().trim();
		    String ans = "";                    // to store resulting string
		    int max = Integer.MIN_VALUE;        // to store max value
		    int i=0, l=0, n=s.length();
		    
		    while(i < n){
		        if(!ans.contains(s.substring(i, i+1))){   // if char is not already present in ans
		            ans += s.charAt(i);
		            if(ans.length() > max) max = ans.length(); // updating max if max < ans len
		            i++;
		        }
		        else{       // if char is already present
		            int idx = s.indexOf(s.charAt(i), l);   // index of char in s from index l
		            i = idx+1;                           // again stating from i = idx+1
		            l = i;                               // updating l = idx+1
		            ans = "";
		        }
		    }
		    
		    System.out.println(max);
		}
	}
}
