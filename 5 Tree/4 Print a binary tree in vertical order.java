/**

    LEVEL ORDER APPROACH
    
    hd = keeps track of distance from root
    
    we need both parent node and parent's hd hence store Pair(node, hd)     Pair(node, hd)
    
    we need map to map nodes with hds         Map<hd, listOfNodes>
    
    step1 - q.add(Pair(parentNode->left, parentNode's hd-1))    // for left  hd-1
          - q.add(Pair(parentNode->right, parentNode's hd+1))    // for left  hd+1
    
    step2 - update in map     map.put(new hd, node);

**/


/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/

static class Pack {
        Node n;
        int h;
        Pack(Node n, int h) {
            this.n = n;
            this.h = h;
        }
    }
static ArrayList <Integer> verticalOrder(Node root) {
    if(root == null) return new ArrayList<Integer>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    Queue<Pack> q = new LinkedList<>();
    q.add(new Pack(root, 0));
    Pack temp = null;
    int min = Integer.MAX_VALUE;    // keeping track of min height and max height
    int max = Integer.MIN_VALUE;
    while(q.size()!=0) {
        temp = q.poll();
        if(temp.h < min) min = temp.h;
        if(temp.h > max) max = temp.h;
        if(!map.containsKey(temp.h))
            map.put(temp.h, new ArrayList<Integer>());
        map.get(temp.h).add(temp.n.data);
        if(temp.n.left!=null) 
            q.add(new Pack(temp.n.left, temp.h-1));
        if(temp.n.right!=null) 
            q.add(new Pack(temp.n.right, temp.h+1));
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=min; i<=max; i++) {               // iterating from min -> max
        if(map.containsKey(i)) {
            for(int ele: map.get(i))
                ans.add(ele);
        }
    }
    return ans;
}






























// class Pair{
//     Node node;
//     int hd;
//     Pair(Node x, int y){
//         this.node = x;
//         this.hd = y;
//     }
// }

// class BinaryTree
// {
//     static HashMap<Integer, ArrayList<Integer>> map;
    
//     static void insertIntoMap(HashMap<Integer, ArrayList<Integer>> mp, int key, int value){
//         if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());
//         mp.get(key).add(value);
//     }
    
//     static void levelOrder(Node root, HashMap<Integer, ArrayList<Integer>> map){
    
//         Queue<Pair> q = new LinkedList<>(); // initializations
//         int hd = 0;
        
//         q.add(new Pair(root, hd));           // for root
//         insertIntoMap(map, hd, root.data);
        
//         while(!q.isEmpty()){
//             Pair x = q.poll();
//             if(x.node.left!=null){
//                 q.add(new Pair(x.node.left, x.hd-1));
//                 insertIntoMap(map, x.hd-1, x.node.left.data);
//             }
//             if(x.node.right!=null){
//                 q.add(new Pair(x.node.right, x.hd+1));
//                 insertIntoMap(map, x.hd+1, x.node.right.data);
//             }
//         }
        
//     }
    
//     static ArrayList <Integer> verticalOrder(Node root)
//     {
//         map = new HashMap<Integer, ArrayList<Integer>>();
//         levelOrder(root, map);
        
//         ArrayList<Map.Entry<Integer, ArrayList<Integer>>> list = new ArrayList<>(map.entrySet());
//         Collections.sort(list, new Comparator<Map.Entry<Integer, ArrayList<Integer>>>(){
//             public int compare(Map.Entry<Integer, ArrayList<Integer>> e1, Map.Entry<Integer, ArrayList<Integer>> e2){
//                 return e1.getKey()-e2.getKey();
//             }
//         });
        
//         ArrayList<Integer> l1 = new ArrayList<>();
//         for(Map.Entry<Integer, ArrayList<Integer>> x : list){
//             for(int y : x.getValue()) l1.add(y);
//         }
        
//         return l1;
//     }
// }



/**

                    -- A L S O --
                    



class BinaryTree
{
    static class Pair{
        Node N;
        int lev;
        Pair(Node N, int lev){
            this.N = N;
            this.lev = lev;
        }
    }
    
    static class MapSort implements Comparator<Map.Entry<Integer, ArrayList<Integer>>>{
        public int compare(Map.Entry<Integer, ArrayList<Integer>> e1, Map.Entry<Integer, ArrayList<Integer>> e2){
            return e1.getKey()-e2.getKey();
        }
    }
    
    static ArrayList<Integer> levelOrder(Node root){
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        q.add(new Pair(root, 0));
        map.put(0, new ArrayList<>());
        map.get(0).add(root.data);
        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.lev;
            Node N = p.N;
            if(N.left != null){
                q.add(new Pair(N.left, l-1));
                if(!map.containsKey(l-1)) map.put(l-1, new ArrayList<>());
                map.get(l-1).add(N.left.data);
            }
            if(N.right != null){
                q.add(new Pair(N.right, l+1));
                if(!map.containsKey(l+1)) map.put(l+1, new ArrayList<>());
                map.get(l+1).add(N.right.data);
            }
        }
        
        // sort
        ArrayList<Map.Entry<Integer, ArrayList<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MapSort());
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> x: list){
            for(int y : x.getValue()) ans.add(y);
        }
        return ans;
    }
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        return levelOrder(root);
    }
}




**/
