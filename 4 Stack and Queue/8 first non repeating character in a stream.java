/* 

Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If no non repeating element is found print -1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the stream. Then in the next line are x characters which are inserted to the stream.

Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.

Constraints:
1 <= T <= 200
1 <= N <= 500

Example:
Input:
2
4
a a b c
3
a a c

Output:
a -1 b b
a -1 c

Explanation:
Test Case 1: a a b c
The step wise first non-repeating elements are made bold:
a (print a)
a a (no non-repeating element, print -1)
a a b (print b)
a a b c (print b)
Result: a -1 b b

Test Case 2: a a c
a (print a)
a a (no non-repeating element, print -1)
a a c (print c)
Result: a -1 c

*/



/*

ALGORITHM :- 

1) repeated[] , ansList[]
2) repeated[] = true if char has already appeared twice;
3) if not appeared twice ==> (i)  appeared once(1) -> remove from ansList and mark repeated[] = true
                             (ii) appeared zero times(0) -> add to the ansList
4) keep printing ansList[0];

*/




import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String inp = br.readLine().trim().replaceAll(" ", "");
		    // call function
		    boolean[] repeat = new boolean[256];                // repeated[] = true when char appered twice
		    ArrayList<Character> ansList = new ArrayList<>();
		    StringBuilder sb = new StringBuilder();
		    //
		    for(int i=0; i<n; i++){
		        char x = inp.charAt(i);
		        if(!repeat[x]){                // if not repeated twice (i.e, appeared 0 or 1 times) before
		            if(ansList.contains(x)) {  // char has appeared (1 time) before
		                ansList.remove((Character)x);
		                repeat[x] = true;
		            }
		            else ansList.add(x);       // appeared 0 time before
		        }
		        if(ansList.size()!=0) sb.append(ansList.get(0)+" ");
		        else sb.append("-1 ");
		    }
		    System.out.println(sb);
		}
	}
}
