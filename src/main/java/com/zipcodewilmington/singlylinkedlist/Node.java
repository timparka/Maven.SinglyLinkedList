package com.zipcodewilmington.singlylinkedlist;

public class Node<T>{
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
