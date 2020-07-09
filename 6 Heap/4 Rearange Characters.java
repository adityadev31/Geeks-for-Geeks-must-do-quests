/**

Given a string S with repeated characters (only lowercase). The task is to rearrange characters in a string such that no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single line containing a string of lowercase english alphabets.

Output:
For each test case in a new line print "1" (without quotes) if the generated string doesn't contains any same adjacent characters, else if no such string is possible to be made print "0" (without quotes).

Constraints:
1 <= T <= 100
1 <= length of string <= 104

Example:
Input:
3
geeksforgeeks
bbbabaaacd
bbbbb

Output:
1
1
0

Explanation:
Testcase 1: All the repeated characters of the given string can be rearranged so that no adjacent characters in the string is equal.
Testcase 3: Repeated characters in the string cannot be rearranged such that there should not be any adjacent repeated character


**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    public static void solve(char[] str, int n){
        Arrays.sort(str);
        int maxFreq = Integer.MIN_VALUE;
        int current = 0;
        for(int i=0; i<n; i++){
            if(i==0){
                current+=1;
                maxFreq = Math.max(maxFreq, current);
                continue;
            }
            if(str[i] != str[i-1]){ current=0; }
            current+=1;
            maxFreq = Math.max(maxFreq, current);
        }
        if(maxFreq <= (n+1)/2) System.out.println("1");
        else System.out.println("0");
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine().trim();
		    char[] arr = str.toCharArray();
		    solve(arr, arr.length);
		}
	}
}
