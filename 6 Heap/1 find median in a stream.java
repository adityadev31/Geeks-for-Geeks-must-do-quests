/*

Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

Input:
The first line of input contains an integer N denoting the number of elements in the stream. Then the next N lines contains integer x denoting the number to be inserted into the stream.
Output:
For each element added to the stream print the floor of the new median in a new line.
 
Constraints:
1 <= N <= 106
1 <= x <= 106
 
Example:
Input:
4
5
15
1 
3
Output:
5
10
5
4
 
Explanation:
Testcase 1:
Flow in stream : 5, 15, 1, 3
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3)

*/





import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class GFG
 {
    static class MaxPq implements Comparator<Integer>{
        public int compare(Integer e1, Integer e2){ return e2-e1; }
    }
     
    public static void median(int[] arr){
        int N = arr.length;
        PriorityQueue<Integer> q1 = new PriorityQueue<>(new MaxPq()); // this will store smaller ele but in max heap
        PriorityQueue<Integer> q2 = new PriorityQueue<>();            // this will store larger  ele but in min heap
        int mid = arr[0];
        q1.add(arr[0]);
        System.out.println(mid);
        
        for(int i=1; i<N; i++){
            int num = arr[i];
            
            if(q1.size()> q2.size()){
                if(num > mid) q2.add(num); // (num > mid) larger hence insert  in q2
                else{                      // (num < mid) smaller hence insert in q1 ( maintaining sizes )
                    q2.add(q1.poll());
                    q1.add(num);
                }
                mid = (q1.peek()+q2.peek())/2;
            }
            
            else if(q2.size()>q1.size()){
                if(num < mid) q1.add(num);   // smaller hence insert in q1
                else{                        // larger hence inserted in q2 ( maintaining sizes )
                    q1.add(q2.poll());
                    q2.add(num);
                }
                mid = (q1.peek()+q2.peek())/2;
            }
            
            else{
                if(num < mid){
                    q1.add(num);
                    mid = q1.peek();
                }
                else{
                    q2.add(num);
                    mid = q2.peek();
                }
            }
            System.out.println(mid);
        }
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    int n = Integer.parseInt(br.readLine());
    	    int[] arr = new int[n];
    	    for(int i=0; i<n; i++){
    	        arr[i] = Integer.parseInt(br.readLine().trim());
    	    }
    	    median(arr);
    	    // call function
	}
}
