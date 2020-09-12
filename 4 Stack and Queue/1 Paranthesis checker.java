/**

Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced

**/






import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine().trim();
		    int n = str.length();
		    // function
		    Stack<Character> st = new Stack<>();
		    boolean found = true;
		    for(int i=0; i<n; i++){
		        char x = str.charAt(i);
		        if(x == '(' || x == '[' || x == '{') st.push(x);
		        else{
		            if(st.empty()){
		                found = false;
		                break;
		            }
		            else{
		                char y = st.peek();
		                if((x==')' && y=='(') || (x=='}' && y=='{') || (x==']' && y=='[')) st.pop();
		                else{
		                    found = false;
		                    break;
		                }
		            }
		        }
		    }
		    if(found && st.empty()) System.out.println("balanced");
		    else System.out.println("not balanced");
		}
	}
}





/**
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static String checker(char[] arr, int n){
        if(n%2 != 0) return "not balanced";
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i < n){
            char x = arr[i];
            if(x=='(' || x=='{' || x=='[') stack.push(x);
            else{
                if(stack.size() > 0){
                    char y = stack.peek();
                    if((y=='(' && x==')') || (y=='[' && x==']') ||(y=='{' && x=='}')){
                        stack.pop();
                    }else{
                        return "not balanced";
                    }
                }
                else{
                    return "not balanced";
                }
            }
            i++;
        }
        if(stack.size() > 0) return "not balanced";
        return "balanced";
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str = br.readLine().trim();
		    int n = str.length();
		    char arr[] = new char[n];
		    for(int i=0; i<n; i++) arr[i] = str.charAt(i);
		    System.out.println(checker(arr, n));
		}
	}
}
**/
