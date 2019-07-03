package com.mum.algorithms.queue.exception;

public class QueueIsFullException extends Throwable {
    public QueueIsFullException() {
        super("Queue is full");
    }
}
