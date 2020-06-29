/**

Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.
 

Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. Each test case contains a string str.

Output:
For each test case, print a new line containing the resulting string.

Constraints:
1<=T<=100
1<=Length of string<=50

Example:
Input:
2
geeksforgeek
acaaabbbacdddd

Output:
gksforgk
acac

**/





import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static String dupli(String str){
        if(str.length() == 0) return "";
        boolean change = false;         // to keep check for changes
        int l=0, i=1, r=-1, n=str.length();
        String ans = "";               // to store our ans per iteration
        
        while(l < n || i < n){
            if(l < n && i >= n){
                ans += str.charAt(l);     // adding the last l
                break;
            }
            if(str.charAt(l) != str.charAt(i)){ // if (l!=i) -> ans+l -> l++ i++
                ans += str.charAt(l);
                if(i == n-1){
                    ans += str.charAt(i);   // i.e, adding both l and i
                    break;
                }
                l++; i++;
            }
            else{                             // if (l==i) -> r=i -> check for if (r==r+1) r++; 
                r = i;
                while(r+1 < n){
                    if(str.charAt(r) == str.charAt(r+1)) r++;
                    else break;
                }
                change = true;   // changes occur = true
                l = r+1;         // updating l
                i = l+1;         // updating i
            }
        }
        
        if(change) return dupli(ans);
        return ans;
        
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1 = br.readLine().trim();
		    System.out.println(dupli(s1));
		}
	}
}


/**

input - mississipie
output  mpie

coz - 
1st iteration - miiipie
2nd iteration - mpie

**/
