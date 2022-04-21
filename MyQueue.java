package com.company;

public class MyQueue<T extends Comparable<T>> implements ProList<T> {

    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T peek() {
        if (list.size() == 0) {
            return null;
        }

        return (T) list.get(0);
    }

    @Override
    public void print() {
        list.ShowList();
    }

    public T enqueue(T item) {
        if (item == null) {
            return null;
        }

        list.add(item);
        return item;
    }

    public T dequeue() {
        T removedItem = list.get(0);
        list.remove(removedItem);
        return removedItem;
    }
}