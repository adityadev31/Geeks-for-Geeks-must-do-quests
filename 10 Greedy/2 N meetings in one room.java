// url - https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0

/**

There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room?

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line consists of the size of the array, second line has the array containing the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].

Output:
In each separate line print the order in which the meetings take place separated by a space.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 100
1 ≤ S[ i ], F[ i ] ≤ 100000

Example:
Input:
2
6
1 3 0 5 8 5
2 4 6 7 9 9
8
75250 50074 43659 8931 11273 27545 50879 77924
112960 114515 81825 93424 54316 35533 73383 160252  

Output:
1 2 4 5
6 7 1

Explanation:
Testcase 1: Four meetings can held with given start and end timings.

**/





import java.util.*;
import java.lang.*;
import java.io.*;

class Meet{
    int i;
    int start;
    int end;
    Meet(int i, int x, int y){
        this.i = i;
        this.start = x;
        this.end = y;
    }
}

class GFG
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());                // input n
		    String st1[] = br.readLine().trim().split("\\s+");      // input start
		    String st2[] = br.readLine().trim().split("\\s+");      // input end
		    Meet[] meetings = new Meet[n];                          // meeting array of data type Meet (Meet object containing i, start, end)
		    for(int i=0; i<n; i++){
		        meetings[i] = new Meet(i+1, Integer.parseInt(st1[i]), Integer.parseInt(st2[i]));  // filling meeting array
		    }
		    Arrays.sort(meetings, new Comparator<Meet>(){           // soting array according to end time
		        public int compare(Meet e1, Meet e2){
		            return e1.end - e2.end;
		        }
		    });
		    StringBuilder sb = new StringBuilder();
		    sb.append(meetings[0].i+" ");                           // adding the first meeting after sorting
		    int l=0;
		    for(int j=1; j<n; j++){
		        if(meetings[j].start >= meetings[l].end){           // if (jth start) > (lth end) then append (jth i)
		            sb.append(meetings[j].i+" ");
		            l = j;                                          // l = j
		        }
		    }
		    System.out.println(sb);
		}
	}
}


