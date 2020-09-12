import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int arr[] = {1,3,2,7,9,0,2,5,8};
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        for(int x: arr){
            if(x > a){
                c = b;
                b = a;
                a = x;
            }
            else if(x > b){
                c = b;
                b = x;
            }
            else if(x > c) c = x;
            else continue;
        }
        System.out.println("3 largest:- "+a+" "+b+" "+c);
    }
}


/**
        O U T P U T -
        
        3 largest:- 9 8 7

**/
