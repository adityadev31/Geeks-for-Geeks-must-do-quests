/**

Given a string S consisting only '0's and '1's,  print the last index of the '1' present in it.

Input:
First line of the input contains the number of test cases T, T lines follow each containing a stream of characters.

Output:
Corresponding to every test case, output the last index of 1. If 1 is not present, print "-1" (without quotes).

Constraints:
1 <= T <= 110
1 <= |S| <= 106

Example:
Input:
2
00001
0
Output:
4
-1

Explanation:
Testcase 1: Last index of  1 in given string is 4.
Testcase 2: Since, 1 is not present, so output is -1.


**/




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    public static void find1(String str){
        int n = str.length();
        for(int i=n-1; i>=0; i--){
            if(str.charAt(i)=='1'){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine();
		    find1(str);
		}
	}
}
