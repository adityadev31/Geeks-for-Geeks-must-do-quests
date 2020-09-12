/**

Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

Input : n = 7 and array[] = {1, 2, 3, 1, 3, 6, 6}
Output: 1, 3, 6

Explanation: The numbers 1 , 3 and 6 appears more
than once in the array.

Input : n = 5 and array[] = {1, 2, 3, 4 ,3}
Output: 3

Explanation: The number 3 appears more than once
in the array.


**/


/**

Solution 1:

    Approach:The elements in the array is from 0 to n-1 and all of them are positive. So to find out the duplicate elements, a HashMap is required, but the question is to solve the problem in constant space. There is a catch, the array is of length n and the elements are from 0 to n-1 (n elements). The array can be used as a HashMap.
    Algorithm:
        Traverse the array from start to end.
        For every element,take its absolute value and if the abs(array[i])‘th element is positive, the element has not encountered before, else if negative the element has been encountered before print the absolute value of the current element.
    Implementation:


**/


// Java code to find 
// duplicates in O(n) time 

class FindDuplicate 
{ 
// Function to print duplicates 
	void printRepeating(int arr[], int size) 
	{ 
		int i; 
		System.out.println("The repeating elements are : "); 
	
		for (i = 0; i < size; i++) 
		{ 
			if (arr[ Math.abs(arr[i])] >= 0) 
				arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
			else
				System.out.print(Math.abs(arr[i]) + " "); 
		}		 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		FindDuplicate duplicate = new FindDuplicate(); 
		int arr[] = {1, 2, 3, 1, 3, 6, 6}; 
		int arr_size = arr.length; 

		duplicate.printRepeating(arr, arr_size); 
	} 
} 

