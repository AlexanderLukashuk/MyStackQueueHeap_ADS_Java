package com.company;

public interface ProList<T> {
    public boolean empty();
    public int size();
    public T peek();
    public void print();
}