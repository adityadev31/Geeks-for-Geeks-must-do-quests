/* 
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.


Example 1:

Input :      
           3                               
         /    \                          
       4       5                     
      /  \      
    -10   4                          

Output: 16

Explanation :
Maximum Sum lies between leaf node 4 and 5.
4 + 4 + 3 + 5 = 16.

Example 2:

Input :    
            -15                               
         /      \                          
        5         6                      
      /  \       / \
    -8    1     3   9
   /  \              \
  2   -3              0
                     / \
                    4  -1
                       /
                     10  

Output :  27

Explanation:
The maximum possible sum from one leaf node 
to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)

Your Task:  
You dont need to read input or print anything. Complete the function maxPathSum() which takes root node as input parameter and returns the maximum sum between 2 leaf nodes.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 10^4

*/




class Tree
{
    private int maxVal = Integer.MIN_VALUE;                                  // stores leaf-to-leaf max value
    
    int helper(Node root){
        if(root == null) return 0;                                           // root (null) case
        if(root.left == null && root.right == null) return root.data;        // (null null) case
        int ls = helper(root.left);                                          // left branch
        int rs = helper(root.right);                                         // right branch
        if(root.left != null && root.right != null) {                        // (notnull notnull) case
            maxVal = Integer.max(maxVal, ls+rs+root.data);                   // updating leaf-to-leaf val (ls+root.data+rs = leaf-to-leaf) (current node as root case)
            return Integer.max(ls, rs)+root.data;                            // return (current node as a part of the maxpath) case
        }
        return (root.left != null) ? ls+root.data : rs+root.data;            // (notnull null) or vice-versa case
    }
    
    int maxPathSum(Node root)
    { 
        helper(root);
        return maxVal;
    } 
}







/* ================== ANOTHER EXPANATION ===================== */

class Tree
{
    private int maxVal;                     // this will store leaf-to-leaf path sums 
    Tree(){ maxVal = Integer.MIN_VALUE; }
    
    int helper(Node root){
        if(root == null) return 0;
        if(root.left==null && root.right==null) return root.data;   // leaf node
        int ls = helper(root.left);
        int rs = helper(root.right);
        int case1 = ls+rs+root.data;                // current node as root (leaf to leaf)
        int case2 = Integer.max(ls,rs)+root.data;   // current node is in the path (hence max(ls, rs))
        if(root.left != null && root.right != null){
            maxVal = Integer.max(case1, maxVal);    // coz maxVal will store only leaf to leaf
            return case2;                           // coz case2 is the case where we would need to pass on the value to the parent
        }
        return (root.left != null) ? (ls+root.data) : (rs+root.data);  // (null  notnull) case
    }
    
    int maxPathSum(Node root)
    { 
        helper(root);
        return maxVal;
    } 
}
