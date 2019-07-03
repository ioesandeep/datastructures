package com.mum.algorithms.linkedlist;

/**
 * A simple single linked list
 * find, insert and remove take O(n)
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {
    public Node<T> head;
    public int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public class Node<T> {
        private T value;
        public Node<T> next;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value stored is: " + this.value;
        }
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        node.next = null;

        ++size;

        if (head == null) {
            head = node;
            return;
        }

        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
    }

    public void print() {
        Node<T> start = head;
        while (start != null) {
            System.out.println(start);
            start = start.next;
        }
    }

    public boolean remove(T key) {
        if (head.value.equals(key)) {
            --size;
            head = head.next;
            return true;
        }

        Node<T> next = head.next;
        Node<T> prev = next;
        while (next != null) {
            if (next.value.equals(key)) {
                prev.next = next.next;
                --size;
                return true;
            }

            prev = next;
            next = next.next;
        }

        return false;
    }

    public Node<T> find(T data) {
        if (head.value.equals(data)) {
            return head;
        }

        Node<T> current = head.next;
        while (current != null) {
            if (current.value.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean swap(T a, T b) {
        Node<T> nodeA = find(a);
        Node<T> nodeB = find(b);
        if (nodeA == null || nodeB == null) {
            return false;
        }

        nodeA.value = b;
        nodeB.value = a;
        return true;
    }

    public boolean replace(T a, T b) {
        Node<T> nodeA = find(a);
        if (nodeA == null) {
            return false;
        }

        nodeA.value = b;
        return true;
    }

    public SinglyLinkedList<T> sorted() {
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
