package com.mum.algorithms.queue.exception;

public class QueueIsEmptyException extends Throwable {
    public QueueIsEmptyException(){
        super("Queue is empty");
    }
}
