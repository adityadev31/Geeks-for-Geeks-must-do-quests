// url - https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/

// Recursive Java program to generate all 
// binary strings formed by replacing 
// each wildcard character by 0 or 1 

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class binStr 
{ 
	// Recursive function to generate all binary 
	// strings formed by replacing each wildcard 
	// character by 0 or 1 
  
	public static void print(char str[], int index) 
	{ 
		if(index == str.length){
          System.out.println(str);
          return;
        }
      
      	
        if(str[index] == '?'){

          str[index] = '0';       // setting 0 rest for recursion
          print(str, index+1);

          str[index] = '1';       // setting 1 rest for recursion
          print(str, index+1);
          
          str[index] = '?';		  // backtracking  (coz otherwise for i+1s there will be no '?' which would be wrong)

        }
        else print(str, index+1);
        return;
        
	} 

	// driver code 
	public static void main (String[] args) 
	{ 
		String input = "1??0?101"; 
		char[] str = input.toCharArray(); 
		print(str, 0); 
	} 
} 
