import java.util.*;

class Node{
    int data;
    Node next;
    Node(int x){
        this.data = x;
        this.next = null;
    }
}

public class Main {
    
    public static void printlist(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    // recursive function to reverse the given portion of the list
    public static Node reverseK(Node head, int k){
        if(k == 1 || head.next == null) return head;
        Node newHead = reverseK(head.next, k-1);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    // driver code for reversing list
    public static Node reverseDrive(Node head, int k){
        Stack<Node> low = new Stack<Node>();
        Stack<Node> low1 = new Stack<Node>();
        Stack<Node> high = new Stack<Node>();
        
        // storing lows and highs        low and low1 = 13 9 5 1
        //                                       high = 14 12 8 4
        int i=1;
        Node temp = head;
        while(temp != null){
            if(i == 1){
                low.push(temp);
                low1.push(temp);
            }
            if(i == k || temp.next == null){
                high.push(temp);
                i = 0;
            }
            i++;
            temp = temp.next;
        }
        
        // reversing list in k using low1
        while(low1.size() > 0) temp = reverseK(low1.pop(), k);
        
        
        // connecting low to high       
        if(low.size() > 0) low.pop();                       //  removing last element of low 13
        while(low.size() > 0) low.pop().next = high.pop();  //  connecting  ( 9->14  5->12  1->8 ) 
        return high.pop();                                  //  return last high = 4
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
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        
        System.out.print("Original:\t");
        printlist(n1);
        System.out.println();
        
        Node head = reverseDrive(n1, 4);
        System.out.print("Reversed k:\t");
        printlist(head);
    }
}


/**

Original:	1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Reversed k:	4 3 2 1 8 7 6 5 12 11 10 9 14 13 

**/
