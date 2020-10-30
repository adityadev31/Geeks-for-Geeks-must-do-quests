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











/*   time complexity O(n) space O(n)                                     ========= B E T T E R   A P P R O A C H ===========   */
/* Reference => https://www.geeksforgeeks.org/trapping-rain-water/ */
/* 
   Approach : The concept here is that if there is a larger wall to the right then the water can be retained with height equal to the smaller wall on the left. 
              If there are no larger walls to the right then start from the left. There must be a larger wall to the left now. 
              Let’s take an example if the heights are {….,3, 2, 1, 4,….}, So here 3 and 4 are boundaries the heights 2 and 1 are submerged and cannot act as boundaries. 
              So at any point or index knowing the previous boundary is sufficient if there is a higher or equal length boundary in the remaining part of the array. 
              If not then traverse the array backwards and now must be a larger wall to the left. 
 
   Algorithm : 
     Loop from index 0 to the end of the given array.
     If a wall greater than or equal to the previous wall is encountered then make note of the index of that wall in a var called prev_index.
     Keep adding previous wall’s height minus the current (ith) wall to the variable water.
     Have a temporary variable that stores the same value as water.
     If no wall greater than or equal to the previous wall is found then quit.
     If prev_index < size of the input array then subtract the temp variable from water, and loop from end of the input array to prev_index and find a wall greater than or equal to the previous wall (in this case, the last wall from backwards).
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    
    public static int findWater(int[] arr, int n){
        int prev = arr[0], prev_i = 0, temp = 0, water = 0;
        // forward pass
        for(int i=1; i<n; i++){
            // if current wall is greater than or equal to previous (reset vars)
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
        if(prev_i < n-1){       // i.e, last wall was not a boundary
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
