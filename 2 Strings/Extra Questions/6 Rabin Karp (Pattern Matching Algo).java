/*
    step1 : hash pattern and 1st window of string
    step2 : iterate s1 
              _i_  remove prev char -> shift right -> add new char
              _ii_ check for hash match (if matches then check char by char)
              
    T = O(m*n)
*/

public class Main {
    
    public static boolean isMatched(String s1, String pat) {
        
        int patLen = pat.length();
        int mod = 1777;
        int patHash = 0, curHash = 0;
        
        // hash of pattern and first window of s1
        for(int i=0; i<patLen; i++) {
            char ch = pat.charAt(i);
            patHash = (patHash + ((ch-64) * (int)Math.pow(10, patLen-1-i)))%mod;
            
            char ch2 = s1.charAt(i);
            curHash = (curHash + ((ch2-64) * (int)Math.pow(10, patLen-1-i)))%mod;
        }
        
        // looping to find match
        
        System.out.println("Pattern Hash: " + patHash);
        
        for(int i=0; i<=s1.length()-patLen; i++) {
            if(i!=0) {
                /*
                    1) removing prev
                    2) shifting left 
                    3) adding new ele
                */
                curHash = (((curHash - ((s1.charAt(i-1)-64) * (int)Math.pow(10, patLen-1)))*10)+(s1.charAt(i+patLen-1)-64));
            }
            
            System.out.println("Current Hash: " + curHash);
            
            if(curHash == patHash) {
                boolean found = true;
                for(int j=0; j<patLen; j++) {
                    if(s1.charAt(i+j)!=pat.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if(found) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "AABAACBACBAD";
        String pat = "BAD";
        System.out.println(isMatched(s1,pat));
    }
}
