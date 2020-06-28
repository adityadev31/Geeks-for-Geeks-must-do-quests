/**

Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is S.

Output:

Print the minimum number of characters.

Constraints:

1 ≤ T ≤ 50
1 ≤ S ≤ 40

Example:

Input:
3
abcd
aba
geeks

Output:
3
0
3

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    
    /**
        ans = (N - LCS) where N = string length
    
    **/
     
    public static int LCS(String s1, String s2, int n, int[][] store){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    store[i][j] = 1 + store[i-1][j-1];
                else
                    store[i][j] = Math.max(store[i-1][j], store[i][j-1]);
            }
        }
        return store[n][n];
    }
     
    public static void LCS(String s1, String s2, int n){
        int[][] store = new int[n+1][n+1];
        for(int i=0; i<=n; i++) store[i][0] = 0;
        for(int j=0; j<=n; j++) store[0][j] = 0;
        int common = LCS(s1, s2, n, store);
        System.out.println(n-common);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1 = br.readLine().trim();
		    StringBuilder sb = new StringBuilder(s1);
		    String s2 = new String(sb.reverse().toString());
		    LCS(s1, s2, s1.length());
		}
	}
}
