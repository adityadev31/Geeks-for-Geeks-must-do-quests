/*

  Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5
Example 2:

Input:
s = III 
Output: 3
Your Task:
Complete the function romanToDecimal() which takes an string as input parameter and returns the equivalent decimal number. 

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=roman no range<=3999











Logic - 

result = arr[0];
if arr[i-1] >= arr[i]   add(arr[i] to result)
else (result = result + arr[i] - arr[i-1] - arr[i-1])

example - IV => 
         result => 1
         result => 1 + 5 - 1 - 1 => 4

*/




class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        
        int[] arr = new int[str.length()];
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='I') arr[i] = 1;
            else if(str.charAt(i)=='V') arr[i] = 5;
            else if(str.charAt(i)=='X') arr[i] = 10;
            else if(str.charAt(i)=='L') arr[i] = 50;
            else if(str.charAt(i)=='C') arr[i] = 100;
            else if(str.charAt(i)=='D') arr[i] = 500;
            else if(str.charAt(i)=='M') arr[i] = 1000;
        }
        
        int result = arr[0];
        
        if(arr.length==1) return arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]<=arr[i-1]){
                result += arr[i];
            }
            else{
                result += arr[i] - arr[i-1] - arr[i-1];
            }
        }
        
        return result;
    }
}
