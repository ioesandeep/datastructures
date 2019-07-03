package com.mum.algorithms.linkedlist;

public class NodeIsTailException extends Exception {
    public NodeIsTailException() {
        super("List is tail");
    }
}
