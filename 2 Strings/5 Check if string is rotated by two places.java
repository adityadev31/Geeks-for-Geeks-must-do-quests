/**

Given two strings a and b. The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. In the next two line are two string a and b.

Output:
For each test case in a new line print 1 if the string 'a' can be obtained by rotating string 'b' by two places else print 0.

Constraints:
1 <= T <= 50
1 <= length of a, b < 100

Example:
Input:
2
amazon
azonam
geeksforgeeks
geeksgeeksfor

Output:
1
0

Explanation:
Testcase 1: amazon can be rotated anti-clockwise by two places, which will make it as azonam.

Testcase 2: geeksgeeksfor can't be formed by any rotation from the given word geeksforgeeks.

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
		    String s1 = br.readLine();
		    String s2 = br.readLine();
		    
		    int n = s1.length();
		    
		    boolean flag = true;
		    
		    // anticlockwise
		    for(int i=0; i<n; i++){
		        if(s2.charAt(i)!=s1.charAt((i+2)%n)){
		            flag = false;
		            break;
		        }
		    }
		    
		    if(flag == true) System.out.println(1);
		    if(flag == false){
		        
		        flag = true;
    		    // clockwise
    		    for(int i=0; i<n; i++){
    		        if(s1.charAt(i)!=s2.charAt((i+2)%n)){
    		            flag = false;
    		            break;
    		        }
    		    }
    		    
    		    if(flag == true) System.out.println(1);
    		    else System.out.println(0);
		    }
		    
		}
	}
}
