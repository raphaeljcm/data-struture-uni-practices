package challenge01;

import Practice02.Ex02.Elemento;

public class DoublyLinkedList {
    private ListNode head;
    private  ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    private static class ListNode {
        private String data;
        private ListNode next;
        private ListNode previous;

        public ListNode(String data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if(head == null) { // list is empty
            return;
        }

        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if(tail == null) { // list is empty
            return;
        }

        ListNode temp = tail;

        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public String getCurrent(int position) {
        ListNode current = head;
        for(int i = 0; i < position; i++) {
            if(current.next != null) {
                current = current.next;
            }
        }

        return current.data;
    }

    public String getNext(int position) {
        ListNode current = head;
        for(int i = 0; i < position; i++) {
            if(current.next != null) {
                current = current.next;
            }
        }

        return current.next.data;
    }

    public void insertFirst(String value) {
        ListNode newNode = new ListNode(value);

        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(String value) {
        ListNode newNode = new ListNode(value);

        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public String getTail() {
        return tail.data;
    }

    public void sortList() {
        ListNode current, index;
        String temp;

        if(head == null) {
            return;
        } else {
            for(current = head; current.next != null; current = current.next) {
                for(index = current.next; index != null; index = index.next) {
                    if(current.data.compareTo(index.data) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }
}
