/**


Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA 


**/




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static StringBuilder answer = new StringBuilder();
     
    public static void permutation(String s, String ans){
        if(s.length()==0){
            answer.append(ans+" ");
            return;
        }
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i+1);
            permutation(ros, ans+ch);               // selecting first char and permuting others
        }
    }
     
    public static void permutation(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);                // sorting for lexographical solution
        StringBuilder sb = new StringBuilder();
        for(char x: ch) sb.append(x);
        permutation(sb.toString(), "");     // calling permutation
        System.out.println(answer);         // printing answer
        answer.delete(0, answer.length());  // deleting static variable value
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine().trim();
		    permutation(str);
		}
	}
}
