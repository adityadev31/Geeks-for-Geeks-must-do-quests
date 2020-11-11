/**

Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.

Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers N and M. Second line of each test case contains N space separated integers denoting the elements of first array. Third line of each test case contains M space separated integers denoting the elements of second array.

Output:
For each test case, print 1 if there exists any such pair otherwise print -1.

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= M <= 104
0 <= elements <= 104

Example:
Input:
2
6 4
4 1 2 1 1 2
3 6 3 3
4 4
5 7 4 6
1 2 3 8

Output:
1
1

Explanation:
Testcase 1: 1 and 3 are two such values one from first array other from second one, if we swap these two values then we will get both arrays sum as equal.



**/





/**


	A P P R O A C H
	
	step1 - sum1 = sum of a1[], sum2 = sum of a2[]
	step2 - diff = sum1 - sum2
	step3 - we know by maths that -> (sum1-a1[i]+a2[j]) = (sum2-a2[j]+a1[i])    swapping or we can say (sum1-x+y = sum2-y+x) where (x belongs to a1) (y belongs to a2)
	step4 - (sum1 - sum2) = 2(a1-a2)
	step5 - (diff/2)+a2[j] = a1[i];   so basically we have to keep adding a2[j] to (diff/2) and check whether such such a1[i] exists or not we can do this by making a set of elements of a1[]


**/




import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void findPair(int[] a1, int[] a2, int n, int m){
        Set<Integer> st = new HashSet<>();
        int sum1=0, sum2=0, i=0, j=0;
        for(i=0; i<n; i++){
            sum1+=a1[i];
            st.add(a1[i]);
        }
        for(i=0; i<m; i++) sum2+=a2[i];
        int diff = sum1-sum2;
        j=0;
        while(j<m){
            int x = (diff/2)+a2[j];
            if(st.contains(x)){
                System.out.println(1);
                return;
            }
            j++;
        }
        System.out.println(-1);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String siz[] = br.readLine().trim().split("\\s+");
		    String str1[] = br.readLine().trim().split("\\s+");
		    String str2[] = br.readLine().trim().split("\\s+");
		    int n = Integer.parseInt(siz[0]);
		    int m = Integer.parseInt(siz[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(str1[i]);
		    for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(str2[i]);
		    findPair(arr1, arr2, n, m);
		}
	}
}













class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        long sum1 = 0, sum2 = 0, diff = 0;
        Set<Long> st = new HashSet<>();
        for(long i: A){
            sum1 += i;
            st.add(i);
        }
        for(long i: B) sum2 += i;
        diff = (sum1-sum2);           // sum1-x+y = sum2+x-y
        if((sum1-sum2)%2!=0) return -1;
        diff = diff/2;
        for(long i : B){
            if(st.contains(diff+i)) return 1;
        }
        return -1;
    }
}
