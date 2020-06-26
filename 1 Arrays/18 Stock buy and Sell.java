/**

The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input: 
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days. 

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
3
7
100 180 260 310 40 535 695
4
100 50 30 20
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
No Profit
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.



**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void maxProfit(int[] arr, int n){
        int i=1, min=0, max=-1;         // min < i
        while(i<n){
            if(arr[min] >= arr[i]){ min++; i++; } // (downfall) i <= min  --> min++ i++
            else{
                max = i;                          // (increment) i > min   --> max = i
                while(max+1 < n){
                    if(arr[max] <= arr[max+1]){ max++; }  // max+1 >= max --> max++
                    else{ break; }                        // max+1 < max  --> break (downfall)
                }
                System.out.print("("+min+" "+max+") ");  // we have both min and max now hence print
                
                min = max+1;   // reset min
                i = min+1;     // reset i such that ( min < i )
            }
        }
        if(max == -1) System.out.println("No Profit");  // for only downfall case
        else System.out.println();
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    maxProfit(arr, n);
		}
	}
}
