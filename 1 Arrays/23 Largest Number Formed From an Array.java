/**


Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line of each test case contains the size of the array, and the second line has the elements of the array.

Output:
In each separate line print the largest number formed by arranging the elements of the array in the form of a string.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 102
0 ≤ A[i] ≤ 103

Example:
Input:
2
5
3 30 34 5 9
4
54 546 548 60

Output:
9534330
6054854654



**/





import java.util.*;
import java.lang.*;
import java.io.*;


// comparator class for Arrays.sort 
class StrComp implements Comparator<String>{
     public int compare(String x, String y){
          String A = new String (x+y);
          String B = new String (y+x);
          return B.compareTo(A);        // we want   
     }
}


class GFG
 {
    /**       USING ARRAYS SORT AND COMPARATOR         **/
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    br.readLine();
                    String strarr[] = br.readLine().split(" ");
                    Arrays.sort(strarr, new StrComp());
                    System.out.println(String.join("",strarr));
		}
	}
}
