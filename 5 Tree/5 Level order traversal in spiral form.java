/*

Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105

*/





/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Spiral
{
      void printSpiral(Node node) 
      {
          if(node == null) return;
          
           Queue<Node> q = new LinkedList<>();                       // queue for level order
           boolean reverse = true;                                   // to check if the level should be reverse
           ArrayList<ArrayList<Integer>> list = new ArrayList<>();   // to store final list
           StringBuilder sb = new StringBuilder();                   // to store the final answer to display
           Node temp = null;                             
           int size = 0;
           
           q.add(node);
           while(!q.isEmpty()){
               size = q.size();
               Integer[] level = new Integer[size];  // to store the current level elements
               for(int i=0; i<size; i++){
                   temp = q.poll();
                   if(reverse) level[size-1-i] = temp.data;   // if reverse insert reverse in array
                   else level[i] = temp.data;                 // if not insert normal
                   if(temp.left!=null) q.add(temp.left);
                   if(temp.right!=null) q.add(temp.right);
               }
               list.add(new ArrayList<>(Arrays.asList(level)));
               reverse = !reverse;              // swap the value of reverse after each level
           }
           for(ArrayList<Integer> x : list){
               for(int y : x) sb.append(y + " ");
           }
           System.out.print(sb);
      }
}








/*  ========== SAME THING BUT SMALLER ========== */

class Spiral
{
      ArrayList<Integer> findSpiral(Node node) 
      {
           ArrayList<Integer> ans = new ArrayList<>();
           if(node == null) return ans;
           Queue<Node> q = new LinkedList<>();
           boolean reverse = true;
           int size = -1;
           Node x = null;
           q.add(node);
           while(!q.isEmpty()){
               size = q.size();
               int[] arr = new int[size];
               for(int i=0; i<size; i++){
                   x = q.poll();
                   if(!reverse) arr[i] = x.data;
                   if(reverse) arr[size-i-1] = x.data;
                   if(x.left!=null) q.add(x.left);
                   if(x.right!=null) q.add(x.right);
               }
               for(int ele : arr) ans.add(ele);
               reverse = !reverse;
           }
           return ans;
      }
}
