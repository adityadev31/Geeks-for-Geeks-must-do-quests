/**

url - https://practice.geeksforgeeks.org/problems/k-anagrams-1/0


Approach - 

1) make hashmap with ( key = sorted string , value = count )

2) for key sort the array string element and then check in map and increment the count

3) finally sort the entrySet according to the count(value)

4) print the result


**/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void findAna(String[] str){
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<str.length; i++){
            char x[] = str[i].toCharArray();
            Arrays.sort(x);
            String temp = new String(x);
            
            if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
            
            else map.put(temp, 1);
            
        }
        
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
           public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
               return e1.getValue()-e2.getValue();
           }
        });
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> x : list) sb.append(x.getValue() + " ");
        System.out.println(sb);
    }
     
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().trim().split("\\s+");
		    findAna(str);
		}
	}
}


/**

  Input:
  2
  5
  act cat tac god dog
  3
  act cat tac
  Output:
  2 3
  3


**/
