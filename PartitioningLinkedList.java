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

    

    static void partition(Node head,int x){
        Node curr = head;

        Node h1 = null;
        Node t1 = null;

        Node h2 = null;
        Node t2 = null;

        while(curr!=null){
            if(curr.data<x){
                if(h1==null){
                    h1 = curr;
                    t1 = curr;
                } else {
                    t1.next = curr;
                    t1 = curr;
                }
            } else {
                if(h2==null){
                    h2 = curr;
                    t2 = curr;
                } else {
                    t2.next = curr;
                    t2 = curr;
                }
            }
            curr = curr.next;
        }

        t1.next = h2;
        t2.next = null;

        Node ans = h1;

        while(ans!=null){
            System.out.print(ans.data+" ");
            ans = ans.next;
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
            //list.add(sc.nextInt());
            list.addToLast(new Node(sc.nextInt()));
        }

        int x = sc.nextInt();
        

        // Partitioning a Linked List
        LinkedList.partition(list.head,x);
	}
}
