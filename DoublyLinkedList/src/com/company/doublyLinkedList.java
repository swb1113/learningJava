package com.company;

import java.util.List;
import java.util.NoSuchElementException;

public class doublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }

        public void displayData() {
            System.out.print(data + " ");
        }
    }

    public doublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    // method for inserting new node at the front
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // method for inserting new node at the end
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    // method for deleting first node
    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    //method for deleting last node
    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    // Method for forward traversal/display list
    public void displayForward() {
        System.out.println("Forward display");
        ListNode current = head;
        while (current != null) {
            current.displayData();
            current = current.next;
        }
        System.out.println("");
    }

    // Method to traverse and display all nodes
    public void displayBackward() {
        System.out.println("Backward display");
        ListNode current = tail;
        while (current != null) {
            current.displayData();
            current = current.previous;
        }
        System.out.println("");
    }

    // reversing doubly linked list
    public void reverseList() {
        ListNode previous = null;
        //change head to tail in reversal
        tail = head;
        ListNode current = head;
        while (current != null) {
            // swap previous and next for the current node
            previous = current.previous;
            current.previous = current.next;
            current.next = previous;
            // to move to next node current.previous has to be called
            // as that is techincally next now.
            current = current.previous;
        }
        if (previous != null) {
            head = previous.previous;
        }
    }

    // deleting at specific position (starting from position 1 ...)
    public void delete_at(int position) {

        // check if the position is > 0
        if(position < 1) {
            System.out.print("position should be >= 1.");
        } else if (position == 1 && head != null) {

            // if the position is 1 and head is not null,
            // head next --> head, delete previous head
            ListNode nodeToDelete = head;
            head = head.next;
            nodeToDelete = null;
            if (head != null)
                head.previous = null;
        } else {

            // Else, create temp node and traverse to the
            // node previous to the position
            ListNode temp = head;
            for(int i = 1; i < position-1; i++) {
                if(temp != null) {
                    temp = temp.next;
                }
            }

            // If the previous node and next of the previous
            // is not null, will adjust links
            if(temp != null && temp.next != null) {
                ListNode nodeToDelete = temp.next;
                temp.next = temp.next.next;
                if(temp.next.next != null)
                    temp.next.next.previous = temp.next;
                nodeToDelete = null;
            } else {

                // Else given node will be empty.
                System.out.print("\nThe node is already null.");
            }
        }
    }

    void delete_firstValue(int key) {
        ListNode temp = head;
        if(temp != null) {

            // if head is not null and value at head
            // is the same as the key, head next = head,
            // delete previous head, then adjust previous of head
            if(temp.data == key) {
                ListNode nodeToDelete = head;
                head = head.next;
                nodeToDelete = null;
                if (head != null)
                    head.previous = null;
            } else {

                // traverse to the node previous to the
                // node with value equal to key, and adjust links
                while(temp.next != null) {
                    if(temp.next.data == key) {
                        ListNode nodeToDelete = temp.next;
                        temp.next = temp.next.next;
                        if(temp.next != null)
                            temp.next.previous = temp;
                        nodeToDelete = null;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }
}

