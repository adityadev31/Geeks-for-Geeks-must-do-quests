/**

Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
| |
|_|
We can trap 2 units of water in the middle gap.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.

**/




import java.util.*;
import java.lang.Math;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static int water(int[] arr, int n){
     int[] arr1 = new int[n];
     int[] arr2 = new int[n];
     
     // max height so far FROM LEFT
     int max = Integer.MIN_VALUE;
     int i = -1;
     while(++i < n){
       if(arr[i] > max) max = arr[i];
       arr1[i] = max;
     }
     
     // max height so far FROM RIGHT
     max = Integer.MIN_VALUE;
     i = n;
     while(--i >= 0){
       if(arr[i] > max) max = arr[i];
       arr2[i] = max;
     }
     
     // comparing
     i = -1;
     int water = 0;
     while(++i < n){
       water += Math.min(arr1[i], arr2[i]) - arr[i];
     }
     
     return water;
   }
   
   public static void main(String args[])
   { 
    int arr[] = {3,0,0,2,0,4};
    System.out.println("Units of water = " + water(arr, arr.length));
   }
 }











/*   time complexity O(n) space O(n) BETTER APPROACH   */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    
    public static int findWater(int[] arr, int n){
        int prev = arr[0], prev_i = 0, temp = 0, water = 0;
        // forward pass
        for(int i=1; i<n; i++){
            // if current wall is greater than previous (reset temp)
            if(prev <= arr[i]){
                prev = arr[i];
                prev_i = i;
                temp = 0;
            }
            // if current wall is smaller than previous (update water and temp)
            else{
                water += prev - arr[i];
                temp += prev - arr[i];
            }
        }
        // backward pass
        if(prev_i < n-1){       // i.e, only if no larger wall at end
            prev = arr[n-1];
            water -= temp;      // to set the water to the last good boundaries
            
            for(int i=n-1; i>= prev_i; i--){
                if(prev <= arr[i]) prev = arr[i];
                else water += prev - arr[i];
            }
        }
        return water;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
            //
            System.out.println(findWater(arr, n));
        }
    }
}
