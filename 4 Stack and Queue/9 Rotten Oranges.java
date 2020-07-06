/**

Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

So, we have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. If it is impossible to rot every orange then simply return -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains two integers r and c, where r is the number of rows and c is the number of columns in the array a[]. Next line contains space separated r*c elements each in the array a[].

Output:
Print an integer which denotes the minimum time taken to rot all the oranges (-1 if it is impossible).

Constraints:
1 <= T <= 100
1 <= r <= 100
1 <= c <= 100
0 <= a[i] <= 2

Example:
Input:
2
3 5
2 1 0 2 1 1 0 1 2 1 1 0 0 2 1
3 5
2 1 0 2 1 0 0 1 2 1 1 0 0 2 1

Output:
2
-1

Explanation:
Testcase 1:
2 | 1 | 0 | 2 | 1
1 | 0 | 1 | 2 | 1
1 | 0 | 0 | 2 | 1

Oranges at positions {0,0}, {0, 3}, {1, 3} and {2, 3} will rot oranges at {0, 1}, {1, 0}, {0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st unit time. And, during 2nd unit time, orange at {1, 0} got rotten and will rot orange at {2, 0}. Hence, total 2 unit of time is required to rot all oranges.

**/







import java.util.*;
import java.lang.*;
import java.io.*;

class Item{
    int time;
    int i;
    int j;
    Item(int time, int i, int j){
        this.time = time;
        this.i = i;
        this.j = j;
    }
}

class GFG
 {
    public static boolean inRange(int i, int j, int m, int n){			// checking range
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }
     
    public static void rottenOranges(int[][] arr, int m, int n){
        
        Queue<Item> q = new LinkedList<Item>();
        
        // checking for 2s and isolated 1s
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 2) q.add(new Item(0, i, j));			// if 2 then enqueue
                if(arr[i][j] == 1){										// if 1 check if anyone is isolated. if yes then return -1
                    // check for isolation
                    int countNeighbours = 0, countZeros = 0;
                    if(inRange(i-1, j, m, n)){
                        countNeighbours++;
                        if(arr[i-1][j] == 0) countZeros++;
                    }
                    if(inRange(i+1, j, m, n)){
                        countNeighbours++;
                        if(arr[i+1][j] == 0) countZeros++;
                    }
                    if(inRange(i, j-1, m, n)){
                        countNeighbours++;
                        if(arr[i][j-1] == 0) countZeros++;
                    }
                    if(inRange(i, j+1, m, n)){
                        countNeighbours++;
                        if(arr[i][j+1] == 0) countZeros++;
                    }
                    if(countNeighbours == countZeros){       		 // isolated confirmed (coz no. of neighbours == no. of zeros surrounded)
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        // deque and find 1s to be rotten and make time++ and enqueue the new rotten Orange
        Item temp;
        while(q.size() > 0){
            temp = q.poll();											// dequeue and check its neighbour 1s
            if(inRange((temp.i)-1, temp.j, m, n)){
                if(arr[(temp.i)-1][temp.j] == 1){
                    arr[(temp.i)-1][temp.j] = 2;
                    q.add(new Item((temp.time)+1, (temp.i)-1, temp.j));
                }
            }
            if(inRange((temp.i)+1, temp.j, m, n)){
                if(arr[(temp.i)+1][temp.j] == 1){
                    arr[(temp.i)+1][temp.j] = 2;
                    q.add(new Item((temp.time)+1, (temp.i)+1, temp.j));
                }
            }
            if(inRange(temp.i, (temp.j)-1, m, n)){
                if(arr[temp.i][(temp.j)-1] == 1){
                    arr[temp.i][(temp.j)-1] = 2;
                    q.add(new Item((temp.time)+1, temp.i, (temp.j)-1));
                }
            }
            if(inRange(temp.i, (temp.j)+1, m, n)){
                if(arr[temp.i][(temp.j)+1] == 1){
                    arr[temp.i][(temp.j)+1] = 2;
                    q.add(new Item((temp.time)+1, temp.i, (temp.j)+1));
                }
            }
            
            if(q.size() == 0){									// if stack is now empty --> again check for isolated 1 (for last)
                for(int i=0; i<m; i++){
                    for(int j=0; j<n; j++){
                        if(arr[i][j] == 1){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
                System.out.println(temp.time);                  // if no 1 found that means all oranges are now rotten --> return latest time
                return;
            }
        }
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    int r = Integer.parseInt(size[0]);
		    int c = Integer.parseInt(size[1]);
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[][] = new int[r][c];
		    int k = 0;
		    for(int i=0; i<r; i++){
		        for(int j=0; j<c; j++){
		            arr[i][j] = Integer.parseInt(str[k]);
		            k = k+1;
		        }
		    }
		    // call function
		    rottenOranges(arr, r, c);
		}
	}
}
