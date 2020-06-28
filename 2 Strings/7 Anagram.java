/**

Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “act” and “tac” are anagram of each other.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, in a single line.

Output:
Print "YES" without quotes if the two strings are anagram else print "NO".

Constraints:
1 ≤ T ≤ 300
1 ≤ |s| ≤ 106

Example:
Input:
2
geeksforgeeks forgeeksgeeks
allergy allergic

Output:
YES
NO

Explanation:
Testcase 1: Both the string have same characters with same frequency. So, both are anagrams.
Testcase 2: Characters in both the strings are not same, so they are not anagrams.

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
		    String str[] = br.readLine().trim().split("\\s+");
		    String s1 = str[0];
		    String s2 = str[1];
		    
		    int n1 = s1.length(), n2 = s2.length();
		    if(n1!=n2){
		        System.out.println("NO");
		        continue;
		    }
		    else{
		        
		        char[] c1 = s1.toCharArray();
		        char[] c2 = s2.toCharArray();
		        Arrays.sort(c1);
		        Arrays.sort(c2);
		        int flag = 1;
		        for(int i=0; i<n1; i++){
		            if(c1[i] != c2[i]){
		                System.out.println("NO");
		                flag = -1;
		                break;
		            }
		        }
		        if(flag == 1){
		            System.out.println("YES");
		        }
		    }
		    
		}
	}
}
