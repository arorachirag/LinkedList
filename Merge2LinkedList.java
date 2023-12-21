import java.util.*;
import java.lang.*;
import java.io.*;


class Node
{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}

class LinkedList
{
    Node head;
    Node tail;
    void add(int data){
        Node new_node = new Node(data);
        if(head==null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }

        curr.next = new_node;
        return;
    }

    void addToLast(Node node){
        if(head==null){
            head = node;
            tail = node;
            
        } else {
            tail.next = node;
            tail = node;
        }
        
    }

    Node insert(Node head,int n,int val,int pos){
        Node new_node = new Node(val);

        if(pos==0){
            new_node.next = head;
            head = new_node;
            return head;
        }
        Node curr = head;
        int point = pos-1;
        while(point>0){
            curr = curr.next;
            point--;
        }

        new_node.next = curr.next;
        curr.next = new_node;

        return head;
    }

    void print(Node curr){
        
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }

        
    }

    Node middle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    static Node mergeList(Node x,Node y){
        if(x==null) return y;

        if(y==null) return x;
        Node curr = null;

        if(x.data<=y.data){
            curr = x;
            curr.next = mergeList(x.next,y);
        } else {
            curr = y;
            curr.next = mergeList(x,y.next);
        }

        return curr;
    }
    
}


public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList list = new LinkedList();
        for(int i=0;i<n;i++){
            //list.add(sc.nextInt());
            list.addToLast(new Node(sc.nextInt()));
        }

        LinkedList list1 = new LinkedList();
        for(int i=0;i<n;i++){
            //list.add(sc.nextInt());
            list1.addToLast(new Node(sc.nextInt()));
        }

        Node merge = LinkedList.mergeList(list.head,list1.head);
        
        // int val = sc.nextInt();
        // int pos = sc.nextInt();

        // Node head = list.insert(list.head,n,val,pos);

        //Node mid = list.middle(list.head);
        list.print(merge);
        // while (head != null) {
        //     System.out.print(head.data + " ");
        //     head = head.next;
        // }
	}
}
