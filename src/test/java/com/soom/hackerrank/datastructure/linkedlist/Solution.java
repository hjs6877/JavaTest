package com.soom.hackerrank.datastructure.linkedlist;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-02-10 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class Solution {
    private static Node nextNode;
    public static  Node insert(Node head,int data) {
        if(head == null){
            return new Node(data);
        }else{
            if(head.next == null){
                head.next = new Node(data);
                nextNode = head.next;
            }else{
                while(nextNode.next != null){
                    nextNode = nextNode.next;
                }
                nextNode.next = new Node(data);
            }
        }
        //Complete this method
        return head;
    }

    public static void display(Node head){
        Node start = head;
        while(start != null){
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();

        while(n-- > 0){
            int data = sc.nextInt();
            head = insert(head, data);
        }

        display(head);
        sc.close();
    }
}
