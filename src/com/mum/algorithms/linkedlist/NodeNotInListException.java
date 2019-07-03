package com.mum.algorithms.linkedlist;

public class NodeNotInListException extends Exception{
    public NodeNotInListException(){
        super("Node was not found in list.");
    }
}
