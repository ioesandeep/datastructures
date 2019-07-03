package com.mum.algorithms;

public class Main {

    public static void linkedListTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(20);
        list.insert(30);
        list.insert(50);
        list.insert(40);
        list.insert(60);
        list.print();
        System.out.println("Remove 20 from head");
        list.remove(20);
        list.print();
        System.out.println("Remove 40 from middle");
        list.remove(40);
        list.print();
        System.out.println("Remove 60 from end");
        list.remove(60);
        list.print();
        System.out.println(list.find(30));
        System.out.println(list.find(50));
        list.insert(100);
        list.insert(200);
        list.insert(15);
        list.insert(95);
        list.print();
        System.out.println(list.swap(15, 50));
        list.print();
        System.out.println("Replace");
        System.out.println(list.replace(200, 65));
        System.out.println(list.replace(100, 12));
        list.print();
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
    }

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

    public static void main(String[] args) {
//        Main.linkedListTest();
//        Main.fixedStackTest();
        Main.fixedQueueTest();
    }
}
