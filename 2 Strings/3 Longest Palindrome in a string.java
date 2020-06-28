/**

Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).

NOTE: Required Time Complexity O(n2).

Input:
The first line of input consists number of the testcases. The following T lines consist of a string each.

Output:
In each separate line print the longest palindrome of the string given in the respective test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ Str Length ≤ 104

Example:
Input:
1
aaaabbaa

Output:
aabbaa

Explanation:
Testcase 1: The longest palindrome string present in the given string is "aabbaa". 

**/




import java.util.*;
import java.lang.*;
import java.io.*;

/**

     Its actually Longest Common Substring Problem
     Solution in DP

**/


class Result{
    public int len;
    public int i;
    public int j;
    Result(){
        this.len = Integer.MIN_VALUE;
        this.i = -1;
        this.j = -1;
    }
}


class GFG
 {
    public static String LCS(String s1, String s2, int n, int m, int[][] store){
        Result result = new Result();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    store[i][j] = 1 + store[i-1][j-1];
                    if(store[i][j] > result.len){      // resetting result with our new answers
                        result.len = store[i][j];
                        result.i = i;
                        result.j = j;
                    }
                }
                else store[i][j]=0;
            }
        }
        
        if(result.len == 0) return "no match";   // just in case
        
        StringBuilder sb = new StringBuilder();
        
        int i=result.i, j=result.j;
        while(i>=0 && j>=0){
            if(store[i][j]==0) break;
            else{
                sb.append(s1.charAt(i-1));  // i-1 coz store[][] was actually i+1 && j+1
                i--; j--;
            }
        }
        
        String check1 = sb.toString();
        String check2 = sb.reverse().toString();
        if(check1.equals(check2)) return check1;   // checking if check1 == check2
        else return s1.substring(0,1);             // if no then return Ist char of s1
    }
     
    public static String LCS(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        int[][] store = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++){ store[i][0]=0; }
        for(int j=0; j<=n2; j++){ store[0][j]=0; }
        return LCS(s1, s2, n1, n2, store);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1 = br.readLine().trim();
            StringBuilder sb = new StringBuilder();
            sb.append(s1).reverse();
            String s2 = new String(sb.toString());
            System.out.println(LCS(s1, s2));
		}
	}
}
