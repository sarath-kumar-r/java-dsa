package com.skr.dsa.implementation;

class DNode {
    int data;
    DNode next;
    DNode prev;

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.display();
    }
    DNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void display() {
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
