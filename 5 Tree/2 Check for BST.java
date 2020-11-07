/*  ============ BEST WAY =============== */


// return true if the given tree is a BST, else return false
public class Tree
{    
    boolean isBSTHelper(Node root, int min, int max){
        if(root == null) return true;                         // base case
        if(root.data < min || root.data > max) return false;  // violation of BST RULE = false
        return (isBSTHelper(root.left, min, root.data-1) && isBSTHelper(root.right, root.data+1, max)); // resursion
    }
    
    boolean isBST(Node root){
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}














/**

  A P P R O A C H -
  
  step1 - apply inorder and store root data in an arraylist
  step2 - check if arraylist is in sorted order or not (i.e, a[i+1] <= a[i]

**/



public class Tree
{
    static List<Integer> list = new ArrayList<>();
    
    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    
    boolean isBST(Node root)
    {
        list.clear();
        inorder(root);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
}
