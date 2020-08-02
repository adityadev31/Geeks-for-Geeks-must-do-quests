/**

url - https://leetcode.com/problems/odd-even-linked-list/

question - 1 indexed LL is given

we have to arrange it such that odd indexed elements remain left side 

and even indexed remain right side


**/


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
    
    public static Node makeList(){
        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
    
    public static void printLL(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Node solution(Node head){
        int count = 2;                                      // 1--> 4--> 5--> 3--> 2
        if(head == null || head.next == null || head.next.next == null) return head;
        Node prev=head, end=head, tail=head;
        
        while(end.next != null){ end = end.next; }         // getting the end pointer
        
        tail = end;
        
        while(prev != end.next && prev != end){     // stopping case for both even & odd cases
            tail.next = new Node(prev.next.data);   // append at the tail
            tail = tail.next;                       // increment tail 
            prev.next = prev.next.next;             // prev->next = prev->next->next;  connect index odd <--> odd
            prev = prev.next;                       // after connection move prev = prev->next
        }
        return head;
    }
    
    public static void main(String[] args) throws Exception {
        Node head = null;
        head = makeList();
        head = solution(head);        
        printLL(head);
    }
}



/**

  1 5 2 4 3 


**/
