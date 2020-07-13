/**

Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer value N denoting the amount to get change for.

Output:
Print all the denominations needed to make the change in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
1
43

Output:
20 20 2 1

Explanation:
Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.

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
		    int sum = Integer.parseInt(br.readLine());
		    while(sum>0){
		        if(sum >= 2000){ System.out.print("2000 "); sum -= 2000; }
		        else if(sum >= 500){ System.out.print("500 "); sum -= 500; }
		        else if(sum >= 200){ System.out.print("200 "); sum -= 200; }
		        else if(sum >= 100){ System.out.print("100 "); sum -= 100; }
		        else if(sum >= 50){ System.out.print("50 "); sum -= 50; }
		        else if(sum >= 20){ System.out.print("20 "); sum -= 20; }
		        else if(sum >= 10){ System.out.print("10 "); sum -= 10; }
		        else if(sum >= 5){ System.out.print("5 "); sum -= 5; }
		        else if(sum >= 2){ System.out.print("2 "); sum -= 2; }
		        else if(sum >= 1){ System.out.print("1 "); sum -= 1; }
		    }
		    System.out.println();
		}
	}
}
