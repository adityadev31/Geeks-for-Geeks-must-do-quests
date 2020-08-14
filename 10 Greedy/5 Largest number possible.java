// url - https://practice.geeksforgeeks.org/problems/largest-number-possible/0

/**

Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains two space separated integers N and S, where N is the number of digits and S is the sum.

Output:
Print the largest number that is possible.If their is no such number, then print -1 

Constraints:
1 <= T <= 30
1 <= N <= 50
0 <= S <= 500

Example: 
Input:
2
2 9
3 20
Output: 
90
992 

Expected Time Complexity: O(n)

**/


/**

A P P R O A C H - 

input --> digits and sum

step1 - exceptions* if(maxPossible sum < req sum  || (sum = 0 and digits > 1)) --> print(-1) continue;
step2 - for(i=0; i<digits; i++){
            
            if(sum >= 9) --> sb.append(9)   and sum -= 9
            else         --> sb.append(sum) and sum  = 0
        }

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
		    String siz[] = br.readLine().trim().split("\\s+");
		    int dig = Integer.parseInt(siz[0]), sum = Integer.parseInt(siz[1]);
		    
		    if(9*dig < sum || (sum == 0 && dig != 1)){    // exceptional  cases (req sum > max possible sum) and (req sum = 0 and req digits > 1) --> print(-1)
		        System.out.println(-1);
		        continue;
		    }
		    
		    StringBuilder sb = new StringBuilder();
		    for(int i=0; i<dig; i++){                     // if(sum >= 9) --> append 9 ans sum -= 9   otherwise  append sum and sum = 0
		        if(sum >= 9){
		            sb.append(9);
		            sum -= 9;
		        }
		        else{
		            sb.append(sum);
		            sum = 0;
		        }
		    }
		    System.out.println(sb);
		}
	}
}
