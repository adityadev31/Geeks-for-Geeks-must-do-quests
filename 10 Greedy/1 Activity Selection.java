// url -  https://practice.geeksforgeeks.org/problems/activity-selection/0


/**


Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. First line is N number of activities then second line contains N numbers which are starting time of activies.Third line contains N finishing time of activities.

Output:
For each test case, output a single number denoting maximum activites which can be performed in new line.

Constraints:
1<=T<=50
1<=N<=1000
1<=A[i]<=100

Example:
Input:
2
6
1 3 2 5 8 5
2 4 6 7 9 9
4
1 3 2 5
2 4 3 6

Output:
4
4

Explanation:
Test Case 1: The following activities can be performed (in the same order):
(1, 2)
(3, 4)
(5, 7)
(8, 9)

**/

/**

A P P R O A C H - 

step1 - sort arrays according to the ending time.
step2 - check if current start time is >= prev end ---> if(yes)then count++

**/


import java.util.*;
import java.io.*;

class Activities{
    int st;
    int en;
    Activities(int a, int b){
        st = a;
        en = b;
    }
}

class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt((br.readLine()).trim());
		    String[] start = (br.readLine()).trim().split("\\s+");
		    String[] end = (br.readLine()).trim().split("\\s+");
		    Activities[] arr = new Activities[n] ;                      // grouping start and end array
		    for(int i=0; i<n; i++){ arr[i] = new Activities(Integer.parseInt(start[i]), Integer.parseInt(end[i])); }
		    Arrays.sort(arr, new Comparator<Activities>(){              // sorting according to end of the activities
		        public int compare(Activities e1, Activities e2){
		            return e1.en - e2.en;
		        }
		    });
		    int l=0, count=1;
		    for(int i=1; i<n; i++){
		        if(arr[i].st >= arr[l].en){
		            count++;
		            l = i;
		        }
		    }
		    System.out.println(count);
		}
	}
}
