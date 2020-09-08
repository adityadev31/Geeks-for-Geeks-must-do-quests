// log(num) base 2 --->  length of the binary no.

import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        int num = 64;
        System.out.println((int)((Math.log(num)/Math.log(2))+0.5));
        System.out.println(Integer.toBinaryString(num));
    }
}

// ans - binary length of 64 = 6
// binary of 64 = 100000
