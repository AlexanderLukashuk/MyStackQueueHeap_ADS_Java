package com.company;

import java.util.Arrays;
import java.util.List;

public class ArrayHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;
    private int size;
    private int maxsize;

    public ArrayHeap() {
//        list = new MyLinkedList<>();
        list = new MyArrayList<>();
        this.maxsize = 3;
    }

    public ArrayHeap(int maxsize) {
        list = new MyArrayList<>(maxsize);
        this.maxsize = maxsize;
        this.size = 0;
    }


    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public T getMin() {
        return list.get(0);
    }

    private void increaseCapacity() {
        maxsize = 2 * maxsize;
    }

    public void insert(T item){
        if (size == 0){
            list.add(item);
        }

        if (size >= maxsize){
//            maxsize++;
            increaseCapacity();
            System.out.println("Che za huina? " + maxsize);
            return;
        }
        size++;
        list.add(item);
        int current = size;

        while(list.get(current).compareTo(list.get(parentOf(current))) > 0 && current > 0){
            swap(current, parentOf(current));
            current = parentOf(current);
        }

        heapifyUp(current);
    }

    private void heapifyUp(int i) {
        T temp = list.get(i);
        while(i > 0 && temp.compareTo(list.get(parentOf(i))) > 0){
            list.remove(i);
            list.add(list.get(parentOf(i)), i);
//            list.get(i) = list.get(parentOf(i));
            i = parentOf(i);
        }
//        list.remove(i);
//        list.add(temp, i);
//        heap[i] = temp;
    }

    private int leftChildOf(int index) {
//        return (2 * index + 1);
        return (2 * index);
    }

    private int rightChildOf(int index) {
//        return (2 * index + 2);
        return (2 * index + 1);
    }

    private int parentOf(int index) {
//        return (index - 1) / 2;
        return (index / 2);
    }

    private void swap(int index1, int index2) {
        T temp;
//        temp = list.get(index1);
        temp = list.get(index1);

        list.remove(index1);
        list.add(list.get(index2), index1);

        list.remove(index2);
        list.add(temp, index2);
    }

    public void print() {
//        list.ShowList();
        list.ShowArray();
    }

//    private int d = 2;
//    private Object[] heap;
//    private int heapSize;
//
//    public MyHeap(int capasity) {
//        heapSize = 0;
//        heap = new Object[capasity + 1];
//        Arrays.fill(heap, -1);
//    }
//
//    public boolean empty() {
//        return heapSize == 0;
//    }
//
//    public int size() {
//        return heapSize;
//    }
//
//    public T getMin() {
//        return (T)heap[0];
//    }
//
//    public T deleteMin() {
//        T popped = (T) heap[0];
//        heap[0] = heap[heapSize--];
//        heapify(0);
//
//        return popped;
//    }
//
//    public void insert(T item) {
//        heap[++heapSize] = item;
//        int current = heapSize;
//
//        while (((Comparable<T>)heap[leftChildOf(current)]).compareTo((T)heap[rightChildOf(current)]) < 0) {
//            swap(current, parentOf(current));
//            current = parentOf(current);
//        }
//    }
//
//    private void heapify(int index) {
//        if (((Comparable<T>)heap[index]).compareTo((T)heap[leftChildOf(index)]) > 0 || ((Comparable<T>)heap[index]).compareTo((T)heap[rightChildOf(index)]) > 0) {
//            if (((Comparable<T>)heap[leftChildOf(index)]).compareTo((T)heap[rightChildOf(index)]) < 0) {
//                swap(index, leftChildOf(index));
//                heapify(leftChildOf(index));
//            } else {
//                swap(index, rightChildOf(index));
//                heapify(rightChildOf(index));
//            }
//        }
//    }
//
//    private void traverseUp(int index) {
//
//    }
//
//    private int leftChildOf(int index) {
//        return d * index + 1;
//    }
//
//    private int rightChildOf(int index) {
//        return d * index + 2;
//    }
//
//    private int parentOf(int index) {
//        return (index - 1) / d;
//    }
//
//    private void swap(int index1, int index2) {
//        T tmp;
//        tmp = (T) heap[index1];
//
//        heap[index1] = heap[index2];
//        heap[index2] = tmp;
//    }
}