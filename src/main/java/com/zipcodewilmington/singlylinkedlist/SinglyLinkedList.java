package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    private Node<T> head; //null cause I didnt make an instance of the object aka Node node = new Node(info);

    // Node class representing each element in the singly linked list

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

    public Node<T> get(int index) {
        Node<T> currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (count == index){
                return currentNode;
            }
            count++;
            currentNode = currentNode.next;
        }
        return null;
    }
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        int listSize = size();
        boolean swapped;

        for (int i = 0; i < listSize - 1; i++) {
            Node<T> currentNode = head;
            Node<T> nextNode = head.next;
            Node<T> previousNode = null;
            swapped = false;

            for (int j = 0; j < listSize - 1 - i; j++) {
                if (currentNode.value.compareTo(nextNode.value) > 0) {
                    swapped = true;

                    if (previousNode != null) {
                        previousNode.next = nextNode;
                    } else {
                        head = nextNode;
                    }

                    currentNode.next = nextNode.next;
                    nextNode.next = currentNode;

                    previousNode = nextNode;
                    nextNode = currentNode.next;
                } else {
                    previousNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
         if (head == null) {
             return newList;
         }
         newList.head = new Node<T>(head.value);
         Node<T> original = head.next;
         Node<T> copy = newList.head;

         while (original != null) {
             copy.next = new Node<T>(original.value);
             original = original.next;
             copy = copy.next;
        }
         return newList;
    }
}

