package com.mum.algorithms.vector;

import com.mum.algorithms.vector.exception.RankOutOfBoundException;

public class ArrayVector<T> {
    private int size;
    private int capacity;
    private T[] vector;

    public ArrayVector(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.vector = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    protected boolean isRankValid(int rank) {
        return rank < capacity && rank > -1;
    }

    public void insertAtRank(int rank, T data) throws RankOutOfBoundException {
        if (!isRankValid(rank)) {
            throw new RankOutOfBoundException();
        }

        for (int i = capacity - 1; i > rank; i--) {
            vector[i] = vector[i - 1];
        }

        vector[rank] = data;
        ++size;
    }

    public T replaceAtRank(int rank, T data) throws RankOutOfBoundException {
        if (!isRankValid(rank)) {
            throw new RankOutOfBoundException();
        }

        T now = vector[rank];
        vector[rank] = data;
        return now;
    }

    public T removeAtRank(int rank) throws RankOutOfBoundException {
        if (!isRankValid(rank)) {
            throw new RankOutOfBoundException();
        }

        T now = vector[rank];
        for (int i = rank; i < capacity - 1; i++) {
            vector[i] = vector[i + 1];
        }

        return now;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (int i = 0; i < capacity; i++) {
            builder.append(vector[i]);
            builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
    }
}
