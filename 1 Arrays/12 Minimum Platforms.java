/**

Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other. In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.

Input:
The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour (between 00 to 23 ) and last two characters represent minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359

Example:
Input:
2
6 
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
3
0900 1100 1235
1000 1200 1240 

Output:
3
1

Explanation:
Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.


**/




import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    /**
    
        step1 - sort both arr[] and dep[]
        
        step2 - set max=0, reqSpace=0, i=0, j=0
        
        step3 - while(i<n && j<n) -> if(arr[i]<dep[j]) space++, i++, set max --> else space-- j++
        
        step4 - return max;
    
    **/
    
    public static void findPlatforms(int[] arr, int[] dep, int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0, j=0, spaceReq=0, max=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                spaceReq++;
                if(max<spaceReq) max=spaceReq;
                i++;
            }
            else{
                spaceReq--;  
                j++;         
            }
        }
        System.out.println(max);
    }
    
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int i=-1, j=-1;
		    int[] arr = new int[n];
		    int[] dep = new int[n];
		    String str[] = br.readLine().trim().split("\\s+");
		    String st2[] = br.readLine().trim().split("\\s+");
		    while(++i<n) arr[i]=Integer.parseInt(str[i]);
		    while(++j<n) dep[j]=Integer.parseInt(st2[j]);
		    findPlatforms(arr, dep, n);
		}
	}
}
