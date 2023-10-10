/*Leetcode Problem Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.*/
class Node
{
    int data;
    Node next;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    
    static class NodeWrapper
    {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
   
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
 
        return head;
    }
    public static void printList(String msg, Node head)
    {
        System.out.print(msg + ": ");
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
    {
        Node prev = null;
        while (curr.node != null && k-- > 0)
        {
            Node next = curr.node.next;
 
           
            curr.node.next = prev;
            prev = curr.node;
            curr.node = next;
        }
 
       
        return prev;
    }
    public static Node skipKNodes(Node curr, int k)
    {
        while (curr != null && k-- > 0) {
            curr = curr.next;
        }
        return curr;
    }
 
   
    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        // base case
        if (head == null) {
            return null;
        }
 
        Node originalHead = head;
 
       
        NodeWrapper curr = new NodeWrapper(head);
 
       
        head = reverse(curr, k);
        Node current = curr.node;
 
        
        originalHead.next = current;
 
        
        current = skipKNodes(current, k - 1);
 
        
        if (current != null) {
            current.next = reverseAlternatingKNodes(current.next, k);
        }
 
        
        return head;
    }
 
    public static void main(String[] args)
    {
        
        Node head = null;
 
        int n = 10;
        while (n > 0) {
            head = push(head, n--);
        }
 
        int k = 2;
 
        printList("Original linked list ", head);
        head = reverseAlternatingKNodes(head, k);
        printList("Resultant linked list", head);
    }
}
