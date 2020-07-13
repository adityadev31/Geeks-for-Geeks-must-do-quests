/**

Given two strings X and Y. The task is to find the length of the longest common substring.

Input:
First line of the input contains number of test cases T. Each test case consist of three lines, first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. The next two lines contains the string X and Y.

Output:
For each test case print the length of longest  common substring of the two strings .

Constraints:
1 <= T <= 200
1 <= N, M <= 100

Example:
Input:
2
6 6
ABCDGH
ACDGHR
3 2
ABC
AC

Output:
4
1

Example:
Testcase 1: CDGH is the longest substring present in both of the strings.

**/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static int LCS(String s1, String s2, int n, int m, int[][] store){
        int result = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    store[i][j] = 1 + store[i-1][j-1];
                    result = Math.max(store[i][j], result);
                }
                else store[i][j] = 0;
            }
        }return result;
    }
     
    public static int LCS(String s1, String s2, int n1, int n2){
        int[][] store = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++) store[i][0]=0;
        for(int j=0; j<=n2; j++) store[0][j]=0;
        return LCS(s1, s2, n1, n2, store);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    int n1 = Integer.parseInt(size[0]);
		    int n2 = Integer.parseInt(size[1]);
		    String s1 = br.readLine().trim();
		    String s2 = br.readLine().trim();
		    
		    System.out.println(LCS(s1, s2, n1, n2));
		}
	}
}
