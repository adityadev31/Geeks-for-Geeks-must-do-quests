//  M E T H O D   1

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int val = 10;
        String ans = Integer.toBinaryString(val);
        System.out.println("Binary of "+ val +" is : " + ans);
    }
}

// ANS - "Binary of 10 is : 1010"







// M E T H O D    2

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int val = 10;
        int temp = val;
        String ans = "";
        while(val != 0){
            ans = val%2 + ans;
            val = val/2;
        }
        System.out.println("Binary of "+ temp + " is: " + ans);
    }
}

// ANS - "Binary of 10 is: 1010"
