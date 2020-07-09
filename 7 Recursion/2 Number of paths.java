/**

The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.

Input:
The first line of input contains an integer T, denoting the number of test cases. The first line of each test case is M and N, M is number of rows and N is number of columns.

Output:
For each test case, print the number of paths.

Constraints:
1 ≤ T ≤ 30
1 ≤ M,N ≤ 10

Example:
Input
2
3 3
2 8

Output
6
8

Explanation:
Testcase 1: Let the given input 3*3 matrix is filled as such:
A B C
D E F
G H I
The possible paths which exists to reach 'I' from 'A' following above conditions are as follows:
ABCFI, ABEHI, ADGHI, ADEFI, ADEHI, ABEFI.


**/




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static int findPath(int m,int n){
        if(m==1 || n==1) return 1;                    // base case we either m or n in border then only one path left to reach
        return findPath(m-1, n) + findPath(m, n-1);   // top + left paths from end
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str[] = br.readLine().trim().split("\\s+");
		    int m = Integer.parseInt(str[0]);
		    int n = Integer.parseInt(str[1]);
		    System.out.println(findPath(m, n));
		}
	}
}
