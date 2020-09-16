// replace the continuosly repeated characters with their counts

// H I N T  --->   compare (i) with (i+1)


import java.util.*;

public class Main {
    
    public static void sol(String msg){
        int n = msg.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i<n-1; i++){
            if(msg.charAt(i)==msg.charAt(i+1)) count++;
            else{
                sb.append(msg.substring(i,i+1));
                if(count != 1) sb.append(count);
                count = 1;
            }
        }
        sb.append(msg.substring(n-1));
        if(count != 1) sb.append(count);
        System.out.println(sb);
    }
    
    public static void main(String[] args) throws Exception {
        String msg = "abbccccccdxx";
        sol(msg);
    }
}


// O U T P U T -->  ab2c6dx2
