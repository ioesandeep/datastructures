package com.mum.algorithms.linkedlist;

public class SingleLinkedList {
    int size;
    Node head;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public SingleLinkedList() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFirst(Node node) throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        return head == node;
    }

    public boolean isLast(Node node) throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        return node.next == null;
    }

    public Node first() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        return head;
    }

    public Node last() throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    public Node after(Node node) throws ListIsEmptyException, NodeIsTailException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        if (node.next == null) {
            throw new NodeIsTailException();
        }

        return node.next;
    }

    public Node before(Node node) throws ListIsEmptyException, NodeIsHeadException, NodeNotInListException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        if (node == head) {
            throw new NodeIsHeadException();
        }

        Node start = head.next;
        while (start != null) {
            if (start.next == node) {
                return start;
            }
            start = start.next;
        }

        throw new NodeNotInListException();
    }

    public Node insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;

        ++size;

        return head;
    }

    public Node insertLast(int data) {
        Node node = new Node(data);
        try {
            Node last = last();
            last.next = node;
            ++size;
        } catch (ListIsEmptyException e) {
            return insertFirst(data);
        }

        return node;
    }

    public Node insertAfter(Node node, int data) throws ListIsEmptyException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;

        ++size;

        return newNode;
    }

    public Node insertBefore(Node node, int data) throws ListIsEmptyException, NodeNotInListException {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }

        Node newNode = new Node(data);
        newNode.next = node;

        try {
            Node before = before(node);
            before.next = newNode;
        } catch (NodeIsHeadException e) {
            head = newNode;
        }
        return newNode;
    }

    public boolean remove(Node node) throws ListIsEmptyException, NodeNotInListException {
        if (node == first()) {
            head = null;
            --size;
            return true;
        }

        Node start = head;
        while (start != null) {
            if (start.next == node) {
                start.next = start.next.next;
                --size;
                return true;
            }
            start = start.next;
        }

        return false;
    }

    public boolean swapElements(Node p, Node q) throws NodeNotInListException, ListIsEmptyException {
        try {
            Node before = before(p);
            before.next = q;
            p.next = q.next;
            q.next = p;
        } catch (NodeIsHeadException e) {
            Node next = p.next;
            p.next = q.next;
            q.next = next;
        }
        return true;
    }

    public String toString() {
        Node start = head;

        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        while (start != null) {
            builder.append(start.data);
            builder.append(", ");
            start = start.next;
        }
        builder.append("}");
        return builder.toString();
    }
}
