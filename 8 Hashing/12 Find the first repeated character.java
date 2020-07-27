// url - https://practice.geeksforgeeks.org/problems/find-first-repeated-character/0

/**

Given a string S. The task is to find the first repeated character in it. We need to find the character that occurs more than once and whose index of second occurrence is smallest. S contains only lowercase letters.
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case in a new line print the first repeating character in the string. If no such character exist print -1.

Constraints:
1 <= T <= 100
1 <= |S| <=104

Example:
Input:
2
geeksforgeeks
hellogeeks

Output:
e
l

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void firstOccur(String str){
        Set<Character> st = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            if(st.contains(str.charAt(i))){
                System.out.println(str.charAt(i));    // first occurance --> print and return
                return;
            }
            else st.add(str.charAt(i));               // add to the set
        }
        System.out.println(-1);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine();
		    firstOccur(str);
		}
	}
}
