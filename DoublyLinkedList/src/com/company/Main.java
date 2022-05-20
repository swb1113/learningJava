package com.company;

public class Main {

    public static void main(String[] args) {
       doublyLinkedList list = new doublyLinkedList();
       list.insertFirst(4);
       list.insertFirst(3);
       list.insertFirst(2);
       list.insertFirst(1);
       list.delete_firstValue(2);
       list.delete_at(1);
       list.reverseList();
       list.displayForward();

    }
}
