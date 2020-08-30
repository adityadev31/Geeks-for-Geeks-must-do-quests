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
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str1 = br.readLine().trim();
		    String str2 = br.readLine().trim();
		    int n = str1.length();
		    int found = 0;
		    
		    // assuming anticlockwise rotated str2
		    for(int i=0; i<n; i++){
		        if(str1.charAt((i+2)%n) != str2.charAt(i)){
		            found = 0;
		            break;
		        }
		        if(i == n-1) found = 1;
		    }
		    
		    
		    // assuming clockwise rotated str2
		    if(found == 0){
		        for(int i=0; i<n; i++){
				if(str1.charAt((n-2+i)%n) != str2.charAt(i)){
				    found = 0;
				    break;
				}
				if(i == n-1) found = 1;
			    }
		    }
		    
		    System.out.println(found);
		}
	}
}
