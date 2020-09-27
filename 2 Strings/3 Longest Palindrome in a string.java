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



class GFG
 {
    public static String LCS(String s1, String s2, int n, int m, int[][] store){
        int result = Integer.MIN_VALUE, ansi=-1, ansj=-1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){		// if char matches then store + 1 and compare with result
                    store[i][j] = 1 + store[i-1][j-1];
                    if(store[i][j] > result.len){      // resetting result with our new answers if store > result
                        result = store[i][j];
                        ansi = i;
                        ansj = j;
                    }
                }
                else store[i][j]=0;
            }
        }
        
        

	// tracking word
	String answer;
	ansi--;
	while(result-->0) answer += s1.charAt(ansi--);
	if(answer.equals(new StringBuilder(answer).reverse().toString())) System.out.println(answer);
	else System.out.println(s1.charAt(0));
        
    }
     
    public static String LCS(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        int[][] store = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++){ store[i][0]=0; }  // initializing base case
        for(int j=0; j<=n2; j++){ store[0][j]=0; }  // initializing base case
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
