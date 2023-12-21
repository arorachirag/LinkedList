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
            list.add(sc.nextInt());
        }

        int val = sc.nextInt();
        int pos = sc.nextInt();

        Node head = list.insert(list.head,n,val,pos);
        list.print(head);
        // while (head != null) {
        //     System.out.print(head.data + " ");
        //     head = head.next;
        // }
	}
}
