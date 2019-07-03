package com.mum.algorithms;

public class ArrayStack<T> {
    private int size;
    private int maxSize;
    private T[] items;

    public ArrayStack(int maxSize) {
        items = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T push(T data) throws StackOverflowException {
        if (size >= maxSize) {
            throw new StackOverflowException("Stack is full");
        }

        items[size++] = data;
        return data;
    }

    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty.");
        }
        return items[--size];
    }

    public T top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty.");
        }
        return items[size - 1];
    }
}
