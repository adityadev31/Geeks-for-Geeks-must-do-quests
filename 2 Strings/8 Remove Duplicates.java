/**

Given a string, the task is to remove duplicates from it. Expected time complexity O(n) where n is length of input string and extra space O(1) under the assumption that there are total 256 possible characters in a string.

Note: that original order of characters must be kept same. 

Input:
First line of the input is the number of test cases T. And first line of test case contains a string.

Output: 
Modified string without duplicates and same order of characters.

Constraints: 
1 <= T <= 15
1 <= |string|<= 1000

Example:
Input:
2
geeksforgeeks
geeks for geeks

Output:
geksfor
geks for

**/



// B E T T E R   W A Y 

class Solution {
    String removeDups(String S) {
        boolean visited[] = new boolean[26];
        int n = S.length();
        S = S.toLowerCase();
        int x;
        String ans = "";
        for(int i=0; i<n; i++){
            x = S.charAt(i)-97;
            if(!visited[x]){
                ans += S.charAt(i);
                visited[x] = true;
            }
        }
        return ans;
    }
}




/**     

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
   
     // USING C O N T A I N S METHOD OF STRING
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s = br.readLine().trim();
		    String ans = "";
		    for(int i=0; i<s.length(); i++){
		        if(!ans.contains(String.valueOf(s.charAt(i)))){
		            ans += s.charAt(i);
		        }
		    }
		    System.out.println(ans);
		}
	}
}

**/
