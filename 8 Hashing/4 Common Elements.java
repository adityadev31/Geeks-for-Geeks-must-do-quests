/**

Given three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively, you need to print all common elements in these arrays.

Note: Please avoid printing the same common element more than once.

Input:
First line contains a single integer T denoting the total number of test cases. T testcases follow. Each testcase contains four lines of input. First line consists of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. The second line contains N1 elements of A array. The third lines contains N2 elements of B array. The fourth lines contains N3 elements of C array.

Output:
For each testcase, print the common elements of array. If not possible then print -1.

Constraints:
1 <= T <= 100
1 <= N1, N2, N3 <= 107
1 <= Ai, Bi, Ci <= 1018

Example:
Input:
1
6 5 8
1 5 10 20 40 80
6 7 20 80 100
3 4 15 20 30 70 80 120
Output:
20 80

Explanation:
Testcase1:  20 and 80 are the only common elements

**/


/**

	A P P R O A C H 
	
	given 3 arrays ( NOTE - input arrays as "Integer" not "int" )
	
	Step1 - Integer[] arr0 = new Integer[size[0]]   (similarly other 2)
	Step2 - ArrayList<Integer> l0 = new ArrayList<>(Arrays.asList(arr0))  ( convert array -> arrayList * i.e, why we required Integer array *) (similarly other 2)
	Step3 - Set<Integer> s0 = new LinkedHashSet<>(l0)                     ( convert list -> set ) ( similarly other 2 ) ( LinkedHashSet is used to make elements in order )
	Step4 - Set<Integer> inter1 = new LinkedHashSet<>(s0)
	        inter1.retainAll(s1)                                           ( intersection of s0 & s1 )
	Step5 - Set<Integer> inter2 = new LinkedHashSet<>(inter1)
			inter2.retainAll(s2)                                           ( intersection of inter1 & s2 )
	Step6 - if(inter2.size() == 0) print(-1) --> continue the loop         ( no common found ! )
	Step7 - ArrayList<Integer> ans = new ArrayList<>(inter2)               ( if size > 0 then convert inter2 --> arraylist )
	Step8 - print(array list elements)


**/



import java.util.*;
import java.lang.*;
import java.io.*;
class Main
 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String siz[] = br.readLine().trim().split("\\s+");
		    String st0[] = br.readLine().trim().split("\\s+");
		    String st1[] = br.readLine().trim().split("\\s+");
		    String st2[] = br.readLine().trim().split("\\s+");
		    Integer arr0[] = new Integer[Integer.parseInt(siz[0])];
		    Integer arr1[] = new Integer[Integer.parseInt(siz[1])];
		    Integer arr2[] = new Integer[Integer.parseInt(siz[2])];
		    for(int i=0; i<Integer.parseInt(siz[0]); i++) arr0[i] = Integer.parseInt(st0[i]);
		    for(int i=0; i<Integer.parseInt(siz[1]); i++) arr1[i] = Integer.parseInt(st1[i]);
		    for(int i=0; i<Integer.parseInt(siz[2]); i++) arr2[i] = Integer.parseInt(st2[i]);
		    ArrayList<Integer> l0 = new ArrayList<>(Arrays.asList(arr0));
		    ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(arr1));
		    ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(arr2));
		    //  System.out.println(l0);
		    //  System.out.println(l1);
		    //  System.out.println(l2);
		    Set<Integer> s0 = new LinkedHashSet<>(l0);
		    Set<Integer> s1 = new LinkedHashSet<>(l1);
		    Set<Integer> s2 = new LinkedHashSet<>(l2);
		    //  System.out.println(s0);
		    //  System.out.println(s1);
		    //  System.out.println(s2);
		    Set<Integer> inter1 = new LinkedHashSet<>(s0);
		    inter1.retainAll(s1);
		    Set<Integer> inter2 = new LinkedHashSet<>(inter1);
		    inter2.retainAll(s2);
		    
		    if(inter2.size()==0){
		        System.out.println(-1);
		        continue;
		    }
		    
		    ArrayList<Integer> ans = new ArrayList<>(inter2);
		    for(int x : ans) System.out.print(x + " ");
		    System.out.println();
		}
	}
}
