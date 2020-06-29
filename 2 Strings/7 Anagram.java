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


 class Main
 {
   public static String isAnagram(String s1, String s2){
     s1 = s1.replaceAll("\\s+", "");   // remove white spaces
     s2 = s2.replaceAll("\\s+", "");   // remove white spaces
     s1 = s1.toUpperCase();            // upper case all 
     s2 = s2.toUpperCase();            // upper case all
     char[] c1 = s1.toCharArray();
     char[] c2 = s2.toCharArray();  
     Arrays.sort(c1);
     Arrays.sort(c2);
     s1 = new String(c1);
     s2 = new String(c2);
     if(s1.equals(s2)) return "Yes";
     else return "No";
   }
   
   public static void main(String args[])
   { 
    String s1 = "    sky is Blue";
    String s2 = " bLUEis  skY";
    System.out.println(isAnagram(s1,s2));
   }
 }

// ans = Yes
