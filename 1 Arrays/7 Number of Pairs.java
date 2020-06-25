/**

Given two arrays X and Y of positive integers, find number of pairs such that x^y > y^x (raised to power of) where x is an element from X and y is an element from Y.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test consists of three lines. The first line of each test case consists of two space separated M and N denoting size of arrays X and Y respectively. The second line of each test case contains M space separated integers denoting the elements of array X. The third line of each test case contains N space separated integers denoting elements of array Y.

Output:
Corresponding to each test case, print in a new line, the number of pairs such that x^y > y^x.

Constraints:
1 ≤ T ≤ 100
1 ≤ M, N ≤ 105
1 ≤ X[i], Y[i] ≤ 103

Example:
Input
1
3 2
2 1 6
1 5

Output
3

Explanation:
Testcase 1: The pairs which follow x^y > y^x are as such: 21 > 12,  25 > 52 and 61 > 16 

**/




import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
    public static int countNum(int[] y, int key){
        int n= y.length;
        if(key<y[0]) return 0;
        if(key>y[n-1]) return 0;
        int l=0, r=n-1;
        while(l<r){
            if(y[l]==key && y[r]==key) break;
            if(y[l]!=key) l++;
            if(y[r]!=key) r--;
        }
        if(l==r && y[l]!=key) return 0;
        return r-l+1;
    }
    
    public static int upperBound(int[] y, int key){
        int n = y.length;
        if(key<y[0]) return 0;
        if(key>=y[n-1]) return n;
        int l=0, r=n-1;
        while(l<r){
            int mid = (l+r)/2;
            if(y[mid]<=key) l=mid+1;
            else r=mid;
        }
        return l;
    }
    
    public static void findPair(int[] x, int[] y, int n1, int n2){
        Arrays.sort(x);
        Arrays.sort(y);
        int countOf1 = countNum(y,1);
        int countOf2 = countNum(y,2);
        int countOf3 = countNum(y,3);
        int countOf4 = countNum(y,4);
        int i=0;
        long count=0;
        while(i<n1){
            if(x[i]==1){ /* exception1 (x=1) -> skip */
                i++;
                continue;
            }
            if(countOf1>0) count+=countOf1;            /* exception2 (y==1) -> count++         */
            if(x[i]==2 && countOf3>0) count-=countOf3; /* exception3 (x==2 && y==3) -> count-- */
            if(x[i]==2 && countOf4>0) count-=countOf4; /* exception4 (x==2 && y==3) -> count-- */
            if(x[i]==3 && countOf2>0) count+=countOf2; /* exception5 (x==3 && y==2) -> count++ */
            int idx = upperBound(y,x[i]);
            count = count+n2-idx;
            i++;
        }
        System.out.println(count);
    }
    
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0){
	        String size[] = br.readLine().trim().split("\\s+");
	        String arr1[] = br.readLine().trim().split("\\s+");
	        String arr2[] = br.readLine().trim().split("\\s+");
	        int n1 = Integer.parseInt(size[0]);
	        int n2 = Integer.parseInt(size[1]);
	        int[] x = new int[n1];
	        int[] y = new int[n2];
	        int i=0, j=0;
	        while(i<n1) x[i]=Integer.parseInt(arr1[i++]);
	        while(j<n2) y[j]=Integer.parseInt(arr2[j++]);
	        findPair(x,y,n1,n2);
	    }
	}
}
