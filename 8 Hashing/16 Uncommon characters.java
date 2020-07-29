// url- https://practice.geeksforgeeks.org/problems/uncommon-characters/0

/**

Find and print the uncommon characters of the two given strings S1 and S2. Here uncommon character means that either the character is present in one string or it is present in other string but not in both. The strings contains only lowercase characters and can contain duplicates.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two strings in two subsequent lines.

Output:
For each testcase, in a new line, print the uncommon characters of the two given strings in sorted order.

Constraints:
1 <= T <= 100
1 <= |S1|, |S2| <= 105

Example:
Input:
1
characters
alphabets
Output:
bclpr
 
 
 
 
 
 A P P R O A C H --->   STEP1 - Treeset chars of str1  // coz we need answer in sorted form 
                        STEP2 - HashSet chars of str2
                        STEP3 - iterate over HashSet and check if (char present in TreeSet) then remove the char from treeset else (add char to treeset)


**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void unCommon(String str1, String str2){
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();
        Set<Character> st1 = new TreeSet<>();   // sorted set
        Set<Character> st2 = new HashSet<>();   // hashset
        for(char x : ch1) st1.add(x);
        for(char x : ch2) st2.add(x);
        for(Character x : st2){
            if(st1.contains(x)) st1.remove(x);  // if(set1 contains x) remove x from set1
            else st1.add(x);                    // else add x in set1
        }
        for(char x: st1) System.out.print(x);
        System.out.println();
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str1 = (br.readLine()).trim();
		    String str2 = (br.readLine()).trim();
		    unCommon(str1, str2);
		}
	}
}
