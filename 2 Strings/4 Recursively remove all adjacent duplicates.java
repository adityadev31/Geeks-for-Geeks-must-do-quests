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













/**


			2 nd    w a y
			




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void dupli(String str, int n, StringBuilder sb){
        boolean charged = false;
        for(int i=0; i<n; i++){
            if(sb.length() > 0){
                if(sb.charAt(sb.length()-1) == str.charAt(i)) charged = true;     // if current str.char == last element of sb ---> make charged activated and don't insert that element
                else{
                    if(charged){                                                  // if element doesn't match (but charge is active) remove the last element of sb and add the new one
                        sb.delete(sb.length()-1, sb.length());
                        charged = false;
                    }
                    sb.append(str.charAt(i));                                     // no match, no charge --> add new element to sb
                }
            }
            else sb.append(str.charAt(i));                                        // if nothing inside sb --> insert the new element 
        }
        if(charged && sb.length()>0) sb.delete(sb.length()-1, sb.length());       // left over if charge is active 
        if(sb.length() == str.length()){					  // if even after operations we have str == sb --> we are done 
            System.out.println(sb);
            return;
        }
        else dupli(sb.toString(), sb.length(), new StringBuilder());              // else do it again!!
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine().trim();
		    dupli(str, str.length(), new StringBuilder());
		}
	}
}


**/
