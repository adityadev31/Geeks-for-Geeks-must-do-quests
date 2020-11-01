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


.

**/



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String str1[] = br.readLine().trim().split("\\s+");
		    String str2[] = br.readLine().trim().split("\\s+");
		    int r = Integer.parseInt(str1[0]);
		    int c = Integer.parseInt(str1[1]);
		    int k = 0;
		    int arr[][] = new int[r][c];
		    for(int i=0; i<r; i++){
		        for(int j=0; j<c; j++){
		            arr[i][j] = Integer.parseInt(str2[k++]);
		        }
		    }
		    // call function
		    //
		    int T = 0, R = c-1, B = r-1, L = 0;
		    StringBuilder sb = new StringBuilder();
		    
		    while(T <= B && L <= R){
		        
		        // printing TOP
		        if(T<=B && L<=R) for(int i=L; i<=R; i++) sb.append(arr[T][i] + " ");
		        T++;
		        
		        // printing RIGHT
		        if(T<=B && L<=R) for(int i=T; i<=B; i++) sb.append(arr[i][R] + " ");
		        R--;
		        
		        // printing Bottom
		        if(T<=B && L<=R) for(int i=R; i>=L; i--) sb.append(arr[B][i] + " ");
		        B--;
		        
		        // printing Left
		        if(T<=B && L<=R) for(int i=B; i>=T; i--) sb.append(arr[i][L] + " ");
		        L++;
		        
		    }
		    System.out.println(sb);
		}
	}
}
