/**


Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1},
{1, 2, 2, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 2, 2, 0},
{1, 1, 1, 1, 1, 2, 1, 1},
{1, 1, 1, 1, 1, 2, 2, 1},
 };

 x=4, y=4, color=3 

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1}, 
{1, 3, 3, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 3, 3, 0},
{1, 1, 1, 1, 1, 3, 1, 1},
{1, 1, 1, 1, 1, 3, 3, 1}, };

Note: Use zero based indexing.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains Two integers N and M denoting the size of the matrix. Then in the next line are N*M space separated values of the matrix. Then in the next line are three values x, y and K.

Output:
For each test case print the space separated values of the new matrix.

Constraints:
1 <= T <= 100
1 <= M[][] <= 100

Example:
Input:
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4 
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9

Output:
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4




**/




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void floodFill(int[][] arr, int m, int n, int x, int y, int k, int c){
        if(x>=m || x<0 || y>=n || y<0 || arr[x][y]!=c) return;
        arr[x][y] = k;
        floodFill(arr, m, n, x-1, y, k, c);
        floodFill(arr, m, n, x+1, y, k, c);
        floodFill(arr, m, n, x, y-1, k, c);
        floodFill(arr, m, n, x, y+1, k, c);
        return;
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    int m = Integer.parseInt(size[0]);
		    int n = Integer.parseInt(size[1]);
		    String str[] = br.readLine().trim().split("\\s+");
		    int arr[][] = new int[m][n];
		    int q=0;
		    for(int i=0; i<m; i++){
		        for(int j=0; j<n; j++){
		            arr[i][j] = Integer.parseInt(str[q++]);
		        }
		    }
		    String val[] = br.readLine().trim().split("\\s+");
		    int x = Integer.parseInt(val[0]);
		    int y = Integer.parseInt(val[1]);
		    int k = Integer.parseInt(val[2]);
		    int c = arr[x][y];
		    floodFill(arr, m, n, x, y, k, c);    // calling floodFill
		    for(int i=0; i<m; i++){              // printing new array
		        for(int j=0; j<n; j++){
		            System.out.print(arr[i][j] + " ");
		        }
		    }
		    System.out.println();
		}
	}
}
