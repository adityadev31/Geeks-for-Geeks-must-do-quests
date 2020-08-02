import java.util.*;

public class Main{
    
    public static String solve(String s, int k){
        
        Stack<Character> st = new Stack<>();        // setup
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char ele : ch){                               // loop
            if(k > 0 && !st.empty() && st.peek()<ele){
                st.pop();                                 // pop if lower arrives 
                k--;
            }
            st.push(ele);                                 // add to stack
        }
        
        while(!st.empty()){ sb.append(st.pop()); }        // append to string builder 
        
        return (sb.reverse()).toString();                 // reverse and return string
    }
    
    public static void main(String args[]) throws Exception{
        String s = "abhxhdyxnsjfjsd";
        int k = 3;
        System.out.print("original string : - \t" + s + " \n");
        System.out.print(solve(s, k));
    }
    
}


/**

original string : - 	abhxhdyxnsjfjsd 
xhdyxnsjfjsd

**/
