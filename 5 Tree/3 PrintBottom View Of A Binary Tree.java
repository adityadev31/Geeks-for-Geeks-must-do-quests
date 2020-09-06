/*    url - https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1



Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
 

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

Thus nodes of the binary tree will be
printed as such 3 1 2.

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30

Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105


*/




/*

  A P P R O A C H - 
  
  - use levelorder traversal method B U T
  - instead of inserting nodes in the queue --> insert a pair of vertical levels of nodes (root = 0, left->parent level-1, right->parent level+1)
  - also while inserting new nodes in the queue --> keep updating a map of (VerticalLevel and Node)

*/


class Tree
{
 
    class Pair{
        int lev;
        Node N;
        Pair(Node N, int lev){
            this.N = N;
            this.lev = lev;
        }
    }
 
    public HashMap<Integer, Node> map;
    
    public class MapSort implements Comparator<Map.Entry<Integer, Node>>{
        public int compare(Map.Entry<Integer, Node> e1, Map.Entry<Integer, Node> e2){
            return e1.getKey()-e2.getKey();
        }
    }
 
    // Method that returns the bottom view.
    
    public ArrayList<Integer> levelorder(Node root){
        map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        map.put(0, root);
        while(!q.isEmpty()){
            Pair p = q.poll();          // parent pair
            Node n = p.N;               // parent node
            int l  = p.lev;             // parent level
            if(n.left != null){
                q.add(new Pair(n.left, l-1)); // insert pair (L-1)
                map.put(l-1, n.left);         // update map
            }
            if(n.right != null){
                q.add(new Pair(n.right, l+1)); // insert pair (L+1)
                map.put(l+1, n.right);         // update map
            }
        }
        
        // sorting map
        ArrayList<Map.Entry<Integer, Node>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MapSort());
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Node> x: list) ans.add(x.getValue().data);
        return ans;
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        return levelorder(root);
    }
}
