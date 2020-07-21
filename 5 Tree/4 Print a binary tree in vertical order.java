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

class Pair{
    Node node;
    int hd;
    Pair(Node x, int y){
        this.node = x;
        this.hd = y;
    }
}

class BinaryTree
{
    static HashMap<Integer, ArrayList<Integer>> map;
    
    static void insertIntoMap(HashMap<Integer, ArrayList<Integer>> mp, int key, int value){
        if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());
        mp.get(key).add(value);
    }
    
    static void levelOrder(Node root, HashMap<Integer, ArrayList<Integer>> map){
    
        Queue<Pair> q = new LinkedList<>(); // initializations
        int hd = 0;
        
        q.add(new Pair(root, hd));           // for root
        insertIntoMap(map, hd, root.data);
        
        while(!q.isEmpty()){
            Pair x = q.poll();
            if(x.node.left!=null){
                q.add(new Pair(x.node.left, x.hd-1));
                insertIntoMap(map, x.hd-1, x.node.left.data);
            }
            if(x.node.right!=null){
                q.add(new Pair(x.node.right, x.hd+1));
                insertIntoMap(map, x.hd+1, x.node.right.data);
            }
        }
        
    }
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        map = new HashMap<Integer, ArrayList<Integer>>();
        levelOrder(root, map);
        
        ArrayList<Map.Entry<Integer, ArrayList<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, ArrayList<Integer>>>(){
            public int compare(Map.Entry<Integer, ArrayList<Integer>> e1, Map.Entry<Integer, ArrayList<Integer>> e2){
                return e1.getKey()-e2.getKey();
            }
        });
        
        ArrayList<Integer> l1 = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> x : list){
            for(int y : x.getValue()) l1.add(y);
        }
        
        return l1;
    }
}
