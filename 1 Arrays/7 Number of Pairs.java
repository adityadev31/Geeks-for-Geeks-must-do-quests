/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int countNum(int[] y, int key){
        int i=0, j=y.length-1;
        while(i<=j){
            if(y[i]==key && y[j]==key) break;
            if(y[i]!=key) i++;
            if(y[j]!=key) j--;
        }
        if(i<=j) return j-i+1;
        return 0;
    }
    
    public static int upperBound(int[] y, int key){
        int l=0, r=y.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(y[mid]<=key) l=mid+1;
            else r=mid-1;
        }
        if(l>=y.length) return y.length;
        return l;
    }
    
    public static void findCount(int[] x, int[] y, int n1, int n2){
        Arrays.sort(x);
        Arrays.sort(y);
        int i=0, count=0;
        while(i<n1){
            // exception 1 (x=1)
            if(x[i]==1){
                i++;
                continue;
            }
            // exception 1.1 (y=1)
            if(countNum(y,1)!=0) count+=countNum(y,1);
            
            // exception 2 (x=2 y=3)
            if(x[i]==2 && countNum(y,3)!=0) count-=countNum(y,3);
            
            // exception 2 (x=2 y=4)
            if(x[i]==2 && countNum(y,4)!=0) count-=countNum(y,4);
            
            // normal case (n2 - upperbound(xi))
            int indx = upperBound(y,x[i]);
            count+=n2-indx;
            i++;
        }
        System.out.println(count);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String sizes[] = br.readLine().trim().split("\\s+");
		    String line1[] = br.readLine().trim().split("\\s+");
		    String line2[] = br.readLine().trim().split("\\s+");
		    int n1 = Integer.parseInt(sizes[0]);
		    int n2 = Integer.parseInt(sizes[1]);
		    int arr1[] = new int[n1];
		    int arr2[] = new int[n2];
		    int i=0;
		    while(i<n1){
		        arr1[i] = Integer.parseInt(line1[i]);
		        i++;
		    }i=0;
		    while(i<n2){
		        arr2[i] = Integer.parseInt(line2[i]);
		        i++;
		    }
		    findCount(arr1, arr2, n1, n2);
		}
	}
}
