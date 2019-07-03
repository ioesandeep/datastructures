package com.mum.algorithms;

public class QueueIsFullException extends Throwable {
    QueueIsFullException(){
        super("Queue is full");
    }
}
