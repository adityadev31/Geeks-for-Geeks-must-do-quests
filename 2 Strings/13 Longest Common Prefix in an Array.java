/**

Given a array of N strings, find the longest common prefix among all strings present in the array.

Input:
The first line of the input contains an integer T which denotes the number of test cases to follow. Each test case contains an integer N. Next line has space separated N strings.

Output:
Print the longest common prefix as a string in the given array. If no such prefix exists print "-1"(without quotes).

Constraints:
1 <= T <= 103
1 <= N <= 103
1 <= |S| <= 103

Example:
Input:
2
4
geeksforgeeks geeks geek geezer
3
apple ape april

Output:
gee
ap

Explanation:
Testcase 1: Longest common prefix in all the given string is gee.

**/




/**
  
  step 1 - find the length of the smallest string (coz we only need to traverse til the smallest string)
  
  step 2 - String ans = "" will store the resulting string
  
  step 3 - in loop( i=0 -> min
    
              - insert ith char of S[0] in ans 
              - check if other strings contain this char or not (if not then (
                
                - if(i==0) return "-1";
                - else return ans.substring(0,i);
                  
              ))
  )
  
  step 4 - Return ans;
  
  **/



import java.util.*;

 class Main
 {
   public static String LCP(String[] s){
     int min = Integer.MAX_VALUE;
     int n = s.length;
     for(int i=0; i<n; i++){
       if(s[i].length() < min) min = s[i].length();  // step1
     }  
     
     String ans = "";                 // step2
     for(int i=0; i<min; i++){        // step3
       ans += s[0].charAt(i);
       for(int j=1; j<n; j++){
           if(s[j].charAt(i) != s[0].charAt(i)){
             if(i == 0) return "-1";
             return (ans.substring(0,i));  
           }
       }  
     }
     return ans;       // step4
   }
   
  
   public static void main(String args[])
   { 
    String s1 = "apple appear application april";
    String s[] = s1.trim().split("\\s+");
    System.out.println(LCP(s));
   }
 }

