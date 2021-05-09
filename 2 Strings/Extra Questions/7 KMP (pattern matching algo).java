/*

  step1 : make LPS (last prefix suffix array)
  step2 : iterate if(j reach pattern len) return found = true, 
                  else if (i reach string len) return found = false
                  
  T = O(n)

*/


import java.util.*;

public class Main {
    
    public static boolean KMP_match(String s1, String pat) {
        
        // step1 make Last Prefix Suffix Match Array
        int i=0, j=1, patLen = pat.length();
        int[] LPA = new int[patLen];
        LPA[0] = 0;
        while(j<patLen) {
            // if matches -> set LPA[J] = i+1
            if(pat.charAt(i) == pat.charAt(j)) {
                LPA[j] = i+1;
                i++;
                j++;
            }
            // if !matches -> reset i as LPA[i-1]
            else{
                if(i == 0) j++;
                else i = LPA[i-1];
            }
        }
        
        for(int xxx: LPA) System.out.print(xxx + " ");
        System.out.println();
        
        // STEP2 start comparing s1 & pat
        i=0;    // for s1
        j=0;    // for pat
        while(i<s1.length()) {
            
            // if matches
            if(s1.charAt(i) == pat.charAt(j)) {
                if(j == patLen-1) return true;
                else {
                    i++;
                    j++;
                }
            }
            
            // if !matches
            else {
                if(j == 0) i++;
                else {
                    j = LPA[j-1];
                }
            }
            
        }
        
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "ABXABCABCABY";
        String pat = "AABAABAAA";
        System.out.println(KMP_match(s1, pat));
    }
}
