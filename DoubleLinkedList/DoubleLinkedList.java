package DoubleLinkedList;

import LinkedList.Node;

public class DoubleLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode createLinkedList (int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = null;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1 ){
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("\n");
        }
    }

    public void reverseTraverseLinkedList() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1 ){
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
            System.out.print("\n");
        }
    }

    public boolean searchNode(int nodeValue) {
        if (head == null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            if (location == 0) {
                head = head.next;
                head.prev = null;
            } else if (location >= size) {
                System.out.println("Invalid location");
            } else {
                DoublyNode tempNode = head;
                int index = 0;
                while (index < location - 1) {
                    tempNode = tempNode.next;
                    index++;
                }
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
            }
            size--;
        }
    }
}
