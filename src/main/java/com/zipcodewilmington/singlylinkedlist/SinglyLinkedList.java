package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    private Node<T> head; //null cause I didnt make an instance of the object aka Node node = new Node(info);

    // Node class representing each element in the singly linked list
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void remove(T value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public boolean contains(T value) {
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public int find(T value) {
        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    public int size() {
        Node<T> currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    public int get(int index) {
        Node<T> currentNode = head;
        while (currentNode != null) {

        }
        return 0;
    }

    public void print() {
        Node<T> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList listy = new SinglyLinkedList();

        listy.add(9);
        listy.add(8);
        listy.add(7);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.print();

        list.remove(3);

        list.print();

        System.out.println("Contains 3? " + list.contains(3));
        System.out.println("Contains 2? " + list.contains(2));
        System.out.println("Index of number? " + list.find(2));
        System.out.println("How large is the list? " + list.size());
        System.out.println("Value at index: " + list.get(2));
    }
}

