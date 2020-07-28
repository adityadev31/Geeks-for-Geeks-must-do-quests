// url - https://practice.geeksforgeeks.org/problems/minimum-indexed-character/0


/**

Given a string str and another string patt. Find the character in patt that is present at the minimum index in str. If no character of patt is present in str then print ‘No character present’.

Input:
The first line of input contains an integer T denoting the number of test cases. Then the description of T test cases follow. Each test case contains two strings str and patt respectively.

Output:
Output the character in patt that is present at the minimum index in str. Print "$" (without quotes) if no character of patt is present in str.

Constraints:
1 <= T <= 105
1 <= |str|, |patt| <= 105

Example:
Input:
2
geeksforgeeks
set
adcffaet
onkl

Output:
e
$

Explanation:
Testcase 1: e is the character which is present in given patt "geeksforgeeks" and is first found in str "set".
 

**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    
    
    /**
    
    A P P R O A C H -
    
        -   iterate str and check if that char is present in pattern or not
        -   if no such character found in loop then print "$"
    
    
    **/
    
     
    public static void findPattern(String str, String pat){
        for(int i=0; i<str.length(); i++){
            if(pat.contains(str.substring(i, i+1))){
                System.out.println(str.charAt(i));
                return;
            }
        }
        System.out.println("$");
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = (br.readLine()).trim();
		    String pat = (br.readLine()).trim();
		    findPattern(str, pat);
		}
	}
}
