class GfG
{
    public static Node reverse(Node node, int k)
    {
        Node prev = null, ahead = null, current = node;
        int count = 0;
        while(current!=null && count<k){
            ahead = current.next;
            current.next = prev;
            prev = current;
            current = ahead;
            count++;
        }
        if(ahead!=null) node.next = reverse(ahead, k);
        return prev;
    }
}

/**

Original:	1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Reversed k:	4 3 2 1 8 7 6 5 12 11 10 9 14 13 

**/
