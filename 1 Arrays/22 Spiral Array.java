/**


Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Constraints:
1 <= T <= 100
2 <= M,N <= 10
0 <= Ai <= 100

Example:
Input:
2
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4
1 2 3 4 5 6 7 8 9 10 11 12

Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
1 2 3 4 8 12 11 10 9 5 6 7




**/



import java.util.*;
import java.lang.*;
import java.io.*;
class Main
 {
    public static void spiral(int[][] arr, int m, int n){
        int topBorder = 0;
        int rightBorder = n-1;
        int bottomBorder = m-1;
        int leftBorder = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(topBorder<=bottomBorder && leftBorder<=rightBorder){
            // print top 
            if(topBorder<=bottomBorder){
                for(int j=leftBorder; j<=rightBorder; j++){ sb.append(arr[topBorder][j] + " "); }
                topBorder++;
            }
            
            // print right 
            if(rightBorder>=leftBorder){
                for(int i=topBorder; i<=bottomBorder; i++){ sb.append(arr[i][rightBorder] + " "); }
                rightBorder--;
            }
            
            // print bottom 
            if(bottomBorder>=topBorder){
                for(int j=rightBorder; j>=leftBorder; j--){ sb.append(arr[bottomBorder][j] + " "); }
                bottomBorder--;
            }
            
            // print left 
            if(leftBorder<=rightBorder){
                for(int i=bottomBorder; i>=topBorder; i--){ sb.append(arr[i][leftBorder] + " "); }
                leftBorder++;
            }
        }
        System.out.println(sb);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String size[] = br.readLine().trim().split("\\s+");
		    String str[]  = br.readLine().trim().split("\\s+");
		    
		    int m = Integer.parseInt(size[0]);
		    int n = Integer.parseInt(size[1]);
		    
		    int[][] arr = new int[m][n];
		    int k=0, i=0, j=0;
		    while(i<m){
		        while(j<n){
		            arr[i][j] = Integer.parseInt(str[k]);
		            j++;
		            k++;
		        }
		        i++;
		        j=0;
		    }
		    spiral(arr, m, n);
		}
	}
}
