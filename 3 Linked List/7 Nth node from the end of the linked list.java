import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    
    
    public static int nthNode(Node head, int n){
        Node f = head;
        Node p = head;
        
        // keeping distance b/w (p & f) then traversing both
        
        for(int i=0; i<n-1; i++){
            f = f.next;
            if(f == null) return -1;
        }
        
        while(f.next != null){
            p = p.next;
            f = f.next;
        }
        return p.data;
    }
    
    public static void main(String[] args) throws Exception {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        
        
        System.out.println(nthNode(head, 2));
        
    }
}

/**
  list - 1 2 3 4 5 6 7 8 9   k=2
  ans = 8
**/ 
