package com.mum.algorithms.queue;

import com.mum.algorithms.queue.exception.QueueIsEmptyException;
import com.mum.algorithms.queue.exception.QueueIsFullException;

/**
 * A simple array based implementation of a queue
 * Runtime for enqueue and dequeue is O(1)
 * @param <T>
 */
public class ArrayQueue<T> {
    int rear;
    int front;
    int size;
    int maxSize;
    T[] queue;

    public ArrayQueue(int maxSize) {
        rear = maxSize - 1;
        front = size = 0;
        this.maxSize = maxSize;
        queue = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T data) throws QueueIsFullException {
        if (isFull()) {
            throw new QueueIsFullException();
        }

        rear = (rear + 1) % maxSize;
        queue[rear] = data;
        ++size;
    }

    public T dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException();
        }

        T data = queue[front];
        front = (front + 1) % maxSize;
        --size;
        return data;
    }

    public T getFront() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException();
        }

        return queue[front];
    }

    public T getRear() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException();
        }

        return queue[rear];
    }
}
