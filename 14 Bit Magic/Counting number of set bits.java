// M E T H O D   1

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int num = 10, count = 0;
        int temp = num;
        while(num > 0){
            count += (num & 1);
            num = num >> 1;
        }
        System.out.println("No. of 1 in binary of " + temp +" = " + count);
    }
}

// ANS - "No. of 1 in binary of 10 = 2"







// M E T H O D    2           (b e t t e r   w a y)

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int num = 10, count = 0;
        while(num > 0){
            num = num & (num-1);
            count++;
        }
        System.out.println(count);
    }
}

// ANS - 2
