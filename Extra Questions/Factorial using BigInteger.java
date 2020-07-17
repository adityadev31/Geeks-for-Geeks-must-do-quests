/**

BigInteger is a class in java reallllly helpful for solving extreeeemly large number operations.....

BigInteger b = new BigInteger("1244634536");  // or any no. u want   NOTE BigInteger are immutables so we have to restore them again we make a change (same as string)

b = b.multiply(new BigInteger("131232331"));

similarly we can do all mathematical operations like add, div, mul, sub ;

**/


/**

CodeChef Question (Small factorials Problem Code: FCTRL2)

Example
Sample input:

4
1
2
5
3

Sample output:

1
2
120
6




**/


import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;


public class Main {
    
    public static BigInteger fact(int n){
        BigInteger result = BigInteger.ONE;
        for(int i=2; i<=n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt((br.readLine()).trim());
        while(t-- > 0){
            int n = Integer.parseInt((br.readLine()).trim());
            System.out.println(fact(n));
        }
    }
}
