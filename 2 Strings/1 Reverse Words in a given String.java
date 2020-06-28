/**

Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr


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
		    String str[] = br.readLine().trim().split("\\.");       // splitting when " . " comes
		    StringBuilder sb = new StringBuilder();                 
		    for(int i=str.length-1; i>=0; i--) sb.append(str[i] + ".");  // reverse looping and adding elements with "." at last of every element
		    String ans = new String(sb.toString());                      // converting it to string
		    int len = ans.length();                                
		    System.out.println(ans.substring(0, len-1));                 // removing the last "." and returning the ans
		}
	}
}
