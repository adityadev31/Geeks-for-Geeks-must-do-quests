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



import java.util.*;
import java.lang.*;
import java.io.*;

class LenComp implements Comparator<String>{
    public int compare(String x, String y){
        long len1 = x.length();
        long len2 = y.length();
        if((len1-len2) > 0) return 1;
        else if (len1 == len2) return 0;
        else return -1;
    }
}



class GFG
 {
    
    public static void prefix(String[] str, int n){
        
        if(n==1){
            System.out.println(str[0]);
            return;
        }
        
        // find the shortest string and check one by one that other contains or not
        
        Arrays.sort(str, new LenComp());
        String shortest = str[0];
        
        String ans = "";
        
        for(int i=1; i<=shortest.length(); i++){
            for(int j=1; j<str.length; j++){
                if(!shortest.substring(0,i).equals(str[j].substring(0,i))){
                    if(i==1){
                        System.out.println("-1");
                        return;
                    }
                    System.out.println(shortest.substring(0, i-1));
                    return;
                }
            }
        }
        System.out.println(shortest);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    prefix(str, n);
		}
	}
}
