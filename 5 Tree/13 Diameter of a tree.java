/**

Given a Binary Tree, find diameter of it.
+The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:Output:
For each testcase, in a new line, print the diameter.

Your Task:
You need to complete the function diameter() that takes node as parameter and returns the diameter.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000

Example:
Input:
2
1 2 3
10 20 30 40 60 

Output:
3
4

Explanation:
Testcase1: The tree is
        1
     /      \
   2        3
The diameter is of 3 length.
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
The diameter is of 4 length.


**/


/**

	there are 2 cases :-
	
	case1 - dia passes via root --->  left height + right height + 1(for root)
	
	case2 - dia not passes via root i.e, dia is in either left subtree or right subtree ---> Math.max(left dia, right dia)

**/



class Tree {
    
    int height(Node root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r)+1;
    }
    
    int diameter(Node root) {
        if(root == null) return 0;
        int l_ht = height(root.left);      // left  height
        int r_ht = height(root.right);     // right height
        int l_dia = diameter(root.left);   // left  dia
        int r_dia = diameter(root.right);  // right dia
        int case1 = (l_ht + r_ht + 1);          // dia passes via root (left height + rightheight + 1)
        int case2 = Math.max(l_dia, r_dia);     // dia not passes via root (max of left dia and right dia)
        return Math.max(case1, case2);
    }
}
