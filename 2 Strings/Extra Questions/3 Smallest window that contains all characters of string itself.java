// url - https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

/**
  Approach - 

  1) add chars in a set
  2) make a window of set size and let set size = ST and set.clear()
  3) iterate over the string with that window(size = ST) and if chars in window are distinct then print the window

  T = O(n)
**/
