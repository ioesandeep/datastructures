package com.mum.algorithms;

import com.mum.algorithms.linkedlist.SingleLinkedList;

import com.mum.algorithms.queue.ArrayQueue;
import com.mum.algorithms.queue.exception.QueueIsEmptyException;
import com.mum.algorithms.queue.exception.QueueIsFullException;

import com.mum.algorithms.stack.ArrayStack;
import com.mum.algorithms.stack.exception.StackEmptyException;
import com.mum.algorithms.stack.exception.StackOverflowException;
import com.mum.algorithms.vector.ArrayVector;

public class Main {

    public static void fixedStackTest() {
        try {
            ArrayStack<Integer> stack = new ArrayStack<Integer>(10);
            stack.push(12);
            stack.push(2);
            stack.push(22);
            stack.push(21);
            stack.push(23);
            stack.push(24);
            stack.push(25);
            stack.push(26);
            stack.push(27);
            System.out.println(stack.getSize());
            System.out.println(stack.pop());
            stack.push(72);
            stack.push(62);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            stack.push(72);
            stack.push(62);
            System.out.println(stack.getSize());
            System.out.println(stack.top());
        } catch (StackOverflowException e) {
            System.out.println("Stack overflow: " + e.getMessage());
        } catch (StackEmptyException e) {
            System.out.println("Stack empty: " + e.getMessage());
        }

    }

    public static void fixedQueueTest() {
        try {
            ArrayQueue<Integer> queue = new ArrayQueue<>(10);
            queue.enqueue(20);
            System.out.println(queue.getFront());
            queue.dequeue();
            System.out.println(queue.getRear());
        } catch (QueueIsFullException e) {
            System.out.println(e.getMessage());
        } catch (QueueIsEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void vectorTest() {
        try {
            ArrayVector<Integer> vector = new ArrayVector<>(10);
            vector.insertAtRank(0, 90);
            vector.insertAtRank(1, 20);
            vector.insertAtRank(2, 32);
            vector.insertAtRank(3, 24);
            vector.insertAtRank(4, 23);
            vector.insertAtRank(5, 12);
            vector.insertAtRank(7, 45);
            vector.insertAtRank(6, 54);
            vector.insertAtRank(8, 63);
            vector.insertAtRank(7, 34);
            vector.insertAtRank(8, 36);
            vector.insertAtRank(9, 36);
            System.out.println(vector);
            System.out.println(vector.getSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void singleLinkedListTest() {
        try {
            SingleLinkedList list = new SingleLinkedList();
            System.out.println(list.insertFirst(20));
            System.out.println(list.insertFirst(30));
            System.out.println(list.insertLast(40));
            SingleLinkedList.Node node = list.insertLast(54);
            node = list.insertBefore(node, 23);
            SingleLinkedList.Node node1 = list.insertAfter(node, 36);
            list.swapElements(node,node1);
            list.remove(node1);
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        Main.linkedListTest();
//        Main.fixedStackTest();
//        Main.fixedQueueTest();
//        Main.vectorTest();
        Main.singleLinkedListTest();
    }
}
